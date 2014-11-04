import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Tests for WorldPrinter.
 * Created by kszalkowski on 2014-11-03.
 */
public class WorldPrinterTest {

    @Test
    public void shouldPrintOneCellWorld() throws Exception {
        // Given
        final World world = new World(1, 1);
        final WorldPrinter worldPrinter = new WorldPrinter();
        // When
        final String printed = worldPrinter.print(world);
        // Then
        assertThat(printed).isEqualTo("x\n");
    }

    @Test
    public void shouldPrintSquareCellWorld() throws Exception {
        // Given
        final World world = new World(2, 2);
        final WorldPrinter worldPrinter = new WorldPrinter();
        // When
        final String printed = worldPrinter.print(world);
        // Then
        assertThat(printed).isEqualTo("xx\nxx\n");
    }

    @Test
    public void shouldPrintSetOneCell() throws Exception {
        // Given
        final World world = new World(2, 2);
        final WorldPrinter worldPrinter = new WorldPrinter();
        world.setCell(1, 1, true);
        // When
        final String printed = worldPrinter.print(world);
        // Then
        assertThat(printed).isEqualTo("xx\nxo\n");
    }

    @Test
    public void shouldPrintOneCellWorldOther() throws Exception {
        // Given
        final World world = new World(1, 1);
        final WorldPrinter worldPrinter = new WorldPrinter('w','r');
        // When
        final String printed = worldPrinter.print(world);
        // Then
        assertThat(printed).isEqualTo("w\n");
    }

    @Test
    public void shouldPrintSquareCellWorldOther() throws Exception {
        // Given
        final World world = new World(2, 2);
        final WorldPrinter worldPrinter = new WorldPrinter('w','r');
        // When
        final String printed = worldPrinter.print(world);
        // Then
        assertThat(printed).isEqualTo("ww\nww\n");
    }

    @Test
    public void shouldPrintSetOneCellOther() throws Exception {
        // Given
        final World world = new World(2, 2);
        final WorldPrinter worldPrinter = new WorldPrinter('w','r');
        world.setCell(1, 1, true);
        // When
        final String printed = worldPrinter.print(world);
        // Then
        assertThat(printed).isEqualTo("ww\nwr\n");
    }
}
