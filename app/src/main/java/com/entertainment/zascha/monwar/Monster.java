package com.entertainment.zascha.monwar;

/**
 * Created by Sascha on 22.05.2016.
 */
public class Monster {

    private int id;
    private String name;
    private int[] stats;


    public Monster(int id, String name, int[] stats){

        this.id = id;
        this.name = name;
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }
}
