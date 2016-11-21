package com.smijran.conway.impl;

import com.smijran.conway.World;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class WorldTest {

    @Test
    public void shouldAlive(){
        //given
        WorldImplementation world=new WorldImplementation();
        world.setAlive(new BigInteger("0"),new BigInteger("0"));
        world.setAlive(new BigInteger("1"),new BigInteger("0"));
        world.setAlive(new BigInteger("1"),new BigInteger("1"));
        world.setAlive(new BigInteger("0"),new BigInteger("1"));
        WorldControllerImplementation controller = new WorldControllerImplementation();

        //when
        World newWorld = controller.makeProgress(world);

        //then
        Assert.assertTrue(newWorld.isAlive(new BigInteger("0"),new BigInteger("0")));
        Assert.assertTrue(newWorld.isAlive(new BigInteger("1"),new BigInteger("0")));
        Assert.assertTrue(newWorld.isAlive(new BigInteger("1"),new BigInteger("1")));
        Assert.assertTrue(newWorld.isAlive(new BigInteger("0"),new BigInteger("1")));
    }

    @Test
    public void shouldAloneDie(){
        //given
        WorldImplementation world=new WorldImplementation();
        world.setAlive(new BigInteger("0"),new BigInteger("0"));
        world.setAlive(new BigInteger("1"),new BigInteger("0"));
        world.setAlive(new BigInteger("5"),new BigInteger("5"));
        WorldControllerImplementation controller = new WorldControllerImplementation();

        //when
        World newWorld = controller.makeProgress(world);

        //then
        Assert.assertFalse(newWorld.isAlive(new BigInteger("0"),new BigInteger("0")));
        Assert.assertFalse(newWorld.isAlive(new BigInteger("1"),new BigInteger("0")));
        Assert.assertFalse(newWorld.isAlive(new BigInteger("5"),new BigInteger("5")));

    }

    @Test
    public void shouldBorn(){
        //given
        WorldImplementation world=new WorldImplementation();
        world.setAlive(new BigInteger("0"),new BigInteger("0"));
        world.setAlive(new BigInteger("1"),new BigInteger("0"));
        world.setAlive(new BigInteger("-1"),new BigInteger("0"));
        WorldControllerImplementation controller = new WorldControllerImplementation();

        //when
        World newWorld = controller.makeProgress(world);

        //then
        Assert.assertTrue(newWorld.isAlive(new BigInteger("0"),new BigInteger("1")));
        Assert.assertTrue(newWorld.isAlive(new BigInteger("0"),new BigInteger("-1")));

    }
    @Test
    public void shouldBorn2(){
        //given
        WorldImplementation world=new WorldImplementation();
        world.setAlive(new BigInteger("0"),new BigInteger("-1"));
        world.setAlive(new BigInteger("1"),new BigInteger("0"));
        world.setAlive(new BigInteger("-1"),new BigInteger("0"));
        WorldControllerImplementation controller = new WorldControllerImplementation();

        //when
        World newWorld = controller.makeProgress(world);

        //then
        Assert.assertTrue(newWorld.isAlive(new BigInteger("0"),new BigInteger("0")));
        Assert.assertTrue(newWorld.isAlive(new BigInteger("0"),new BigInteger("-1")));

        Assert.assertFalse(newWorld.isAlive(new BigInteger("1"),new BigInteger("0")));
        Assert.assertFalse(newWorld.isAlive(new BigInteger("-1"),new BigInteger("0")));

    }

    @Test
    public void shouldOverCrowdedDie(){
        //given
        WorldImplementation world=new WorldImplementation();
        world.setAlive(new BigInteger("0"),new BigInteger("0"));
        world.setAlive(new BigInteger("1"),new BigInteger("0"));
        world.setAlive(new BigInteger("1"),new BigInteger("1"));
        world.setAlive(new BigInteger("0"),new BigInteger("1"));
        world.setAlive(new BigInteger("-1"),new BigInteger("1"));
        WorldControllerImplementation controller = new WorldControllerImplementation();

        //when
        World newWorld = controller.makeProgress(world);

        //then
        Assert.assertFalse(newWorld.isAlive(new BigInteger("0"),new BigInteger("0")));

    }

}