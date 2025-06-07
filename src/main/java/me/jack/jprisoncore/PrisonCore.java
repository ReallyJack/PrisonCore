package me.jack.jprisoncore;

import me.jack.jprisoncore.command.MineCommand;
import me.jack.jprisoncore.event.Interact;
import me.jack.jprisoncore.event.InventoryClick;
import me.jack.jprisoncore.event.Join;
import me.jack.jprisoncore.game.Enchant;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.rank.Rank;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class PrisonCore extends JavaPlugin {


    public List<User> users;

    @Override
    public void onEnable() {

        User user1 = new User("ExampleUser1", 2000.0D, 0, false, null);
        this.users = new ArrayList<>();
        this.users.add(user1);
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new Interact(this), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
        getServer().getPluginManager().registerEvents(new Join(this), this);

        getCommand("rankup").setExecutor(new MineCommand(this));

        Rank.loadRanks("rank.yml");

        user1.setRank(Rank.getRankByID(1));
        Rank rank = user1.getRank();

        rank.promoteUser(user1);

        System.out.println(user1.getRank().getPrefix() + " new rank");

        for (Enchant enchant : Enchant.values()) {
            System.out.println(enchant.getItem());
        }
    }

    @Override
    public void onDisable() {

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
