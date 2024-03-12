import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jemma arona
 */
public final class WorldData extends PropertyChangeSupport {
    private static WorldData worldData;
    private int numRows;
    private HashMap <String, ArrayList <Point>> levelMap;
    private HashMap <ArrayList <Point>, String> tileMap;
    private int[] spider, bgColor;

    private WorldData() {
        super( new Object() );
        numRows = 0;
        levelMap = new HashMap<>();
        tileMap = new HashMap<>();
        spider = new int[]{0, 0, 0};
        bgColor = new int[]{0, 0, 0};
    }

    public static WorldData getWorldData() {
        if ( worldData == null ) {
            worldData = new WorldData();
        }
        return worldData;
    }

    public void setLevel( HashMap <String, ArrayList<Point>> level ) {
        levelMap = level;
        numRows = 5;
        bgColor = new int[]{110, 113, 132};
        firePropertyChange( "levelMap", null, levelMap );
        firePropertyChange( "numRows", null, numRows );
        firePropertyChange( "bgColor", null, bgColor );
        firePropertyChange( "visible", null, true );
    }

    public void setLevel( HashMap <String, ArrayList<Point>> level, int rows, int r, int g, int b ) {
        levelMap = level;
        numRows = rows;
        bgColor = new int[]{r, g, b};
        firePropertyChange( "levelMap", null, levelMap );
        firePropertyChange( "numRows", null, numRows );
        firePropertyChange( "bgColor", null, bgColor );
        firePropertyChange( "visible", null, true );
    }

    public int getNumRows() {
        return numRows;
    }

    /**
     * (rot: 0 = east, 1 = north, 2 = west, 3 = south)
     * @return 3 int array: {x, y, rot}
     */
    public int[] getSpider() {
        return spider;
    }

    /**
     * @param rot: 0 = east, 1 = north, 2 = west, 3 = south
     */
    public void moveSpider( int x, int y, int rot ) {
        if ( x > numRows || y > numRows || x < 0 || y < 0 ) {
            throw new RuntimeException( "Spider Out of Bounds" );
        } else {
            this.spider[0] = x;
            this.spider[1] = y;
            this.spider[2] = rot%4;
        }
        firePropertyChange( "spider", null, spider );
    }

    public HashMap<String, ArrayList<Point>> getLevelMap() {
        return levelMap;
    }

    public HashMap<ArrayList<Point>, String> getTileMap() {
        return tileMap;
    }
}
