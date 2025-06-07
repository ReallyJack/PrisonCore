package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.gui.AbstractMenu;
import me.jack.jprisoncore.gui.EnchantMenu;
import me.jack.jprisoncore.gui.MainMenu;
import me.jack.jprisoncore.gui.MineMenu;
import net.minecraft.server.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class InventoryClick implements Listener {

    private PrisonCore instance;

    public InventoryClick(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        User user = instance.getUser(player.getName());

        World world = Bukkit.getServer().getWorld("mineworld" + "." + player.getUniqueId());
        World main = Bukkit.getServer().getWorld("world");

        /*
        if (event.getInventory().getHolder() instanceof MineMenu) {
            if (event.getCurrentItem().getType().equals(Material.COMPASS)) {

                if (player.getWorld().getName().equals(world.getName())) {
                    player.teleport(new Location(main, 0, 0, 0));
                } else {
                    player.teleport(new Location(world, 0, 0, 0));
                }
            }
        }

         */
        if (event.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
            if (event.getInventory().getHolder() instanceof MainMenu) {
                event.setCancelled(true);
                new EnchantMenu().open(player);
            }
        }

        else if (event.getCurrentItem().getType().equals(Material.CLOCK)) {
            if (event.getInventory().getHolder() instanceof MainMenu) {
                event.setCancelled(true);
                new MineMenu().open(player);
            }
        }

        else if (event.getCurrentItem().getType().equals(Material.COMPASS)) {
            if (event.getInventory().getHolder() instanceof EnchantMenu || event.getInventory().getHolder() instanceof MineMenu) {
                event.setCancelled(true);
                new MainMenu().open(player);
            }
        }
    }
}
