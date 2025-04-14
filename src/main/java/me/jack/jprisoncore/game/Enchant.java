package me.jack.jprisoncore.game;

import org.bukkit.inventory.ItemStack;

public class Enchant {

    public static int COOLDOWN_TIMER = 60;

    private String name;
    private ItemStack item;
    private int level;

    public Enchant(String name, ItemStack item, int level) {
        this.name = name;
        this.item = item;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getLevel() {
        return level;
    }

}
