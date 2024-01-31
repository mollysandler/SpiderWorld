import processing.core.PApplet;

public class Main extends PApplet {
    Block testblock;

    public void settings() {
        size(1600, 900);
    }

    public void setup() {
        testblock = new Block(this, 100, 100, 150, 100);
    }

    public void draw() {
        background(255);
        testblock.display();
        testblock.drag();
    }

    public void mousePressed() {
        testblock.mousePressed();
    }

    public void mouseReleased() {
        testblock.mouseReleased();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
