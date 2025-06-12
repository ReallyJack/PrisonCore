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
    private String title;
    private int size;

    public AbstractMenu(int size, String title) {
        this.title = title;
        this.size = size;

        this.inventory = Bukkit.createInventory(this, size, title);
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    protected abstract void initializeItems(User user);

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    public int getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

}
