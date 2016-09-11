package nyc.c4q.ac21.signboard;


import java.util.Random;

public class Main {
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     * @param board
     *   The board on which to draw.
     * @param numCycles
     *   The number of cycles to draw for.
     */
    public static void ribbonScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = -2; x < width; ++x) {
                int y = (2 * height - 2 + x + i) % (2 * height - 2);
                if (y >= height)
                    y = 2 * height - y - 2;
                if (0 < x) {
                    frame.setYellow();
                    frame.write(x, y, "*");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setBlue();
                    frame.write(x + 1, y, "*");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "*");
                }
            }

            frame.finish(0.02);
        }
    }

    /**
     * Draws a scene with text scrolling across the screen..
     * @param board
     *   The board on which to draw.
     * @param text
     *   The text to scroll.
     */
    public static void scrollTextScene(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));

            frame.finish(0.02);
        }
    }

    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */
    public static void flashFreshHotScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 7;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setBlue();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setYellow();
            else
                frame.setWhite();
            // Write a word.
            if (i % 2 == 0) {
                frame.write(leftPosition, y - 2, "PPPPPP    0OOOO0    KK   KK  EEEEEEE  MMM    MMM    00OOOO    NNN   NN");
                frame.write(leftPosition, y - 1, "PP  PP   OO    OO   KK  KK   EE       MMMM  MMMM   OO    OO   NNNN  NN");
                frame.write(leftPosition, y    , "PPPPPP  OOO    OOO  KKKK     EEEEEEE  MM MMMM MM  OOO    000  NN NN NN");
                frame.write(leftPosition, y + 1, "PP       OO    OO   KK KK    EE       MM  MM  MM   OO    OO   NN  NNNN");
                frame.write(leftPosition, y + 2, "PP        0OOOO0    KK   KK  EEEEEEE  MM  MM  MM    00OOOO    NN   NNN");
            }
            else {
                frame.write(rightPosition, y - 2, "GGGGGGGG    00OOOO   ");
                frame.write(rightPosition, y - 1, "GG         OO    OO  ");
                frame.write(rightPosition, y    , "GG  GGGG  OOO    OOO ");
                frame.write(rightPosition, y + 1, "GG   GGG   OO    OO  ");
                frame.write(rightPosition, y + 2, "GGGGGGGG    00OOOO   ");
            }

            frame.finish(0.25);
        }
    }

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
            ribbonScene(signBoard, 48);
            scrollTextScene(signBoard, "###  P O K M O N   G O  ###");
            ribbonScene(signBoard, 48);
            flashFreshHotScene(signBoard, 8);
        }
    }
}