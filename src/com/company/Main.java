package com.company;

import com.company.gun.Grenade;
import com.company.gun.Gun;
import com.company.gun.Revolver;
import com.company.gun.Shotgun;
import com.company.player.Bot;
import com.company.player.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Мент", new Revolver(), new Shotgun(), new Grenade());
        Player player2 = getPlayer2();

        Game game = new Game(player1, player2);
        game.go();
    }

    private static Player getPlayer2() {
        Scanner sc = new Scanner(System.in);
        final String name = "Бандит";
        final Gun[] guns = new Gun[] {new Revolver(), new Shotgun(), new Grenade()};

        while(true) {
            System.out.print("Второй игрок: 1 - человек, 2- бот: ");
            String command = sc.next();

            if(command.equals("1")) {
                return new Player(name, guns);
            } else if(command.equals("2")) {
                return new Bot(name, guns);
            }
        }

    }
}
