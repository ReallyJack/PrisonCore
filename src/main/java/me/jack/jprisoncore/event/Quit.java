package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.Enchant;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.rank.Rank;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quit implements Listener {

    private PrisonCore instance;

    public Quit(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) throws IOException {
        Player player = event.getPlayer();
        User user = instance.getUser(player.getName());

        File file = new File(PrisonCore.getPlugin(PrisonCore.class).getDataFolder(), "user.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        String UUID = player.getUniqueId().toString();
        String name = user.getName();
        int level = user.getLevel();
        double balance = user.getBalance();
        int tokens = user.getTokens();
        Rank rank = user.getRank();
        List<Enchant> enchants = user.getEnchantList();
        List<String> enchantNames = new ArrayList<>();

        for (Enchant e : enchants) {
            enchantNames.add(e.getName());
        }

        config.set("users." + UUID + ".name", name);
        config.set("users." + UUID + ".balance", balance);
        config.set("users." + UUID + ".tokens", tokens);
        config.set("users." + UUID + ".level", level);
        config.set("users." + UUID + ".rank", rank.getPrefix());
        config.set("users." + UUID + ".enchants", enchantNames);

        config.save(file);
    }


}
