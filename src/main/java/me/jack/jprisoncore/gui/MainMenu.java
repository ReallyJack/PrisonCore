package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MainMenu extends AbstractMenu {

    public MainMenu(User holder) {
        super(holder, 9, "Main Menu");

    }

    @Override
    protected void initializeItems() {
        getInventory().setItem(0, new ItemStack(Material.BOOK));
        getInventory().setItem(1, new ItemStack(Material.BOOK));
        getInventory().setItem(2, new ItemStack(Material.BOOK));
        getInventory().setItem(3, new ItemStack(Material.BOOK));
        getInventory().setItem(4, new ItemStack(Material.BOOK));
        getInventory().setItem(5, new ItemStack(Material.BOOK));
        getInventory().setItem(6, new ItemStack(Material.BOOK));
        getInventory().setItem(7, new ItemStack(Material.BOOK));
        getInventory().setItem(8, new ItemStack(Material.BOOK));

    }

    @Override
    public void handleClick(InventoryClickEvent event) {
        event.setCancelled(true);

        ItemStack clickedItem = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();

        if (clickedItem == null || clickedItem.getType() == Material.AIR || !clickedItem.hasItemMeta()) {
            return;
        }

    }

}
