import java.util.ArrayList;
import java.util.HashMap;

public class LevelGenerator {
    public LevelGenerator() {
        level1();
        level2();
        level3();
        level4();
        level5();
        level6();
        level7();
    }

    public static void level1() {
        LoadLevels lvl = new LoadLevels(1);

        // Create points
        Point bluePoint1 = new Point(4, 1);
        Point redPoint1 = new Point(1, 1);
        Point greenPoint1 = new Point(1, 2);
        Point spiderLoc = new Point(1, 3);
        Point spiderDirection = new Point(1, 0);

        // Create ArrayLists and add points
        ArrayList<Point> bluePoints = new ArrayList<>();
        bluePoints.add(bluePoint1);
        ArrayList<Point> redPoints = new ArrayList<>();
        redPoints.add(redPoint1);
        ArrayList<Point> greenPoints = new ArrayList<>();
        greenPoints.add(greenPoint1);
        ArrayList<Point> spider = new ArrayList<>();
        spider.add(spiderLoc);
        spider.add(spiderDirection);

        // Create map and add ArrayLists
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("red", redPoints);
        map.put("green", greenPoints);
        map.put("spider", spider);

        lvl.saveHashMap(map);
    }
    public static void level2() {
        LoadLevels lvl = new LoadLevels(2);

        // Create points
        Point bluePoint1 = new Point(2, 1);
        Point redPoint1 = new Point(1, 4);
        Point greenPoint1 = new Point(1, 1);
        Point spiderLoc = new Point(3, 3);
        Point spiderDirection = new Point(1, 0);

        // Create ArrayLists and add points
        ArrayList<Point> bluePoints = new ArrayList<>();
        bluePoints.add(bluePoint1);
        ArrayList<Point> redPoints = new ArrayList<>();
        redPoints.add(redPoint1);
        ArrayList<Point> greenPoints = new ArrayList<>();
        greenPoints.add(greenPoint1);
        ArrayList<Point> spider = new ArrayList<>();
        spider.add(spiderLoc);
        spider.add(spiderDirection);

        // Create map and add ArrayLists
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("red", redPoints);
        map.put("green", greenPoints);
        map.put("spider", spider);

        lvl.saveHashMap(map);
    }
    public static void level3() {
        LoadLevels lvl = new LoadLevels(3);

        // Create points
        Point bluePoint1 = new Point(4, 1);
        Point bluePoint2 = new Point(2, 2);
        Point redPoint1 = new Point(1, 1);
        Point redPoint2 = new Point(3, 1);
        Point spiderLoc = new Point(2, 3);
        Point spiderDirection = new Point(1, 0);

        // Create ArrayLists and add points
        ArrayList<Point> bluePoints = new ArrayList<>();
        bluePoints.add(bluePoint1);
        bluePoints.add(bluePoint2);
        ArrayList<Point> redPoints = new ArrayList<>();
        redPoints.add(redPoint1);
        redPoints.add(redPoint2);
        ArrayList<Point> greenPoints = new ArrayList<>();
        ArrayList<Point> spider = new ArrayList<>();
        spider.add(spiderLoc);
        spider.add(spiderDirection);

        // Create map and add ArrayLists
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("red", redPoints);
        map.put("green", greenPoints);
        map.put("spider", spider);

        lvl.saveHashMap(map);
    }
    public static void level4() {
        LoadLevels lvl = new LoadLevels(4);

        // Create points
        Point bluePoint1 = new Point(1, 1);
        Point bluePoint2 = new Point(3, 1);
        Point spiderLoc = new Point(2, 3);
        Point spiderDirection = new Point(3, 0);

        // Create ArrayLists and add points
        ArrayList<Point> bluePoints = new ArrayList<>();
        bluePoints.add(bluePoint1);
        bluePoints.add(bluePoint2);
        ArrayList<Point> redPoints = new ArrayList<>();
        ArrayList<Point> greenPoints = new ArrayList<>();
        ArrayList<Point> spider = new ArrayList<>();
        spider.add(spiderLoc);
        spider.add(spiderDirection);

        // Create map and add ArrayLists
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("red", redPoints);
        map.put("green", greenPoints);
        map.put("spider", spider);

        lvl.saveHashMap(map);
    }
    public static void level5() {
        LoadLevels lvl = new LoadLevels(5);

        // Create points
        Point bluePoint1 = new Point(4, 3);
        Point greenPoint1 = new Point(4, 4);
        Point greenPoint2 = new Point(2, 4);
        Point spiderLoc = new Point(4, 2);
        Point spiderDirection = new Point(3, 0);

        // Create ArrayLists and add points
        ArrayList<Point> bluePoints = new ArrayList<>();
        bluePoints.add(bluePoint1);
        ArrayList<Point> redPoints = new ArrayList<>();
        ArrayList<Point> greenPoints = new ArrayList<>();
        greenPoints.add(greenPoint1);
        greenPoints.add(greenPoint2);
        ArrayList<Point> spider = new ArrayList<>();
        spider.add(spiderLoc);
        spider.add(spiderDirection);

        // Create map and add ArrayLists
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("red", redPoints);
        map.put("green", greenPoints);
        map.put("spider", spider);

        lvl.saveHashMap(map);
    }
    public static void level6() {
        LoadLevels lvl = new LoadLevels(6);

        // Create points
        Point bluePoint1 = new Point(1, 2);
        Point bluePoint2 = new Point(2, 2);
        Point bluePoint3 = new Point(3, 2);
        Point redPoint1 = new Point(1, 0);
        Point redPoint2 = new Point(1, 1);
        Point greenPoint1 = new Point(3, 0);
        Point greenPoint2 = new Point(3, 1);
        Point spiderLoc = new Point(0, 0);
        Point spiderDirection = new Point(0, 0);

        // Create ArrayLists and add points
        ArrayList<Point> bluePoints = new ArrayList<>();
        bluePoints.add(bluePoint1);
        bluePoints.add(bluePoint2);
        bluePoints.add(bluePoint3);
        ArrayList<Point> redPoints = new ArrayList<>();
        redPoints.add(redPoint1);
        redPoints.add(redPoint2);
        ArrayList<Point> greenPoints = new ArrayList<>();
        greenPoints.add(greenPoint1);
        greenPoints.add(greenPoint2);
        ArrayList<Point> spider = new ArrayList<>();
        spider.add(spiderLoc);
        spider.add(spiderDirection);

        // Create map and add ArrayLists
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("red", redPoints);
        map.put("green", greenPoints);
        map.put("spider", spider);

        lvl.saveHashMap(map);
    }
    public static void level7() {
        LoadLevels lvl = new LoadLevels(7);

        // Create points
        Point redPoint1 = new Point(1, 0);
        Point spiderLoc = new Point(0, 0);
        Point spiderDirection = new Point(0, 0);

        // Create ArrayLists and add points
        ArrayList<Point> bluePoints = new ArrayList<>();
        ArrayList<Point> redPoints = new ArrayList<>();
        redPoints.add(redPoint1);
        ArrayList<Point> greenPoints = new ArrayList<>();
        ArrayList<Point> spider = new ArrayList<>();
        spider.add(spiderLoc);
        spider.add(spiderDirection);

        // Create map and add ArrayLists
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        map.put("blue", bluePoints);
        map.put("red", redPoints);
        map.put("green", greenPoints);
        map.put("spider", spider);

        lvl.saveHashMap(map);
    }
}
