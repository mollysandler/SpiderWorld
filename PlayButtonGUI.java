import processing.core.PApplet;
import processing.core.PImage;

public class PlayButtonGUI {

    public PApplet screen;
    private int xPos, yPos, width, height;
    private PImage img;

    public PlayButtonGUI(PApplet screen, int xPos, int yPos, PImage img){
        this.screen = screen;
        this.xPos = xPos;
        this.yPos = yPos;
        this.img = img;
        this.width = img.width;
        this.height = img.height;
    }

    public void display(){screen.image(img, xPos, yPos);}

    private boolean isMouseOver() {
        return (((xPos < screen.mouseX) && (screen.mouseX < xPos + width))
                && ((yPos < screen.mouseY) && (screen.mouseY < yPos + height)));
    }

    public void mousePressed(){
        if(isMouseOver()){
            PlayButtonFunc func = new PlayButtonFunc();
            func.run();
        }
    }

}
