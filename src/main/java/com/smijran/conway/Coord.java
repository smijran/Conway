package com.smijran.conway;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * Coordinates of cell.
 *
 * @author smijran
 */
@Builder
@EqualsAndHashCode
@ToString
public final class Coord {
    @Getter
    private final BigInteger x;
    @Getter
    private final BigInteger y;

}
