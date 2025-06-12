package me.jack.jprisoncore.rank;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Rank {

    private String prefix;
    private int price;
    private String color;

    public static Map<Integer, Rank> ranks = new HashMap<>();

    public Rank(String prefix, String color) {
        this.prefix = prefix;
        this.color = color;
    }

    public Rank(String prefix, int price, String color) {
        this.prefix = prefix;
        this.price = price;
        this.color = color;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Rank getNextRank() {
        for (Map.Entry<Integer, Rank> ranks : ranks.entrySet()) {
            if (ranks.getValue() == this) {
                System.out.println(this.getPrefix() + this.getPrice() + this.getColor() + " current rank");
                int ID = ranks.getKey();
                Rank next = Rank.ranks.get(ID + 1);

                System.out.println(next.getPrefix() + " next rank");
                return next;
            }
        }
        return null;
    }


    public static Rank getRankByID(int ID) {
        for (Map.Entry<Integer, Rank> rank : ranks.entrySet()) {
            if (rank.getKey() == ID) {
                return rank.getValue();
            }
        }
        return null;
    }

    public static Rank getRankByPrefix(String prefix) {
        for (Map.Entry<Integer, Rank> rank : ranks.entrySet()) {
            if (rank.getValue().getPrefix().equals(prefix)) {
                return rank.getValue();
            }
        }
        return null;
    }
    public void promoteUser(User user) {
        Rank next = user.getRank().getNextRank();

        double balance = user.getBalance();
        if ((int) balance >= next.getPrice()) {
            user.setRank(next);
            System.out.println("promoted!");
            user.setBalance(balance - next.getPrice());
        }
    }

    public static void loadRanks(String path) {
        File rankFile = new File(PrisonCore.getPlugin(PrisonCore.class).getDataFolder(), path);

        if (!rankFile.exists()) {
            PrisonCore.getPlugin(PrisonCore.class).saveResource("rank.yml", false);

            return;
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(rankFile);


        ConfigurationSection section = config.getConfigurationSection("ranks");

        int ID = 0;
        for (String entry : section.getKeys(false)) {
            System.out.println(entry + " ENTRY");
            ID++;
            String prefix = section.getString(entry + ".prefix");
            int price = section.getInt(entry + ".price");
            String color = section.getString(entry + ".color");

            Rank rank = new Rank(prefix, price, color);
            ranks.put(ID, rank);

        }
    }

}
