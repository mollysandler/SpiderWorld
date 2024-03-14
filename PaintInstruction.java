import processing.core.PApplet;
import processing.core.PImage;

public class PaintInstruction extends Instruction {

    private String color;

    public PaintInstruction(PApplet screen, int xPos, int yPos, PImage img, String color) {
        super(screen, xPos, yPos, img);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
