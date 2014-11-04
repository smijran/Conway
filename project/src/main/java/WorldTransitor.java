/**
 * Created by kszalkowski on 2014-11-04.
 */
public class WorldTransitor {
    public World transist(World world) {
        if (world == null) {
            return null;
        }
        final World worldAfter = world.copy();

        return worldAfter;
    }
}
