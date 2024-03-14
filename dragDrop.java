import processing.core.PApplet;
/**
 * @author andy duong
 */
public abstract class dragDrop{
    protected PApplet screen;
    protected int xPos;
    protected int yPos;
    protected int xOffset;
    protected int yOffset;
    protected boolean isDragging;

    protected dragDrop(PApplet screen, int x, int y) {
        this.screen = screen;
        this.xPos = x;
        this.yPos = y;
        this.isDragging = false;
    }

    //continuously updates the screen every x frames
    public void drag() {
        if (isDragging) {
            xPos = screen.mouseX - xOffset;
            yPos = screen.mouseY - yOffset;
        }
    }

    public abstract void display();
    public abstract boolean isMouseOver();

    public void mousePressed() {
        if(isMouseOver()){ //calculate offset for the dragging
            xOffset = Math.abs(xPos - screen.mouseX);
            yOffset = Math.abs(yPos - screen.mouseY);
            isDragging = true;
        }
    }

    public int getYPos() {
        return this.yPos;
    }

}
