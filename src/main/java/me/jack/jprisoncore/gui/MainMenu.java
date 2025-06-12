package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.User;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super(27, "Main Menu");

    }

    @Override
    public void initializeItems(User user) {

        ItemStack block = new ItemStack(Material.DIAMOND_BLOCK);
        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemStack filler = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);

        ItemMeta compassMeta = compass.getItemMeta();

        if (Bukkit.getPlayer(user.getName()).getWorld().getName() == Bukkit.getWorld("world").getName()) {
            compassMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.GREEN + "PRIVATE MINE");
        } else {
            compassMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.GREEN + "SPAWN");
        }
        compassMeta.setLore(null);
        compass.setItemMeta(compassMeta);

        ItemMeta clockMeta = clock.getItemMeta();
        clockMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + "RESET MINE");
        clockMeta.setLore(Arrays.asList("TODO", "FIX", "LORE"));
        clock.setItemMeta(clockMeta);

        ItemMeta blockMeta = block.getItemMeta();
        blockMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + "CHANGE BLOCKS");
        blockMeta.setLore(Arrays.asList("TODO", "FIX", "LORE"));
        block.setItemMeta(blockMeta);

        for (int i = 0; i < getInventory().getSize(); i++) {
            getInventory().setItem(i, filler);
        }

        getInventory().setItem(11, block);
        getInventory().setItem(13, clock);
        getInventory().setItem(15, compass);


    }


}
