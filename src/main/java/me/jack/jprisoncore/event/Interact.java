package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.gui.MainMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener {

    private PrisonCore instance;

    public Interact(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_PICKAXE)) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {


                MainMenu menu = new MainMenu(instance.getUser(player.getName()));

                menu.open(player);
            }
        }
    }

}
