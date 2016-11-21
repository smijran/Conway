package com.smijran.conway;

/**
 * Controller of the world.
 *
 * @author smijran
 */
public interface WorldController {
    /**
     * Make single step in given world.
     *
     * @param access World to change.
     * @return New instance of the world after change.
     */
    World makeProgress(World access);
}
