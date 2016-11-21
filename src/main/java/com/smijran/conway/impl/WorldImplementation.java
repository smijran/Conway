package com.smijran.conway.impl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Range;
import com.google.common.collect.Table;
import com.smijran.conway.Coord;
import com.smijran.conway.World;
import com.smijran.conway.WorldSize;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of world interface.
 *
 * @author smijran
 */
public final class WorldImplementation implements World {
    private Table<BigInteger, BigInteger, Object> table = HashBasedTable.create();

    @Override
    public WorldSize getSize() {
        final Optional<BigInteger> minx = table.columnKeySet().stream().min(Comparator.naturalOrder());
        final Optional<BigInteger> maxx = table.columnKeySet().stream().max(Comparator.naturalOrder());
        final Optional<BigInteger> miny = table.rowKeySet().stream().min(Comparator.naturalOrder());
        final Optional<BigInteger> maxy = table.rowKeySet().stream().max(Comparator.naturalOrder());
        if (!minx.isPresent() && !maxx.isPresent()) {
            return new WorldSize(null, null);
        }
        return new WorldSize(Range.closed(minx.get(), maxx.get()), Range.closed(miny.get(), maxy.get()));
    }

    @Override
    public boolean isAlive(BigInteger x, BigInteger y) {
        return table.contains(y, x);
    }

    @Override
    public Set<Coord> getAliveCoords() {
        return table.cellSet().stream().map(c -> Coord.builder().x(c.getColumnKey()).y(c.getRowKey()).build()).collect(Collectors.toSet());
    }

    void setAlive(BigInteger x, BigInteger y) {
        table.put(y, x, new Object());
    }

    void setAlive(Coord coord) {
        table.put(coord.getY(), coord.getX(), new Object());
    }


}
