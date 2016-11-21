package com.smijran.conway.simulation;

import com.smijran.conway.World;
import com.smijran.conway.WorldController;
import com.smijran.conway.WorldSize;
import com.smijran.conway.impl.RandomWorldBuilder;
import com.smijran.conway.impl.WorldControllerImplementaiton;

import java.io.IOException;
import java.math.BigInteger;

public class ConwaySimpleSimulation {
    public static void main(String args[]) throws IOException, InterruptedException {
        final WorldController controller = new WorldControllerImplementaiton();
        World world = new RandomWorldBuilder().create();
        print(world);
        for (int i = 0; i < 100; i++) {
            world = controller.makeProgress(world);
            print(world);
            Thread.sleep(1000);
        }
    }

    private static void print(World impl) {
        final WorldSize size = impl.getSize();
        if (!size.isEmpty()) {
            System.out.println(size);
            for (BigInteger y = size.getRows().lowerEndpoint(); y.compareTo(size.getRows().upperEndpoint()) < 0; y = y.add(BigInteger.ONE)) {
                for (BigInteger x = size.getColumns().lowerEndpoint(); x.compareTo(size.getColumns().upperEndpoint()) < 0; x = x.add(BigInteger.ONE)) {
                    System.out.print(impl.isAlive(x, y) ? "X" : "-");
                }
                System.out.println();
            }
        } else {
            System.out.println("Dead");
        }
    }

}
