import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Jemma Arona
 */

public final class WorldData extends PropertyChangeSupport {
    private static WorldData worldData;
    private int numRows;
    private HashMap <String, ArrayList <Point>> levelMap;
    private final HashMap <Point, String> tileMap;
    private final int[] spider;
    private final int[] bgColor;

    private WorldData() {
        super( new Object() );
        numRows = 0;
        tileMap = new HashMap<>();
        spider = new int[]{0, 0, 0};
        bgColor = new int[]{0, 0, 0};
        PaintMixer.setTileMap( tileMap );
    }

    public static WorldData getWorldData() {
        if ( worldData == null ) {
            worldData = new WorldData();
        }
        return worldData;
    }

    public void setLevel( HashMap <String, ArrayList<Point>> level ) {
        setLevel( level, 5, 26, 26, 26 );
    }

    public void setLevel( HashMap <String, ArrayList<Point>> level, int rows, int r, int g, int b ) {
        levelMap = level;
        if ( levelMap == null ) {
            levelMap = new HashMap<>();
        }
        numRows = rows;
        bgColor[0] = r;
        bgColor[1] = g;
        bgColor[2] = b;
        firePropertyChange( "levelMap", null, levelMap );
        firePropertyChange( "numRows", null, numRows );
        firePropertyChange( "bgColor", null, bgColor );
        resetWorld();
    }

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
        firePropertyChange( "visible", null, true );
    }

    public HashMap<String, ArrayList<Point>> getLevelMap() {
        return levelMap;
    }
    public HashMap<Point, String> getTileMap() {
        return tileMap;
    }

    public void paintTile(int x, int y, String color ) {
        PaintMixer.addPaint( x, y, color );
        firePropertyChange( "visible", null, true );
    }

    public void resetWorld() {
        tileMap.clear();
        firePropertyChange( "tileMap", null, tileMap );
        try {
            Point pos = levelMap.get("spider").get(0);
            Point rot = levelMap.get("spider").get(1);
            moveSpider(pos.getX(), pos.getY(), rot.getX());
        } catch ( NullPointerException e ) {
            moveSpider( 0, 0, 0 );
        }
    }
}

