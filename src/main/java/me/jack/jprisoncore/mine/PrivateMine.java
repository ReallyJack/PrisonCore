package me.jack.jprisoncore.mine;

import me.jack.jprisoncore.PrisonCore;
import me.jack.jprisoncore.game.User;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;
import java.io.IOException;

public class PrivateMine extends AbstractMine {

    private PrisonCore instance;

    public PrivateMine(PrisonCore instance, User owner, Location point1, Location point2) {
        super(owner, point1, point2);

        this.instance = instance;
    }

    @Override
    public void create(User user) {

        Bukkit.getScheduler().runTask(instance, () -> {
            File file = new File(Bukkit.getServer().getWorldContainer(), "mineworld");

            try {
                FileUtils.copyDirectory(file, new File(file.getName() + "." + Bukkit.getPlayer(getOwner().getName()).getUniqueId()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void initializeMine(World world, Material material) {
        Location point1 = getPoint1();
        Location point2 = getPoint2();

        int minx = Math.min(point1.getBlockX(), point2.getBlockX());
        int maxx = Math.max(point1.getBlockX(), point2.getBlockX());
        int miny = Math.min(point1.getBlockY(), point2.getBlockY());
        int maxy = Math.max(point1.getBlockY(), point2.getBlockY());
        int minz = Math.min(point1.getBlockZ(), point2.getBlockZ());
        int maxz = Math.max(point1.getBlockZ(), point2.getBlockZ());

        if (material == null) {
            for (int x = minx; x <= maxx; x++) {
                for (int y = miny; y <= maxy; y++) {
                    for (int z = minz; z <= maxz; z++) {
                        Location cuboid = new Location(world, x, y, z);
                        if (x != minx || x != maxx || z != minz || z != maxz) {
                            cuboid.getBlock().setType(Material.GLASS);
                        }
                    }
                }
            }
        } else {
            for (int x = minx; x <= maxx; x++) {
                for (int y = miny; y <= maxy; y++) {
                    for (int z = minz; z <= maxz; z++) {
                        Location cuboid = new Location(world, x, y, z);
                        if (x != minx || x != maxx || z != minz || z != maxz) {
                            cuboid.getBlock().setType(material);
                        }
                    }
                }
            }
        }
    }

    public void setSpawn() {
        ConfigurationSection private_mine_spawn = instance.getConfig().getConfigurationSection("private-mine-spawn");

        int x = private_mine_spawn.getInt("x");
        int y = private_mine_spawn.getInt("y");
        int z = private_mine_spawn.getInt("z");

        Bukkit.getServer().getWorld("mineworld." + Bukkit.getPlayer(getOwner().getName()).getUniqueId()).setSpawnLocation(new Location(Bukkit.getWorld("mineworld." + Bukkit.getPlayer(getOwner().getName()).getUniqueId()), x, y, z));

        System.out.println(x + " " + y + " " + z + " " +
                Bukkit.getWorld("mineworld." + Bukkit.getPlayer(getOwner().getName()).getUniqueId()).getSpawnLocation().getX() +
                Bukkit.getWorld("mineworld." + Bukkit.getPlayer(getOwner().getName()).getUniqueId()).getSpawnLocation().getY() +
                Bukkit.getWorld("mineworld." + Bukkit.getPlayer(getOwner().getName()).getUniqueId()).getSpawnLocation().getZ());
    }
}
