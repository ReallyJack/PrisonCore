package me.jack.jprisoncore;

import me.jack.jprisoncore.event.Interact;
import me.jack.jprisoncore.event.InventoryClick;
import me.jack.jprisoncore.event.Join;
import me.jack.jprisoncore.game.User;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class PrisonCore extends JavaPlugin {


    public List<User> users;

    @Override
    public void onEnable() {

        this.users = new ArrayList<>();
        this.users.add(new User("ExampleUser1", null, 220.0, 5, false, null, null));
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new Interact(this), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new Join(this), this);

        /*
        ConfigurationSection rankSection = getConfig().getConfigurationSection("ranks");
        Set<String> rankKeys = rankSection.getKeys(false);
        ConfigurationSection prestigeSection = getConfig().getConfigurationSection("prestige-ranks");
        Set<String> prestigeKeys = prestigeSection.getKeys(false);
        ConfigurationSection privateMinesSection = getConfig().getConfigurationSection("private-mines");
        Set<String> privateMineKeys = privateMinesSection.getKeys(false);
        ConfigurationSection prestigeMinesSection = getConfig().getConfigurationSection("prestige-mines");
        Set<String> prestigeMineKeys = prestigeMinesSection.getKeys(false);
        ConfigurationSection blocksSection = getConfig().getConfigurationSection("blocks");
        Set<String> blockKeys = blocksSection.getKeys(false);


         */





    }

    @Override
    public void onDisable() {

        Map<String, Integer> rankMap = new HashMap<>();
        rankMap.put("1", 1000);
        rankMap.put("2", 2000);
        rankMap.put("3", 3000);

        getConfig().set("ranks", rankMap);

        Map<String, Integer> prestigeSection = new HashMap<>();
        prestigeSection.put("p1", 10000);
        prestigeSection.put("p2", 20000);
        prestigeSection.put("p3", 30000);

        getConfig().set("prestige-ranks", prestigeSection);

        Map<String, Location> privateMines = new HashMap<>();
        privateMines.put("mine1", new Location(Bukkit.getWorld("world"), 1,2,3,4,5));
        privateMines.put("mine2", new Location(Bukkit.getWorld("world"), 1,2,3,4,5));
        privateMines.put("mine3", new Location(Bukkit.getWorld("world"), 1,2,3,4,5));

        getConfig().set("private-mines", privateMines);

        Map<String, Integer> blocksMap = new HashMap<>();
        blocksMap.put("Dirt", 250);
        blocksMap.put("Cobblestone", 100);
        blocksMap.put("Sand", 50);

        getConfig().set("blocks", blocksMap);


        for (User user : users) {
            getConfig().set("users." + user.getName() + ".rank", user.getRank());
            getConfig().set("users." + user.getName() + ".balance", user.getBalance());
            getConfig().set("users." + user.getName() + ".tokens", user.getTokens());
            getConfig().set("users." + user.getName() + ".prestige", user.isPrestige());
            getConfig().set("users." + user.getName() + ".enchants", user.getEnchantList());


        }

        saveConfig();
    }

    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

}
