import processing.core.PApplet;
import processing.core.PImage;
/**
 * @author riya badadare
 */
public class TurnInstruction extends Instruction {
    public TurnInstruction(PApplet screen, int xPos, int yPos, PImage img) {
        super(screen, xPos, yPos, img);
    }
    @Override
    public TurnInstruction clone() throws CloneNotSupportedException {
        return (TurnInstruction) super.clone();
    }
    @Override
    public String toString() {
        return "turn";
    }


}