import processing.core.PApplet;

public final class World {
    public PApplet screen;
    public int leftPadding = 9;
    public int topPadding = 143;
    public int numRows;
    public int tileWidth;
    public String currentLevel;

    public World( PApplet screen ) {
        this.screen = screen;
    }

    public void setLevel(){
//        assign JSON of current problem to currentLevel
    }

    public void readLevel() {
//        read currentLevel
        numRows = 5;
        tileWidth = 60;
    }

    public void drawGrid() {
        screen.fill( screen.color( 110, 113, 132 ) );
        screen.stroke( 204, 204, 204 );
        screen.rect( leftPadding, topPadding, tileWidth*numRows, tileWidth*numRows );
        for (int row = 1; row < numRows; row++) {
            screen.line( leftPadding, topPadding + tileWidth*row, leftPadding + tileWidth*numRows, topPadding + tileWidth*row );
        }
        for (int col = 1; col < numRows; col++) {
            screen.line( leftPadding + tileWidth*col, topPadding, leftPadding + tileWidth*col, topPadding + tileWidth*numRows );
        }
    }

    public void drawEntities() {
        screen.image( screen.loadImage( "images/spider.png" ), leftPadding, topPadding );
    }

    public void drawWorld() {
        readLevel();
        drawGrid();
        drawEntities();
    }
}
