package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.User;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super(9, "Main Menu");

        initializeItems();
    }

    @Override
    public void initializeItems() {

        ItemStack zero = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemStack one = new ItemStack(Material.CLOCK);
        ItemStack two = new ItemStack(Material.COMPASS);

        getInventory().setItem(3, zero);
        getInventory().setItem(4, one);
        getInventory().setItem(5, two);
    }


}
