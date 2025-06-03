package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import me.jack.jprisoncore.mine.PrivateMine;
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


        instance.users.add(new User(player.getName()));

        //TODO add spawn loc from config
        PrivateMine pmine = new PrivateMine(instance.getUser(player.getName()), null, null);
        pmine.create();
        instance.getUser(player.getName()).setPrivateMine(pmine);

    }
}
