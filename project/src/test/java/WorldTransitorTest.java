import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by kszalkowski on 2014-11-04.
 */
public class WorldTransitorTest {

    @Test
    public void shouldOneCellWorldRemainDead(){
        // Given
        final World world = new World(1,1);
        final WorldTransitor transitor = new WorldTransitor();

        // When
        final World result = transitor.transist(world);

        // Then
        assertThat(result.getCell(0,0)).isFalse();
    }
}
