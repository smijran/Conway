package com.smijran.conway.impl;

import com.smijran.conway.World;
import com.smijran.conway.WorldBuilder;

/**
 * Created by konrad on 21.11.16.
 */
public class RandomWorldBuilder implements WorldBuilder {
    private final CoordinatesRandomizer randomizer = new CoordinatesRandomizer();


    @Override
    public World create() {
        final WorldImplementation impl = new WorldImplementation();
        randomizer.coords(50L, 50L).limit(300).forEach(impl::setAlive);
        return impl;
    }
}
