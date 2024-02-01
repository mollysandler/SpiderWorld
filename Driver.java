import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends PApplet{

    private World world;
    private LoadLevels level;
    private StepInstruction testBlock;
    private TurnInstruction testBlock2;

    @Override
    public void settings(){
        size(1600, 900);
    }

    @Override
    public void setup(){
        world = new World(this);
        level = new LoadLevels(0);

        PImage stepBlockImage = loadImage("images/step.png");
        testBlock = new StepInstruction(this, 500, 500, stepBlockImage);

        PImage turnBlockImage = loadImage("images/turn.png");
        testBlock2 = new TurnInstruction(this, 600, 600, turnBlockImage);
    }
    @Override
    public void draw() {
        background(100, 100, 100);
        HashMap<String, ArrayList<Point>> map = level.loadHashMap();
        world.setLevel(map);
        world.drawWorld();
        testBlock.display();
        testBlock.drag();
        testBlock2.display();
        testBlock2.drag();
        level.saveHashMap(map);
    }

    @Override
    public void mousePressed() {
        testBlock.mousePressed();
        testBlock2.mousePressed();

    }

    @Override
    public void mouseReleased() {
        testBlock.mouseReleased();
        testBlock2.mouseReleased();

    }

    public static void main(String[] args) {
        String[] processingArgs = {"Driver"};
        Driver running = new Driver();
        PApplet.runSketch(processingArgs, running);
    }
}
