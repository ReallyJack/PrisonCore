package me.jack.jprisoncore.gui;

import me.jack.jprisoncore.game.Enchant;
import me.jack.jprisoncore.game.User;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EnchantMenu extends AbstractMenu {

    public EnchantMenu() {
        super(54, "Enchant Menu");

    }

    @Override
    public void initializeItems(User user) {
        for (Enchant e : Enchant.values()) {
            ItemStack item = e.getItem();
            ItemMeta meta = item.getItemMeta();

            if (user.getEnchantList().contains(e)) {
                meta.setDisplayName(ChatColor.BOLD + "" + ChatColor.GREEN + e.getName());
                meta.setLore(Arrays.asList(ChatColor.GREEN + "UNLOCKED",
                        "\n",
                        ChatColor.GRAY + "Description: ", "fix",
                        "\n",
                        ChatColor.GRAY + "Level: " + user.getLevel() + "/50")
                );
            } else {
                meta.setDisplayName(ChatColor.BOLD + "" + ChatColor.RED + e.getName());
                meta.setLore(Arrays.asList(ChatColor.RED + "LOCKED",
                        "\n",
                        ChatColor.GRAY + "Price: $" + e.getPrice(),
                        ChatColor.GRAY + "Description: ", "fix",
                        "\n",
                        ChatColor.GRAY + "Level: " + user.getLevel() + "/50")
                );
            }

            item.setItemMeta(meta);

            getInventory().addItem(item);
        }
    }


}
