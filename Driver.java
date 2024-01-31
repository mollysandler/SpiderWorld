import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends PApplet{
    private World world;
    private LoadLevels level;

    @Override
    public void settings(){
        size(700, 700);
    }

    @Override
    public void setup(){
        background(255, 255, 255);
        world = new World(this);
        level = new LoadLevels(0);
    }

    @Override
    public void draw() {

        HashMap<String, ArrayList<Point>> map = level.loadHashMap();
        world.setLevel(map);
        world.drawWorld();
        level.saveHashMap(map);
    }
    public static void main(String[] args) {
        String[] processingArgs = {"Driver"};
        Driver running = new Driver();
        PApplet.runSketch(processingArgs, running);
    }
}
