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
    private PrivateMine privateMine;
    private List<Enchant> enchantList;

    public User(String name, Rank rank, double balance, int tokens, boolean isPrestige, List<Enchant> enchantList, PrivateMine privateMine) {
        this.name = name;
        this.rank = rank;
        this.balance = balance;
        this.tokens = tokens;
        this.isPrestige = isPrestige;
        this.privateMine = privateMine;
        this.enchantList = enchantList;
    }

    public User(String name) {
        this.name = name;

        this.rank = new Rank();
        this.balance = 100.0;
        this.isPrestige = false;

        this.enchantList = new ArrayList<>();
        //TODO fix to this = this.privateMine = new PrivateMine(name);
        this.privateMine = null;
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

    public PrivateMine getPrivateMine() { return privateMine; }

    public List<Enchant> getEnchantList() {
        return enchantList;
    }

    public void setPrivateMine(PrivateMine privateMine) {
        this.privateMine = privateMine;
    }
}
