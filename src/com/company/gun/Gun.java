package com.company.gun;

public abstract class Gun {
    private final String name;
    private final int damageMin;  //максимальный урон
    private final int damageMax;  //минимальный урон
    private final int chance;     //вероятность попадания, в процентах

    public Gun(String name, int damageMin, int damageMax, int chance) {
        this.name = name;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public int shoot() {
        boolean isHit = chance >= randomInt(0, 100);    //попал?
        if(!isHit) {
            return 0;
        }

        return randomInt(damageMin, damageMax);
    }

    public String info() {
        return String.format("%d-%d↯, %d%%", damageMin, damageMax, chance);
    }

    private static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}
