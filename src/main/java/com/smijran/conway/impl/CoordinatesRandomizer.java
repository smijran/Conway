package com.smijran.conway.impl;

import com.smijran.conway.Coord;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Class for generating random streams for {@link RandomWorldBuilder}.
 *
 * @author smijran
 */
final class CoordinatesRandomizer {
    private final Random random = new Random();

    Coord getNextCoord() {
        return Coord.builder().x(BigInteger.valueOf(random.nextLong())).y(BigInteger.valueOf(random.nextLong())).build();
    }

    Stream<Coord> coords() {
        return Stream.generate(this::getNextCoord);
    }

    Coord getNextCoord(long maxX, long maxY) {
        return Coord.builder().x(BigInteger.valueOf(Math.abs(random.nextLong()) % maxX)).y(BigInteger.valueOf(Math.abs(random.nextLong()) % maxY)).build();
    }

    Stream<Coord> coords(long maxX, long maxY) {
        return Stream.generate(() -> this.getNextCoord(maxX, maxY));
    }

}
