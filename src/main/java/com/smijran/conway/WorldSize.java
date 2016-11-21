package com.smijran.conway;

import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * Size of the world object.
 *
 * @author smijran
 */
@AllArgsConstructor
@ToString
public final class WorldSize {
    @Getter
    private final Range<BigInteger> columns;
    @Getter
    private final Range<BigInteger> rows;

    public boolean isEmpty() {
        return columns == null && rows == null;
    }
}
