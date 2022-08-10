package com.company.player;

import com.company.gun.Gun;

public class Player {
    private final String name;
    private final Gun[] guns;
    private Gun currentGun;
    private int hitPoint = 100;


    public Player(String name, Gun... guns) {
        this.name = name;
        this.guns = guns;
        currentGun = guns[0];
    }

    public String getName() {
        return name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void reduceHitPoints(int damage) {
        hitPoint -= damage;
        if(hitPoint < 0) {
            hitPoint = 0;
        }
    }

    public boolean isDeath() {
        return hitPoint == 0;
    }

    public Gun getGun(int num) {
        return guns[num];
    }

    public Gun getCurrentGun() {
        return currentGun;
    }

    public void setCurrentGunByNum(int num) {
        currentGun = guns[num];
    }

    public int gunCount() {
        return guns.length;
    }

    public int shoot(Player enemy) {
        int damage = currentGun.shoot();
        enemy.reduceHitPoints(damage);
        return damage;
    }
}
