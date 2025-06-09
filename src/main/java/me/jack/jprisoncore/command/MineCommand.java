package me.jack.jprisoncore.command;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.gui.MineMenu;
import me.jack.jprisoncore.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

                if (bal >= price) {
                    player.sendMessage("you are now rank " + next.getPrefix());
                    user.setRank(next);
                    user.setBalance(bal - next.getPrice());
                } else {
                    player.sendMessage("you do not have enough money");
                }

            }
        }

       else if (cmd.getName().equalsIgnoreCase("rank")) {
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
        }
        else if (cmd.getName().equalsIgnoreCase("balance")) {
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
        }

        return false;
    }


}
