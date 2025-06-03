package me.jack.jprisoncore.mine;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PrivateMine extends AbstractMine {


    public PrivateMine(User owner, Location point1, Location point2) {
        super(owner, point1, point2);
    }

    public void copyWorld(File file) {

        try {

            FileUtils.copyDirectory(file, new File(Bukkit.getWorldContainer() + File.separator + file.getName() + "." + Bukkit.getPlayer(getOwner().getName()).getUniqueId()));
            WorldCreator wc = new WorldCreator(file.getName() + "." + Bukkit.getPlayer(getOwner().getName()).getUniqueId());
            wc.createWorld();

            System.out.println("copied to " + Bukkit.getWorldContainer().getAbsolutePath());
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create() {

        copyWorld(new File(Bukkit.getWorldContainer(), "mineworld"));


        /*
        Location point1 = getPoint1();
        Location point2 = getPoint2();

        int minx = Math.min(point1.getBlockX(), point2.getBlockX());
        int maxx = Math.max(point1.getBlockX(), point2.getBlockX());
        int miny = Math.min(point1.getBlockY(), point2.getBlockY());
        int maxy = Math.max(point1.getBlockY(), point2.getBlockY());
        int minz = Math.min(point1.getBlockZ(), point2.getBlockZ());
        int maxz = Math.max(point1.getBlockZ(), point2.getBlockZ());

        for (int x = minx; x <= maxx; x++) {
            for (int y = miny; y <= maxy; y++) {
                for (int z = minz; z <= maxz; z++) {

                    Location cuboid = new Location(Bukkit.getWorld("world"), x, y, z);


                    if (x != minx || x != maxx || z != minz || z != maxz) {

                        cuboid.getBlock().setType(Material.GLASS);
                    }
                }
            }
        }

         */


    }
}
