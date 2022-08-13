package com.company;

import com.company.gun.Grenade;
import com.company.gun.Revolver;
import com.company.gun.Shotgun;
import com.company.player.Bot;
import com.company.player.Player;

import java.util.Locale;
import java.util.Scanner;

public class Game {

    public static final String COMMAND_SHOOT = "+";

    private final Player player1;
    private final Player player2;
    private Player current;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        current = player1;
    }

    public void go() {
        Scanner sc = new Scanner(System.in);

        show();
        while (!isGameOver()) {
            System.out.printf("%s [%s], ваш ход: ", current.getName().toUpperCase(Locale.ROOT), current.getCurrentGun().getName());
            String command;

            if(current instanceof Bot) {
                command = ((Bot)current).getCommand();
                System.out.println(command);
            } else {
                command = sc.next();
            }

            if (command.equals(COMMAND_SHOOT)) {
                Player other = otherPlayer();
                int damage = current.shoot(other);

                System.out.printf("%nВЫСТРЕЛ! Урон: %d  %n%n", damage);
                System.out.print("Для продолжения нажмите Enter");
                new Scanner(System.in).nextLine();

                changePlayer();

            } else {
                int gunNumber = Integer.parseInt(command);
                current.setCurrentGunByNum(gunNumber);
                continue;
            }

            show();
        }

        System.out.println("Игра окончена! Победил " + winPlayer().getName().toUpperCase(Locale.ROOT));
    }

    private boolean isGameOver() {
        return player1.isDeath() || player2.isDeath();
    }

    private Player winPlayer() {
        if (player1.isDeath()) {
            return player2;
        }

        if (player2.isDeath()) {
            return player1;
        }

        return null;
    }

    private Player otherPlayer() {
        return current == player1 ? player2 : player1;
    }

    private void changePlayer() {
        current = (current == player1) ? player2 : player1;
    }

    private void show() {
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("              %-20s    %-20s %n", player1.getName(), player2.getName());
        System.out.printf("Здоровье:     %-20d    %-20d %n", player1.getHitPoint(), player2.getHitPoint());

        String player1GunName = player1.getCurrentGun().getName().toUpperCase(Locale.ROOT);
        String player2GunName = player2.getCurrentGun().getName().toUpperCase(Locale.ROOT);

        System.out.printf("Оружие:       %-20s    %-20s %n", player1GunName, player2GunName);
        System.out.printf("Урон, шанс:   %-20s    %-20s %n", player1.getCurrentGun().info(), player2.getCurrentGun().info());
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("Команды:      %s выстрел, 0 - %d поменять оружие %n", COMMAND_SHOOT, current.gunCount() - 1);
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
        System.out.println("Доступное оружие:");
        for (int i = 0; i < current.gunCount(); i++) {
            System.out.printf("%d - %s (%s)  %n", i, current.getGun(i).getName(), current.getGun(i).info());
        }
        System.out.println("...");
        System.out.println();
    }

}
