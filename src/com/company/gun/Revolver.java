package com.company.gun;

public class Revolver extends Gun{
    private static final String NAME = "Револьвер";
    private static final int DAMAGE_MIN = 10;
    private static final int DAMAGE_MAX = 25;
    private static final int CHANCE = 80;

    public Revolver() {
        super(NAME, DAMAGE_MIN, DAMAGE_MAX, CHANCE);
    }
}
