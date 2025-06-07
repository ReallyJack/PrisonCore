package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.mine.PrivateMine;
import me.jack.jprisoncore.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class Join implements Listener {

    private PrisonCore instance;

    public Join(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        User user = new User(player.getName(), 100.0D, 0, false, null);
        //TODO add spawn loc from config
        PrivateMine pmine = new PrivateMine(instance.getUser(player.getName()), null, null);

        user.setPrivateMine(pmine);
        pmine.create();


    }
}
