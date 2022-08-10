package com.company.gun;

public class Shotgun extends Gun {
    private static final String NAME = "Обрез";
    private static final int DAMAGE_MIN = 25;
    private static final int DAMAGE_MAX = 40;
    private static final int CHANCE = 50;


    public Shotgun() {
        super(NAME, DAMAGE_MIN, DAMAGE_MAX, CHANCE);
    }

}
