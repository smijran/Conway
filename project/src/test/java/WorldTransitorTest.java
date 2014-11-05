import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by kszalkowski on 2014-11-04.
 */
public class WorldTransitorTest {

    private final WorldPrinter worldPrinter = new WorldPrinter();

    @Test
    public void shouldOneCellWorldDeadRemainDead() {
        // Given
        final World world = new World(1, 1);
        final WorldTransitor transitor = new WorldTransitor();

        // When
        System.out.println(worldPrinter.print(world));
        final World result = transitor.transist(world);
        System.out.println(worldPrinter.print(result));

        // Then
        assertThat(result.getCell(0, 0)).isFalse();
    }

    @Test
    public void shouldOneCellWorldAliveCellDie() throws Exception {
        // Given
        final World world = new World(1, 1);
        final WorldTransitor transitor = new WorldTransitor();
        world.setCell(0, 0, true);

        // When
        System.out.println(worldPrinter.print(world));
        final World result = transitor.transist(world);
        System.out.println(worldPrinter.print(result));

        // Then
        assertThat(result.getCell(0, 0)).isFalse();
    }

    @Test
    public void shouldCellWithOneAliveNeighbourDie() {
        // Given
        final World world = new World(3, 3);
        final WorldTransitor transitor = new WorldTransitor();
        world.setCell(0, 0, true);
        world.setCell(0, 1, true);

        // When
        System.out.println(worldPrinter.print(world));
        final World result = transitor.transist(world);
        System.out.println(worldPrinter.print(result));

        // Then
        assertThat(result.getCell(0, 0)).isFalse();
        assertThat(result.getCell(0, 1)).isFalse();
    }

    @Test
    public void shouldAliveCellWithTwoAliveNeighboursRemainAlive() {
        // Given
        final World world = new World(3, 3);
        final WorldTransitor transitor = new WorldTransitor();
        world.setCell(0, 0, true);
        world.setCell(0, 1, true);
        world.setCell(0, 2, true);

        // When
        System.out.println(worldPrinter.print(world));
        final World result = transitor.transist(world);
        System.out.println(worldPrinter.print(result));

        // Then
        assertThat(result.getCell(0, 1)).isTrue();
    }


    @Test
    public void shouldAliveCellWithThreeAliveNeighboursRemainAlive() {
        // Given
        final World world = new World(3, 3);
        final WorldTransitor transitor = new WorldTransitor();
        world.setCell(0, 0, true);
        world.setCell(0, 1, true);
        world.setCell(0, 2, true);
        world.setCell(1, 1, true);

        // When
        System.out.println(worldPrinter.print(world));
        final World result = transitor.transist(world);
        System.out.println(worldPrinter.print(result));

        // Then
        assertThat(result.getCell(0, 1)).isTrue();
    }


    @Test
    public void shouldDeadCellWithThreeAliveNeighboursBeBorn() {
        // Given
        final World world = new World(3, 3);
        final WorldTransitor transitor = new WorldTransitor();
        world.setCell(0, 0, true);
        world.setCell(0, 2, true);
        world.setCell(2, 1, true);

        // When
        System.out.println(worldPrinter.print(world));
        final World result = transitor.transist(world);
        System.out.println(worldPrinter.print(result));

        // Then
        assertThat(result.getCell(1, 1)).isTrue();
    }


    @Test
    public void shouldAliveCellWithMoreThanThreeAliveNeighboursDie() {
        // Given
        final World world = new World(3, 3);
        final WorldTransitor transitor = new WorldTransitor();
        world.setCell(0, 0, true);
        world.setCell(0, 1, true);
        world.setCell(0, 2, true);
        world.setCell(1, 1, true);
        world.setCell(2, 1, true);

        // When
        System.out.println(worldPrinter.print(world));
        final World result = transitor.transist(world);
        System.out.println(worldPrinter.print(result));

        // Then
        assertThat(result.getCell(1, 1)).isFalse();
    }
}
