import com.google.common.base.Preconditions;

import java.io.Serializable;

/**
 * Class representing world.
 * <p/>
 * Created by kszalkowski on 2014-11-03.
 */
public class World implements Serializable {

    private final boolean[][] world;
    private int width;
    private int height;

    public World(int width, int height) {
        Preconditions.checkArgument(width > 0, "Programmer's error: invalid width.", width);
        Preconditions.checkArgument(height > 0, "Programmer's error: invalid height.", width);
        this.width = width;
        this.height = height;
        this.world = new boolean[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean getCell(int x, int y) {
        Preconditions.checkArgument(width > x && x >= 0, "Programmer's error: invalid x.", x);
        Preconditions.checkArgument(height > y && y >= 0, "Programmer's error: invalid y.", y);
        return world[x][y];
    }

    public void setCell(int x, int y, boolean cell) {
        Preconditions.checkArgument(width > x && x >= 0, "Programmer's error: invalid x.", x);
        Preconditions.checkArgument(height > y && y >= 0, "Programmer's error: invalid y.", y);
        world[x][y] = cell;
    }

    public World copy() {
        return copy(this);
    }

    public static World copy(World world) {
        final World result = new World(world.getWidth(), world.getHeight());
        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                result.setCell(x, y, world.getCell(x, y));
            }
        }
        return result;
    }


}
