package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.Enchant;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EnchantMenu extends AbstractMenu {

    public EnchantMenu() {
        super(54, "Enchant Menu");

        initializeItems();
    }

    @Override
    public void initializeItems() {
        ItemStack compass = new ItemStack(Material.COMPASS);

        for (Enchant e : Enchant.values()) {
            getInventory().addItem(e.getItem());
        }
        getInventory().setItem(53, compass);
    }


}
