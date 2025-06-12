package me.jack.jprisoncore.command;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.Enchant;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.gui.MainMenu;
import me.jack.jprisoncore.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MineCommand implements CommandExecutor {

    private PrisonCore instance;

    public MineCommand(PrisonCore instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("rankup")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;


                if (args.length > 0) {

                    player.sendMessage("Incorrect usage!");
                    return true;
                }

                User user = instance.getUser(player.getName());
                Rank rank = user.getRank();
                Rank next = rank.getNextRank();
                double bal = user.getBalance();
                double price = next.getPrice();

                if (rank.getNextRank() == null) {
                    player.sendMessage("You are max!");
                    return true;
                }

                if (bal >= price) {
                    player.sendMessage("you are now rank " + next.getPrefix());
                    user.setRank(next);
                    user.setBalance(bal - next.getPrice());
                    player.setDisplayName(ChatColor.GRAY + "[" + ChatColor.RED + user.getRank().getPrefix() + ChatColor.GRAY + "] " + ChatColor.WHITE + player.getName());
                    player.setPlayerListName(ChatColor.GRAY + "[" + ChatColor.RED + user.getRank().getPrefix() + ChatColor.GRAY + "] " + ChatColor.WHITE + player.getName());

                } else {
                    player.sendMessage("you do not have enough money");
                }

            }
        } else if (cmd.getName().equalsIgnoreCase("rank")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;


                if (args.length > 0) {

                    player.sendMessage("Incorrect usage!");
                    return true;
                }

                User user = instance.getUser(player.getName());
                Rank rank = user.getRank();

                player.sendMessage("you are rank " + rank.getPrefix());
            }
        } else if (cmd.getName().equalsIgnoreCase("balance")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;


                if (args.length > 0) {

                    player.sendMessage("Incorrect usage!");
                    return true;
                }

                User user = instance.getUser(player.getName());
                Rank rank = user.getRank();

                player.sendMessage("you have " + user.getBalance() + " dollars");
            }
        } else if (cmd.getName().equalsIgnoreCase("setbal")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;


                if (args.length > 1) {

                    player.sendMessage("Incorrect usage! /setbal <amount>");
                    return true;
                }

                int amount = Integer.parseInt(args[0]);
                User user = instance.getUser(player.getName());
                user.setBalance(amount);

                player.sendMessage("you have now got " + user.getBalance() + " dollars");
            }
        } else if (cmd.getName().equalsIgnoreCase("unlock")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;


                User user = instance.getUser(player.getName());
                List<Enchant> enchants = user.getEnchantList();

                for (Enchant e : Enchant.values()) {
                    if (args[0].equalsIgnoreCase(e.getName().replace(" ", ""))) {
                        if (enchants.contains(e)) {
                            player.sendMessage("You have this enchant");
                        } else {
                            player.sendMessage("Enchant added");
                            enchants.add(e);
                        }
                    }
                }

            }
        } else if (cmd.getName().equalsIgnoreCase("lock")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;


                User user = instance.getUser(player.getName());
                List<Enchant> enchants = user.getEnchantList();

                for (Enchant e : Enchant.values()) {
                    if (args[0].equalsIgnoreCase(e.getName().replace(" ", ""))) {
                        if (!enchants.contains(e)) {
                            player.sendMessage("You do not have this enchant");
                        } else {
                            player.sendMessage("Enchant removed");
                            enchants.remove(e);
                        }
                    }
                }

            }
        } else if (cmd.getName().equalsIgnoreCase("pmine")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                MainMenu menu = new MainMenu();
                menu.initializeItems(instance.getUser(player.getName()));
                menu.open(player);

            }
        } else if (cmd.getName().equalsIgnoreCase("sell")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int count = 0;
                for (ItemStack i : player.getInventory().getContents()) {
                    if (i == null) continue;
                    System.out.println(i + " i");
                    if (i.getType().equals(Material.DIAMOND_BLOCK)) {

                        int amount = i.getAmount();
                        count+=amount;
                        int newAmount = amount * 10;
                        System.out.println("amount of dblock: " + amount + " worth: (" + amount + "*10) = " + newAmount);
                    }


                }
                int newAmount = count * 10;
                System.out.println("total dblock: " + count + " worth: (" + count + "*10) = " + newAmount);
            }
        }
        return false;
    }


}
