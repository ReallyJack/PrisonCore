package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.Enchant;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.mine.PrivateMine;
import me.jack.jprisoncore.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Join implements Listener {

    private PrisonCore instance;

    public Join(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        File file = new File(instance.getDataFolder(), "user.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        String UUID = player.getUniqueId().toString();

        for (String key : config.getKeys(true)) {
            System.out.println(key + " key");
            int balance = config.getInt("users." + UUID + ".balance");
            int tokens = config.getInt("users." + UUID + ".tokens");
            int level = config.getInt("users." + UUID + ".level");
            Rank rank = Rank.getRankByPrefix(config.getString("users." + UUID + ".rank"));
            boolean isPrestige = config.getBoolean("users." + UUID + ".isPrestige");
            List<Enchant> enchants = new ArrayList<>();

            for (String enchant : config.getStringList("users." + UUID + ".enchants")) {
                //  String modified = enchant.toUpperCase().replace(" ", "");
                enchants.add(Enchant.valueOf(enchant.toUpperCase().replace(" ", "")));
            }

            User user = new User(player.getName(), balance, tokens, level, rank, isPrestige, enchants);
            instance.users.add(user);

        }

        User user = instance.getUser(player.getName());

        if (user == null) {
            user = new User(player.getName(), 100.0, 0, 1, Rank.getRankByID(1), false, new ArrayList<>());
        }

        PrivateMine pmine = new PrivateMine(instance, user, null, null);
        pmine.create(user);
        user.setPrivateMine(pmine);

        player.setDisplayName(ChatColor.GRAY + "[" + ChatColor.RED + user.getRank().getPrefix() + ChatColor.GRAY + "] " + ChatColor.WHITE + player.getName());
        player.setPlayerListName(ChatColor.GRAY + "[" + ChatColor.RED + user.getRank().getPrefix() + ChatColor.GRAY + "] " + ChatColor.WHITE + player.getName());

        player.setLevel(1);


    }
}
