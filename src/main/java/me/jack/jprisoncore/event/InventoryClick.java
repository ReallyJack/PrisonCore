package me.jack.jprisoncore.event;

import me.jack.jprisoncore.gui.MainMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (player.getInventory() instanceof MainMenu) {
            MainMenu menu = (MainMenu) player.getInventory().getHolder();

            System.out.println(player.getInventory().getHolder().toString() + " menu holder?");
        }
    }
}
