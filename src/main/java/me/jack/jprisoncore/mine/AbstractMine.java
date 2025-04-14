package me.jack.jprisoncore.mine;

import me.jack.jprisoncore.game.User;
import org.bukkit.Location;

public abstract class AbstractMine {

    public User owner;
    public String name;
    public Location location;

    public AbstractMine(String name, User owner, Location location) {
        this.name = name;
        this.owner = owner;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public User getOwner() {
        return owner;
    }
    public String getName() {
        return name;
    }


}
