import processing.core.PApplet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jemma arona
 */
public final class WorldView implements PropertyChangeListener {
    public final PApplet screen;
    private static final float leftPadding = 9;
    private static final float topPadding = 143;
    private float tileWidth = 60;
    private boolean visible;
    private int numRows;
    private int bgColor;
    private int[] spider;
    private HashMap <String, ArrayList <Point>> levelMap;
    private HashMap <ArrayList <Point>, String> tileMap;
    private String IMAGEFOLDERPATH = "images/";

    public WorldView(PApplet screen) {
        this.screen = screen;
    }

    public void readLevel() {
//        edit if level has different size or background color
        numRows = 5;
        tileWidth = 60;
        bgColor = screen.color( 110, 113, 132 );
    }

    public void drawGrid() {
        screen.fill( bgColor );
        screen.stroke( 204, 204, 204 );
        screen.rect( leftPadding, topPadding, tileWidth * numRows, tileWidth * numRows );
        for ( int row = 1; row < numRows; row++ ) {
            screen.line( leftPadding, topPadding + tileWidth * row,
                    leftPadding + tileWidth * numRows, topPadding + tileWidth * row );
        }
        for ( int col = 1; col < numRows; col++ ) {
            screen.line( leftPadding + tileWidth * col, topPadding,
                    leftPadding + tileWidth * col, topPadding + tileWidth * numRows );
        }
    }

    public void drawEntities() {
        screen.textSize( 12 );
        // draw red diamonds
        if ( levelMap.containsKey( "red" ) ) {
            screen.fill( screen.color( 255, 89, 94 ) );
            for ( Point P : levelMap.get( "red" ) ) {
                float diamondX = (float) ( leftPadding + tileWidth * ( P.getX() + .5 ) - 5 );
                float diamondY = (float) ( topPadding + tileWidth * ( P.getY() + .5 ) + 5 );
                screen.text('◆', diamondX, diamondY );
            }
        }
        // draw blue diamonds
        if ( levelMap.containsKey( "blue" ) ) {
            screen.fill( screen.color( 63, 166, 231 ) );
            for ( Point P : levelMap.get( "blue" ) ) {
                float diamondX = (float) ( leftPadding + tileWidth * ( P.getX() + .5 ) - 5 );
                float diamondY = (float) ( topPadding + tileWidth * ( P.getY() + .5 ) + 5 );
                screen.text('◆', diamondX, diamondY );
            }
        }
        // draw green diamonds
        if ( levelMap.containsKey( "green" ) ) {
            screen.fill( screen.color( 138, 201, 38 ) );
            for ( Point P : levelMap.get( "green" ) ) {
                float diamondX = (float) ( leftPadding + tileWidth * ( P.getX() + .5 ) - 5 );
                float diamondY = (float) ( topPadding + tileWidth * ( P.getY() + .5 ) + 5 );
                screen.text('◆', diamondX, diamondY );
            }
        }
        screen.image( screen.loadImage
                        ( IMAGEFOLDERPATH + "spider_east.png" ),
                leftPadding, topPadding );
    }

    public void drawWorld() {
        drawGrid();
        drawEntities();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch ( evt.getPropertyName() ) {
            case "bgColor":
                bgColor = screen.color(((int[]) evt.getNewValue())[0], ((int[]) evt.getNewValue())[1], ((int[]) evt.getNewValue())[2]);
                break;
            case "numRows":
                numRows = (int) evt.getNewValue();
                break;
            case "levelMap":
                levelMap = (HashMap<String, ArrayList<Point>>) evt.getNewValue();
                break;
            case "tileMap":
                tileMap = (HashMap<ArrayList<Point>, String>) evt.getNewValue();
                break;
            case "spider":
                spider = (int[]) evt.getNewValue();
                break;
            case "visible":
                visible = (boolean) evt.getNewValue();
                if (visible) drawWorld();
                break;
        }
    }
}
