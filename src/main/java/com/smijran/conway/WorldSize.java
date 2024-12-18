package com.smijran.conway;

import com.google.common.collect.Range;

import java.math.BigInteger;

/**
 * Size of the world object.
 *
 * @author smijran
 */
public record WorldSize(Range<BigInteger> columns, Range<BigInteger> rows) {

    public boolean isEmpty() {
        return columns == null && rows == null;
    }
}
