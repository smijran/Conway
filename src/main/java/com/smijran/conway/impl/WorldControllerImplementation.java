package com.smijran.conway.impl;

import com.google.common.collect.Range;
import com.smijran.conway.Coord;
import com.smijran.conway.World;
import com.smijran.conway.WorldController;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Implementation of Conway rules.
 *
 * @author smijran
 */
public class WorldControllerImplementation implements WorldController {

    private final static Range<Long> aliveRange = Range.closed(2L, 3L);

    @Override
    public World makeProgress(World oldWorld) {

        final WorldImplementation world = new WorldImplementation();
        oldWorld.getAliveCoords().stream().filter(c ->
                aliveRange.contains(countAlive(oldWorld, c))).forEach(world::setAlive);
        oldWorld.getAliveCoords().forEach(
                c ->
                        Stream.of(Neighbour.values())
                                .map(n -> n.getNeighbour(c))
                                .filter(p -> !oldWorld.isAlive(p))
                                .filter(p -> 3 == countAlive(oldWorld, p))
                                .forEach(world::setAlive)
        );
        return world;
    }

    private static long countAlive(World state, Coord coord) {
        return Stream.of(Neighbour.values()).map(n -> n.getNeighbour(coord)).filter(state::isAlive).count();

    }

    enum Neighbour {
        TopLeft(BigInteger.ONE.negate(), BigInteger.ONE.negate()),
        Top(BigInteger.ZERO, BigInteger.ONE.negate()),
        TopRight(BigInteger.ONE, BigInteger.ONE.negate()),
        Left(BigInteger.ONE.negate(), BigInteger.ZERO),
        Right(BigInteger.ONE, BigInteger.ZERO),
        BottomLeft(BigInteger.ONE.negate(), BigInteger.ONE),
        Bottom(BigInteger.ZERO, BigInteger.ONE),
        BottomRight(BigInteger.ONE, BigInteger.ONE);

        private final BigInteger shiftX;
        private final BigInteger shiftY;

        Neighbour(BigInteger shiftX, BigInteger shiftY) {
            this.shiftX = shiftX;
            this.shiftY = shiftY;
        }

        public Coord getNeighbour(BigInteger x, BigInteger y) {
            return Coord.builder().x(x.add(shiftX)).y(y.add(shiftY)).build();
        }

        public Coord getNeighbour(Coord coord) {
            return Coord.builder().x(coord.getX().add(shiftX)).y(coord.getY().add(shiftY)).build();
        }

    }


}
