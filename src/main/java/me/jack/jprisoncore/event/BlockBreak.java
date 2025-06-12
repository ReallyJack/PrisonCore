package me.jack.jprisoncore.event;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.Enchant;
import me.jack.jprisoncore.game.User;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;
import java.util.Random;

public class BlockBreak implements Listener {

    private PrisonCore instance;
    private final Random random;

    public BlockBreak(PrisonCore instance) {
        this.instance = instance;
        this.random = new Random();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        event.setExpToDrop(0);
        Location blockLocation = block.getLocation();
        World world = blockLocation.getWorld();
        int numberOfOrbs = 3;
        int xpPerOrb = 1;

        for (int i = 0; i < numberOfOrbs; i++) {
            ExperienceOrb orb = (ExperienceOrb) world.spawnEntity(blockLocation, EntityType.EXPERIENCE_ORB);
            orb.setExperience(xpPerOrb);
        }

        User user = instance.getUser(player.getName());
        List<Enchant> enchantList = user.getEnchantList();

        for (Enchant e : enchantList) {
            e.applyEffects(event);

        }
    }
}
