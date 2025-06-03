package me.jack.jprisoncore.command;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.gui.MineMenu;
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

        if (cmd.getName().equalsIgnoreCase("pmine")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;


                if (args.length > 0) {

                    player.sendMessage("Incorrect usage!");
                    return true;
                }

                User user = instance.getUser(player.getName());
                MineMenu mineMenu = new MineMenu();
                mineMenu.open(player);
            }
        }

        return false;
    }
}
