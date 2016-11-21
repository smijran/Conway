package com.smijran.conway;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

/**
 * Coordinates of cell.
 *
 * @author smijran
 */
@Builder
public final class Coord {
    @Getter
    private final BigInteger x;
    @Getter
    private final BigInteger y;

}
