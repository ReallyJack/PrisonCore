package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.User;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MineMenu extends AbstractMenu {

    public MineMenu() {
        super(54, "Mine Menu");
    }

    @Override
    public void initializeItems(User user) {
        ItemStack block1 = new ItemStack(Material.COAL_BLOCK);
        ItemStack block2 = new ItemStack(Material.IRON_BLOCK);
        ItemStack block3 = new ItemStack(Material.GOLD_BLOCK);
        ItemStack block4 = new ItemStack(Material.DIAMOND_BLOCK);
        ItemStack block5 = new ItemStack(Material.REDSTONE_BLOCK);
        ItemStack block6 = new ItemStack(Material.GLOWSTONE);
        ItemStack block7 = new ItemStack(Material.REDSTONE_ORE);
        ItemStack block8 = new ItemStack(Material.EMERALD_BLOCK);
        ItemStack block9 = new ItemStack(Material.COAL_ORE);
        ItemStack block10 = new ItemStack(Material.IRON_ORE);
        ItemStack block11 = new ItemStack(Material.GOLD_ORE);
        ItemStack block12 = new ItemStack(Material.DIAMOND_ORE);
        ItemStack block13 = new ItemStack(Material.EMERALD_ORE);
        ItemStack block14 = new ItemStack(Material.LAPIS_BLOCK);
        ItemStack block15 = new ItemStack(Material.LAPIS_ORE);
        ItemStack block16 = new ItemStack(Material.HAY_BLOCK);
        ItemStack block17 = new ItemStack(Material.DIRT);
        ItemStack block18 = new ItemStack(Material.STONE);
        ItemStack block19 = new ItemStack(Material.COBBLESTONE);
        ItemStack block20 = new ItemStack(Material.BRICK);
        ItemStack block21 = new ItemStack(Material.NETHERRACK);
        ItemStack block22 = new ItemStack(Material.NETHER_BRICK);
        ItemStack block23 = new ItemStack(Material.END_STONE);
        ItemStack block24 = new ItemStack(Material.END_STONE_BRICKS);

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.GRAY + "Return");
        compassMeta.setLore(null);
        compass.setItemMeta(compassMeta);

        getInventory().setItem(0, block1);
        getInventory().setItem(1, block2);
        getInventory().setItem(2, block3);
        getInventory().setItem(3, block4);
        getInventory().setItem(4, block5);
        getInventory().setItem(5, block6);
        getInventory().setItem(6, block7);
        getInventory().setItem(7, block8);
        getInventory().setItem(8, block9);
        getInventory().setItem(9, block10);
        getInventory().setItem(10, block11);
        getInventory().setItem(11, block12);
        getInventory().setItem(12, block13);
        getInventory().setItem(13, block14);
        getInventory().setItem(14, block15);
        getInventory().setItem(15, block16);
        getInventory().setItem(16, block17);
        getInventory().setItem(17, block18);
        getInventory().setItem(18, block19);
        getInventory().setItem(19, block20);
        getInventory().setItem(20, block21);
        getInventory().setItem(21, block22);
        getInventory().setItem(22, block23);
        getInventory().setItem(23, block24);

        getInventory().setItem(53, compass);
    }


}
