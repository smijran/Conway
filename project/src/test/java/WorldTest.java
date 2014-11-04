import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Tests for World class.
 *
 * Created by kszalkowski on 2014-11-03.
 */
public class WorldTest {

    @Test
    public void shouldNewWorldHaveSize() {
        // Given

        // When
        World world = new World(10, 6);

        // Then
        assertThat(world.getWidth()).isEqualTo(10);
        assertThat(world.getHeight()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenNewWorldWithImproperWidth() throws Exception {
        // Given
        // When
        final World world = new World(-1, 5);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenNewWorldWithImproperHeight() throws Exception {
        // Given
        // When
        final World world = new World(10, -5);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenNewWorldWithImproperHeightAndWidth() throws Exception {
        // Given
        // When
        final World world = new World(-10, -10);
        // Then
    }

    @Test
    public void shouldBePossibilityToAccessCell() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        boolean cell = world.getCell(0, 0);
        // Then
        assertThat(cell).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToAccessCellOfXBelow0() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        boolean cell = world.getCell(-1, 0);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToAccessCellOfXAboveWidth() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        boolean cell = world.getCell(11, 0);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToAccessCellOYXBelow0() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        boolean cell = world.getCell(0, -1);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToAccessCellOfYAboveHeight() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        boolean cell = world.getCell(2,11);
        // Then
    }

    @Test
    public void shouldNewWorldBeFilledWithDeadCells() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        // Then
        for (int x= 0; x < world.getWidth(); x++){
            for (int y = 0; y < world.getHeight(); y++){
                // When
                boolean cell = world.getCell(x, y);
                // Then
                assertThat(cell).isFalse();
            }
        }
    }

    @Test
    public void shouldBeAbleTeSetCell() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        world.setCell(2,2, true);
        // Then
        assertThat(world.getCell(2,2)).isTrue();
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToSetCellOfXBelow0() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        world.setCell(-1, 0, true);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToSetCellOfXAboveWidth() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        world.setCell(11, 0, true);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToSetCellOYXBelow0() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        world.setCell(1, -1, true);
        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeImpossibleToSetCellOfYAboveHeight() throws Exception {
        // Given
        final World world = new World(10,10);
        // When
        world.setCell(1, 11, true);
        // Then
    }

    @Test
    public void shouldWorldBeEqualToItself() throws Exception {
        // Given
        final World world = new World(10, 10);
        // When
        boolean result = world.equals(world);
        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldWorldBeEqualToItsCopy() throws Exception {
        // Given
        final World world = new World(10, 10);
        final World copy = world.copy();
        // When
        boolean result = world.equals(world);
        // Then
        assertThat(result).isTrue();
    }
}
