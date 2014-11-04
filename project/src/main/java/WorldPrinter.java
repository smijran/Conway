import com.google.common.base.Preconditions;

/**
 * World printer.
 * Created by kszalkowski on 2014-11-03.
 */
public class WorldPrinter {
    private char deadChar = 'x';
    private char aliveChar = 'o';

    public WorldPrinter(){
    }

    public WorldPrinter(char deadChar, char aliveChar) {
        Preconditions.checkArgument(deadChar != aliveChar, "Programmer's error: alive and dead char are the same.");
        this.deadChar = deadChar;
        this.aliveChar = aliveChar;
    }

    /**
     * Print the given world to string.
     */
    public String print(World world) {
        final StringBuilder sb = new StringBuilder();
        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                sb.append(world.getCell(x, y) ? aliveChar : deadChar);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
