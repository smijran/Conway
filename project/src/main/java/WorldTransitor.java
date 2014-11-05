/**
 * Created by kszalkowski on 2014-11-04.
 */
public class WorldTransitor {
    public World transist(World world) {
        if (world == null) {
            return null;
        }
        final World worldAfter = world.copy();
        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                boolean stateAfter = decideCellState(x, y, world);
                worldAfter.setCell(x, y, stateAfter);
            }
        }
        return worldAfter;
    }

    private boolean decideCellState(final int x, final int y, World world) {
        final int neigh = countAliveNeighbours(x, y, world);
        switch (neigh) {
            case 2:
                return getCellSafe(x, y, world);
            case 3:
                return true;
            default:
                return false;
        }
    }

    private int countAliveNeighbours(final int x, final int y, World world) {
        int counter = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                // Skip center point
                if (i == x && j == y) {
                    continue;
                }
                if (getCellSafe(i, j, world)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean getCellSafe(int x, int y, World world) {
        if (x < 0 || x >= world.getWidth()) {
            return false;
        }
        if (y < 0 || y >= world.getHeight()) {
            return false;
        }
        return world.getCell(x, y);
    }
}
