package me.jack.jprisoncore.game;

import me.jack.jprisoncore.mine.PrivateMine;
import me.jack.jprisoncore.rank.Rank;

import java.util.List;

public class User {

    private String name;
    private Rank rank;
    private double balance; //rankup balance
    private int tokens; //to be used to purchase enchantment upgrades
    private int level; //pickaxe level (unlock enchantments, is the players XP level)
    private boolean isPrestige;
    private PrivateMine privateMine;
    private List<Enchant> enchantList;
    private boolean inMine = false;

    public User(String name, double balance, int tokens, int level, Rank rank, boolean isPrestige, List<Enchant> enchantList) {
        this.name = name;
        this.balance = balance;
        this.tokens = tokens;
        this.isPrestige = isPrestige;
        this.enchantList = enchantList;
        this.level = level;

        setRank(Rank.getRankByID(1));

    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public int getLevel() {
        return level;
    }

    public boolean isPrestige() {
        return isPrestige;
    }

    public PrivateMine getPrivateMine() {
        return privateMine;
    }

    public void setPrivateMine(PrivateMine privateMine) {
        this.privateMine = privateMine;
    }

    public boolean isInMine() {
        return inMine;
    }

    public void setInMine(boolean inMine) {
        this.inMine = inMine;
    }

    public List<Enchant> getEnchantList() {
        return enchantList;
    }

    public void addEnchant(Enchant enchant) {
        enchantList.add(enchant);
    }

}
