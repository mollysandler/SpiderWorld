import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends PApplet{
    public static World world;
    public LoadLevels level = new LoadLevels(0);

    public void settings(){
        size(700, 700);
    }

    public void setup(){
        background(255, 255, 255);
        world = new World(this);
    }

    public void draw() {
        //System.out.println(level.getLevel());

        HashMap<String, ArrayList<Point>> map = level.loadHashMap();
        world.setLevel(map);
        world.drawWorld();
/*
        Point bluePoint1 = new Point(1, 0);
        Point greenPoint1 = new Point(3, 3);
        Point redPoint1 = new Point(2, 2);
        ArrayList<Point> bluePoints = new ArrayList<>();
        bluePoints.add(bluePoint1);
        ArrayList<Point> greenPoints = new ArrayList<>();
        greenPoints.add(greenPoint1);
        ArrayList<Point> redPoints = new ArrayList<>();
        redPoints.add(redPoint1);
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("green", greenPoints);
        map.put("red", redPoints);
*/
        level.saveHashMap(map);
       // HashMap<String, ArrayList<Point>> loadedMap = level.loadHashMap();
    }
    public static void main(String[] args) {
        String[] processingArgs = {"Driver"};
        Driver Driver = new Driver();
        PApplet.runSketch(processingArgs, Driver);
    }
}
