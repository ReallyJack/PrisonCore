package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    private PrisonCore instance;

    public Join(PrisonCore instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();


        instance.users.add(new User(player.getName()));

    }
}
