package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.gui.EnchantMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener {

    private PrisonCore instance;

    public Interact(PrisonCore instance) {
        this.instance = instance;
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        User user = instance.getUser(player.getName());

        if (player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_PICKAXE)) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

                EnchantMenu menu = new EnchantMenu();
                menu.initializeItems(user);
                menu.open(player);
            }
        }
    }

    @EventHandler
    public void onDropPickaxe(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        User user = instance.getUser(player.getName());
        if (event.getItemDrop().getItemStack().getType().equals(Material.DIAMOND_PICKAXE)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onThrowPickaxe(InventoryClickEvent event) {
        if (event.getClick() == ClickType.DROP) {
            if (event.getCurrentItem().getType() == Material.DIAMOND_PICKAXE) {
                event.setCancelled(true);
            }
        }
    }
}
