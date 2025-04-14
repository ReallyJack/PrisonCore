package me.jack.jprisoncore.game;

import me.jack.jprisoncore.mine.PrivateMine;
import me.jack.jprisoncore.rank.Rank;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private Rank rank;
    private double balance;
    private int tokens;
    private boolean isPrestige;
    private List<PrivateMine> privateMines;
    private List<Enchant> enchantList;

    public User(String name, Rank rank, double balance, int tokens, boolean isPrestige, List<Enchant> enchantList, List<PrivateMine> privateMines) {
        this.name = name;
        this.rank = rank;
        this.balance = balance;
        this.tokens = tokens;
        this.isPrestige = isPrestige;
        this.privateMines = privateMines;
        this.enchantList = enchantList;
    }

    public User(String name) {
        this.name = name;

        this.rank = new Rank();
        this.balance = 100.0;
        this.isPrestige = false;

        this.enchantList = new ArrayList<>();
        this.privateMines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public double getBalance() {
        return balance;
    }

    public int getTokens() {
        return tokens;
    }

    public boolean isPrestige() {
        return isPrestige;
    }

    public List<Enchant> getEnchantList() {
        return enchantList;
    }

}
