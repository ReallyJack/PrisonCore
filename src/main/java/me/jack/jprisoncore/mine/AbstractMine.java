package me.jack.jprisoncore.mine;

import me.jack.jprisoncore.game.User;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMine {

    private User owner;
    private Location point1;
    private Location point2;

    public AbstractMine(User owner, Location point1, Location point2) {
        this.owner = owner;
        this.point1 = point1;
        this.point2 = point2;
    }

    public User getOwner() {
        return owner;
    }

    public Location getPoint1() {
        return point1;
    }

    public Location getPoint2() {
        return point2;
    }

    public void setPoint1(Location point1) {
        this.point1 = point1;
    }

    public void setPoint2(Location point2) {
        this.point2 = point2;
    }

    public abstract void create(User user);

}
