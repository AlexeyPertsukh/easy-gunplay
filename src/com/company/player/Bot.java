package com.company.player;

import com.company.Game;
import com.company.gun.Gun;

public class Bot extends Player{
    private String command;

    public Bot(String name, Gun... guns) {
        super(name, guns);
    }

    @Override
    public String getName() {
        return super.getName() + " [bot]";
    }

    public String getCommand() {
        if(command == null || command.equals(Game.COMMAND_SHOOT)) {
            command = String.format("%d",(int)(Math.random() * gunCount()));
        } else {
            command = Game.COMMAND_SHOOT;
        }
        return command;
    }
}
