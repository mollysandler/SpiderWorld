import processing.core.PApplet;
import java.lang.Math;

public class drag_drop extends PApplet{
    Block testblock;

    int xOffset, yOffset;

    //initialize window size
    public void settings() {
        size(1600, 900);
    }

    //create testblock
    public void setup(){
        testblock = new Block(100, 100, 150, 100);
    }

    //continuously updates the screen every x frames
    public void draw() {
        background(255); //makes background white
        testblock.display();

        if (testblock.attachedMouse) { //if testblock is attached to mouse, reposition block (make it look like its moving with the mouse)
            testblock.x_pos = mouseX - xOffset;
            testblock.y_pos = mouseY - yOffset;
        }
    }

    public void mousePressed() {
        if(testblock.mouseOver(mouseX, mouseY)){ //calculate offset for the dragging
            xOffset = Math.abs(testblock.x_pos - mouseX);
            yOffset = Math.abs(testblock.y_pos - mouseY);

            testblock.attachedMouse = true;
        }
    }

    public void mouseReleased() { // once mouse is released it will release the block with it
        testblock.attachedMouse = false;
    }

    public class Block{
        int x_pos, y_pos, width, height;

        boolean attachedMouse = false;

        public Block(int x_pos, int y_pos, int width, int height){
            this.x_pos = x_pos;
            this.y_pos = y_pos;
            this.width = width;
            this.height = height;
        }

        public void display(){
            fill(120);
            rect(x_pos, y_pos, width, height);
        }

        boolean mouseOver(int xMouse, int yMouse){
            //shapes are created starting top left corner
            return (((x_pos < xMouse) && (xMouse < x_pos + width)) && ((y_pos < yMouse) && (yMouse < y_pos + height)));
        }

    }

    public static void main(String[] args){
        PApplet.main("drag_drop");
    }
}
