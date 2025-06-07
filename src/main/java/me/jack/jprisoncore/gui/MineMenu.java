package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.User;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MineMenu extends AbstractMenu {

    public MineMenu() {
        super(54, "Mine Menu");

        initializeItems();
    }

    @Override
    public void initializeItems() {
        ItemStack block = new ItemStack(Material.DIAMOND_BLOCK);
        ItemStack reset = new ItemStack(Material.MAP);
        ItemStack compass = new ItemStack(Material.COMPASS);

        getInventory().setItem(0, block);
        getInventory().setItem(1, reset);
        getInventory().setItem(53, compass);
    }

}
