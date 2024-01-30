import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends PApplet{
    public static World world;
    public LoadLevels level = new LoadLevels(1);

    public void settings(){
        size(700, 700);
    }

    public void setup(){
        background(255, 255, 255);
        world = new World(this);
    }

    public void draw() {
        System.out.println(level.getLevel());
        HashMap<String, ArrayList<Point>> map = level.loadHashMap();
        world.setLevel(map);
        world.drawWorld();


       // HashMap<String, ArrayList<Point>> loadedMap = level.loadHashMap();
    }
    public static void main(String[] args) {
        String[] processingArgs = {"Driver"};
        Driver Driver = new Driver();
        PApplet.runSketch(processingArgs, Driver);
    }
}
