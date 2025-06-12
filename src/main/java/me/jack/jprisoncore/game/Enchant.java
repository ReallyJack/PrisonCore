package me.jack.jprisoncore.game;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Enchant {

    EXPLOSIVE("Explosive", 100.0D, new ItemStack(Material.TNT)),
    JACKHAMMER("Jack Hammer", 100.0D, new ItemStack(Material.ANVIL)),
    KEYFINDER("Key Finder", 100.0D, new ItemStack(Material.NAME_TAG)),
    TOKENGREED("Token Greed", 100.0D, new ItemStack(Material.TOTEM_OF_UNDYING)),
    FORTUNE("Fortune", 100.0D, new ItemStack(Material.DIAMOND)),
    AUTOSELL("Auto Sell", 100.0D, new ItemStack(Material.EMERALD)),
    EFFICIENCY("Efficiency", 100.0D, new ItemStack(Material.DIAMOND_AXE)),
    HASTE("Haste", 100.0D, new ItemStack(Material.SUGAR)),
    MAGNET("Magnet", 100.0D, new ItemStack(Material.MAGENTA_DYE)),
    NUKE("Nuke", 100.0D, new ItemStack(Material.GLOWSTONE)),
    LUCKYMINING("Lucky Mining", 100.0D, new ItemStack(Material.GOLDEN_PICKAXE)),
    MONEYBOOSTER("Money Booster", 100.0D, new ItemStack(Material.GREEN_CANDLE)),
    TOKENMAGNET("Token Magnet", 100.0D, new ItemStack(Material.BONE_MEAL)),
    XPFINDER("XP Finder", 100.0D, new ItemStack(Material.TURTLE_SCUTE)),
    BACKPACK("Backpack", 100.0D, new ItemStack(Material.CHEST)),
    COMBO("Combo", 100.0D, new ItemStack(Material.HONEYCOMB)),
    LAZER("Lazer", 100.0D, new ItemStack(Material.REDSTONE)),
    PICKAXEXP("Pickaxe XP", 100.0D, new ItemStack(Material.EXPERIENCE_BOTTLE)),
    BLACKHOLE("Black Hole", 100.0D, new ItemStack(Material.ENDER_EYE)),
    LUCKYENCHANT("Lucky Enchant", 100.0D, new ItemStack(Material.ENCHANTED_BOOK));

    private String name;
    private double price;
    private ItemStack item;
    private ItemMeta meta;

    Enchant(String name, double price, ItemStack item) {
        this.name = name;
        this.price = price;
        this.item = item;
        this.meta = item.getItemMeta();
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

    public ItemMeta getMeta() {
        return meta;
    }


    public void applyEffects(BlockBreakEvent event) {

        switch (this) {
            case EXPLOSIVE:
                break;
            case JACKHAMMER:
                Location startLocation = event.getBlock().getLocation();

                for (int i = 0; i < 10; i++) {
                    Location currentLocation = startLocation.clone().subtract(0, i, 0);
                    Block block = startLocation.getWorld().getBlockAt(currentLocation);
                    block.setType(Material.AIR);
                }

                break;
            case KEYFINDER:
                System.out.println("KEYFINDER working");
                break;
            case TOKENGREED:
                System.out.println("TOKENGREED working");
                break;
            case FORTUNE:
                System.out.println("FORTUNE working");
                break;
            case AUTOSELL:
                System.out.println("AUTOSELL working");
                break;
            case EFFICIENCY:
                System.out.println("EFFICIENCY working");
                break;
            case HASTE:
                System.out.println("HASTE working");
                break;
            case MAGNET:
                System.out.println("MAGNET working");
                break;
            case NUKE:
                System.out.println("NUKE working");
                break;
            case LUCKYMINING:
                System.out.println("LUCKYMINING working");
                break;
            case MONEYBOOSTER:
                System.out.println("MONEYBOOSTER working");
                break;
            case TOKENMAGNET:
                System.out.println("TOKENMAGNET working");
                break;
            case XPFINDER:
                System.out.println("XPFINDER working");
                break;
            case BACKPACK:
                System.out.println("BACKPACK working");
                break;
            case COMBO:
                System.out.println("COMBO working");
                break;
            case LAZER:
                System.out.println("LAZER working");
                break;
            case PICKAXEXP:
                System.out.println("PICKAXEXP working");
                break;
            case BLACKHOLE:
                System.out.println("BLACKHOLE working");
                break;
            case LUCKYENCHANT:
                System.out.println("LUCKYENCHANT working");
                break;
        }
    }

}
