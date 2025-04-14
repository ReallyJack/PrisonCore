package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.User;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractMenu implements InventoryHolder {

    private Inventory inventory;
    private User viewer;
    private String title;
    private int size;

    public AbstractMenu(User viewer, int size, String title) {
        this.viewer = viewer;
        this.title = title;
        this.size = size;
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    protected abstract void initializeItems();

    protected abstract void handleClick(InventoryClickEvent event);

    public void open(Player player) {
            player.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public User getViewer() {
        return viewer;
    }

    public int getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }
}
