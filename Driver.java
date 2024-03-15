import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author molly sandler
 */
public class Driver extends PApplet{

    private WorldData worldData;
    private LoadLevels level;
    Instruction[] originalInstructions;
    // blocks from the sidebar
    private StepInstruction stepBlock;
    private TurnInstruction turnBlock;
    private PaintInstruction paintBlueBlock;
    private PaintInstruction paintGreenBlock;
    private PaintInstruction paintRedBlock;
    private PlayButtonGUI playButton;
    // to store any new blocks dragged into the game
    InstructionList instructionCopies = InstructionList.getInstance();

    @Override
    public void settings(){
        size(1200, 900);
    }

    @Override
    public void setup(){
        worldData = WorldData.getWorldData();
        WorldView worldView = new WorldView(this);
        worldData.addPropertyChangeListener(worldView);
        LevelGenerator levelGenerator = new LevelGenerator();
        level = new LoadLevels(1);

        PImage stepBlockImage = loadImage("images/step.png");
        stepBlock = new StepInstruction(this, 1000, 200, stepBlockImage);

        PImage turnBlockImage = loadImage("images/turn.png");
        turnBlock = new TurnInstruction(this, 1000, 275, turnBlockImage);

        PImage paintBlueBlockImage = loadImage("images/paint_blue.png");
        paintBlueBlock = new PaintInstruction(this, 1000, 350, paintBlueBlockImage, "blue");

        PImage paintGreenBlockImage = loadImage("images/paint_green.png");
        paintGreenBlock = new PaintInstruction(this, 1000, 425, paintGreenBlockImage, "green");

        PImage paintRedBlockImage = loadImage("images/paint_red.png");
        paintRedBlock = new PaintInstruction(this, 1000, 500, paintRedBlockImage, "red");

        PImage startButtonImg = loadImage("images/playButtonImg.png");
        playButton = new PlayButtonGUI(this, 100, 500, startButtonImg);

        originalInstructions = new Instruction[]{stepBlock, turnBlock, paintBlueBlock, paintGreenBlock, paintRedBlock};

    }
    @Override
    public void draw() {
        background(100, 100, 100);
        playButton.display();
        for (Instruction currInstruction : originalInstructions) {
            currInstruction.display();
        }
        HashMap<String, ArrayList<Point>> map = level.loadHashMap();
        worldData.setLevel(map);
        stepBlock.drag();
        turnBlock.drag();
        level.saveHashMap(map);

        //displays all copies
        for (Instruction currInstruction : InstructionList.getInstance().getSortedInstructions()) {
            currInstruction.drag();
            currInstruction.display();
        }
    }

    @Override
    public void mousePressed() {
        playButton.mousePressed();
        //when on original blocks, will create copies and will automatically be dragging copies
        for(Instruction currInstruction: originalInstructions) {
            if (currInstruction.isMouseOver()) {
                Instruction copy = null; // Create a copy
                try {
                    copy = currInstruction.clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(copy);
                copy.mousePressed();
                instructionCopies.addInstruction(copy); // Add the copy to the list
                break;
            }
        }
        //lets you drag around copies that you've dropped
        for (Instruction copy : InstructionList.getInstance().getSortedInstructions()) {
            copy.mousePressed();
        }
    }

    @Override
    public void mouseReleased() {

        List<Instruction> instructions = instructionCopies.getSortedInstructions();

        for (Instruction currInstruction : instructions) {
            currInstruction.isDragging = false;
        }

        // Snapping to other blocks
        for (int i = 0; i < instructions.size(); i++) {
            for (int j = 0; j < instructions.size(); j++) {
                if (i == j) continue;

                Instruction a = instructions.get(i);
                Instruction b = instructions.get(j);

                if (a.toSnap(b)) {
                    if (a.yPos < b.yPos) {
                        b.xPos = a.xPos;
                        b.yPos = a.yPos + 50;
                    }
                    else {
                        a.xPos = b.xPos;
                        a.yPos = b.yPos + 50;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"Driver"};
        Driver running = new Driver();
        PApplet.runSketch(processingArgs, running);
    }
}
