package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.gui.EnchantMenu;
import me.jack.jprisoncore.gui.MainMenu;
import me.jack.jprisoncore.gui.MineMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    private PrisonCore instance;

    public InventoryClick(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
            if (event.getInventory().getHolder() instanceof MainMenu) {
                event.setCancelled(true);
                new EnchantMenu().open(player);
            }
        } else if (event.getCurrentItem().getType().equals(Material.CLOCK)) {
            if (event.getInventory().getHolder() instanceof MainMenu) {
                event.setCancelled(true);
                new MineMenu().open(player);
            }
        } else if (event.getCurrentItem().getType().equals(Material.COMPASS)) {
            if (event.getInventory().getHolder() instanceof EnchantMenu || event.getInventory().getHolder() instanceof MineMenu) {
                event.setCancelled(true);
                new MainMenu().open(player);
            }
        }
    }

}
