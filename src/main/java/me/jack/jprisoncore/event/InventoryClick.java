package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.gui.EnchantMenu;
import me.jack.jprisoncore.gui.MainMenu;
import me.jack.jprisoncore.gui.MineMenu;
import me.jack.jprisoncore.mine.PrivateMine;
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.IOException;

public class InventoryClick implements Listener {

    private PrisonCore instance;

    public InventoryClick(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        User user = instance.getUser(player.getName());

        if (event.getInventory().getHolder() instanceof MainMenu) {
            event.setCancelled(true);
            if (event.getCurrentItem().getType().equals(Material.DIAMOND_BLOCK)) {

                MineMenu mineMenu = new MineMenu();
                mineMenu.initializeItems(user);
                mineMenu.open(player);

            } else if (event.getCurrentItem().getType().equals(Material.CLOCK)) {

                user.getPrivateMine().initializeMine(Bukkit.getServer().getWorld("mineworld." + player.getUniqueId()), null);
                player.closeInventory();
                player.sendMessage("Mine reset");

                if (player.getWorld().getName() != Bukkit.getWorld("world").getName()) {
                    player.teleport(player.getWorld().getSpawnLocation());
                }

            } else if (event.getCurrentItem().getType().equals(Material.COMPASS)) {

                System.out.println(user.isInMine() + "click 1");
                if (!user.isInMine()) {
                    World w = Bukkit.getServer().getWorld("mineworld." + player.getUniqueId());

                    if (w == null) {
                        WorldCreator wc = new WorldCreator("mineworld." + player.getUniqueId());
                        wc.createWorld();

                        PrivateMine pmine = user.getPrivateMine();
                        pmine.setPoint1(new Location(Bukkit.getWorld("mineworld." + player.getUniqueId()), instance.point1.get(0), instance.point1.get(1), instance.point1.get(2)));
                        pmine.setPoint2(new Location(Bukkit.getWorld("mineworld." + player.getUniqueId()), instance.point2.get(0), instance.point2.get(1), instance.point2.get(2)));

                        pmine.initializeMine(Bukkit.getWorld("mineworld." + player.getUniqueId()), null);
                        pmine.setSpawn();
                    }
                    //user.getPrivateMine().initilizeMine(w);

                    player.teleport(Bukkit.getServer().getWorld("mineworld." + player.getUniqueId()).getSpawnLocation());
                    user.setInMine(true);
                    System.out.println("after tp " + user.isInMine());
                } else {

                    player.teleport(new Location(Bukkit.getServer().getWorld("world"), 0, 100, 0));
                    user.setInMine(false);
                    System.out.println("after tp from mine " + user.isInMine());
                }
            }
        } else if (event.getInventory().getHolder() instanceof EnchantMenu || event.getInventory().getHolder() instanceof MineMenu) {
            event.setCancelled(true);
            if (event.getCurrentItem().getType().equals(Material.COMPASS)) {

                MainMenu mainMenu = new MainMenu();
                mainMenu.initializeItems(user);
                mainMenu.open(player);

            }

        }
        if (event.getInventory().getHolder() instanceof MineMenu) {

            instance.getUser(player.getName()).getPrivateMine().initializeMine(Bukkit.getServer().getWorld("mineworld." + player.getUniqueId()), event.getCurrentItem().getType());
            player.closeInventory();
            player.sendMessage("Blocks updated!");
        }

    }
}

