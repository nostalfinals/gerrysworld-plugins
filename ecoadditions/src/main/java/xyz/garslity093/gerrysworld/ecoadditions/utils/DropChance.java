package xyz.garslity093.gerrysworld.ecoadditions.utils;

import java.util.Random;

/*掉落机会工具类*/
public final class DropChance {
    public double chance;

    public double min;

    public double max;

    public DropChance(double chance, double min, double max) {
        this.chance = chance;
        this.min = min;
        this.max = max;
    }

    /*通过随机生成这次是否掉落*/
    public boolean willThisTimeDrop() {
        Random random = new Random();
        int randomInt = random.nextInt(1, 101);
        return randomInt <= chance * 100;
    }

    /*根据掉落区间随机生成一次掉落的数量*/
    public double randomDropAmount() {
        return new Random().nextDouble(min, max);
    }
}