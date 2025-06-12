package me.jack.jprisoncore;

import me.jack.jprisoncore.command.MineCommand;
import me.jack.jprisoncore.event.*;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.mine.PrivateMine;
import me.jack.jprisoncore.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PrisonCore extends JavaPlugin {

    //TODO add prestige system, xp level system, tokens and money earning, enchant effects and levels.

    public List<User> users;

    public List<Integer> point1;
    public List<Integer> point2;

    @Override
    public void onEnable() {
        this.users = new ArrayList<>();

        this.point1 = new ArrayList<>();
        this.point2 = new ArrayList<>();

        saveDefaultConfig();
        saveResource("user.yml", false);

        getServer().getPluginManager().registerEvents(new Interact(this), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
        getServer().getPluginManager().registerEvents(new Join(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(this), this);
        getServer().getPluginManager().registerEvents(new Quit(this), this);

        getCommand("pmine").setExecutor(new MineCommand(this));

        getCommand("rankup").setExecutor(new MineCommand(this));
        getCommand("rank").setExecutor(new MineCommand(this));
        getCommand("balance").setExecutor(new MineCommand(this));
        getCommand("setbal").setExecutor(new MineCommand(this));
        getCommand("unlock").setExecutor(new MineCommand(this));
        getCommand("lock").setExecutor(new MineCommand(this));
        getCommand("sell").setExecutor(new MineCommand(this));

        Rank.loadRanks("rank.yml");

        //TODO LOAD INTO ARRAY
        ConfigurationSection area = getConfig().getConfigurationSection("private-mine-area");

        int p1x = area.getInt("point1.x");
        int p1y = area.getInt("point1.y");
        int p1z = area.getInt("point1.z");

        int p2x = area.getInt("point2.x");
        int p2y = area.getInt("point2.y");
        int p2z = area.getInt("point2.z");

        point1.add(p1x);
        point1.add(p1y);
        point1.add(p1z);

        point2.add(p2x);
        point2.add(p2y);
        point2.add(p2z);

        System.out.println(point1.get(0) + " " + point1.get(1) + " " + point1.get(2) + " " + point2.get(0) + " " + point2.get(1) + " " + point2.get(2));
    }

    @Override
    public void onDisable() {

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
