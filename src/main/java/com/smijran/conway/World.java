package com.smijran.conway;

import java.math.BigInteger;
import java.util.Set;

/**
 * Interface of the Conway Game world construct.
 *
 * @author smijran
 */
public interface World {

    /**
     * Get the size of world. The most extreme coordinates.
     * @return Nonnull size of the world.
     */
    WorldSize getSize();

    /**
     * Check if cell on  given coordinate is alive.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return True if cell is alive.
     */
    boolean isAlive(BigInteger x, BigInteger y);

    /**
     * Check if cell on given coordinate is alive.
     * @param coord Coordinates.
     * @return True if cell is alive.
     */
    default boolean isAlive(Coord coord)
    {
        return isAlive(coord.getY(), coord.getX());
    }

    /**
     * Return the set of coordinates which are occupied by alive cells.
     * @return Non null set of alive cell's coordinates.
     */
    Set<Coord> getAliveCoords();

}
