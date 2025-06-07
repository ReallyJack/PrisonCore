package me.jack.jprisoncore.game;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Enchant {

    JACKHAMMER("Jack Hammer", 100.0D, new ItemStack(Material.ANVIL)),
    KEYFINDER("Key Finder", 100.0D, new ItemStack(Material.NAME_TAG)),
    TOKENGREED("Jack Hammer", 100.0D, new ItemStack(Material.TOTEM_OF_UNDYING)),
    FORTUNE("Jack Hammer", 100.0D, new ItemStack(Material.DIAMOND)),
    AUTOSELL("Jack Hammer", 100.0D, new ItemStack(Material.EMERALD)),
    EFFICIENCY("Jack Hammer", 100.0D, new ItemStack(Material.DIAMOND_AXE)),
    HASTE("Jack Hammer", 100.0D, new ItemStack(Material.SUGAR)),
    MAGNET("Jack Hammer", 100.0D, new ItemStack(Material.MAGENTA_DYE)),
    NUKE("Jack Hammer", 100.0D, new ItemStack(Material.GLOWSTONE)),
    LUCKYMINING("Jack Hammer", 100.0D, new ItemStack(Material.GOLDEN_PICKAXE)),
    MONEYBOOSTER("Jack Hammer", 100.0D, new ItemStack(Material.GREEN_CANDLE)),
    TOKENMAGNET("Jack Hammer", 100.0D, new ItemStack(Material.BONE_MEAL)),
    XPFINDER("Jack Hammer", 100.0D, new ItemStack(Material.TURTLE_SCUTE)),
    BACKPACK("Jack Hammer", 100.0D, new ItemStack(Material.CHEST)),
    COMBO("Jack Hammer", 100.0D, new ItemStack(Material.HONEYCOMB)),
    LAZER("Jack Hammer", 100.0D, new ItemStack(Material.REDSTONE)),
    PICKAXEXP("Jack Hammer", 100.0D, new ItemStack(Material.EXPERIENCE_BOTTLE)),
    BLACKHOLE("Jack Hammer", 100.0D, new ItemStack(Material.ENDER_EYE)),
    LUCKYENCHANT("Key Finder", 100.0D, new ItemStack(Material.ENCHANTED_BOOK));

    private String name;
    private double price;
    private ItemStack item;

    Enchant(String name, double price, ItemStack item) {
        this.name = name;
        this.price = price;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ItemStack getItem() {
        return item;
    }

}
