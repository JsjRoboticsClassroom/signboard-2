package nyc.c4q.ac21.signboard;

import javafx.beans.binding.StringBinding;

import java.util.Random;

public class Main {
    static String pictureArray[];
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
                    frame.setGreen();
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



































































































































































































































































































































































































































































































    public static void geodudeScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        StringBuilder leftString = new StringBuilder(" ");

        StringBuilder sb = new StringBuilder(" ");
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 12;
        int y = board.getHeight() / 2;
        int j = -8;
        int move = 46;
        int counter3 = -1;
        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();
            // Choose a color at random.

            if(j>-24) {
//                if(j>-16) {
//                    frame.setGreen();
//                    frame.write(rightPosition - move, y - 4, "  `,_ __..===..___..,'  ");
//                    frame.write(rightPosition - move, y - 3, "  |  `'          `'  |  ");
//                    frame.write(rightPosition - move, y - 2, "  |    :'';          |  ");
//                    frame.write(rightPosition - move, y - 1, "  | /'-.`'     '.-'\\ |  ");
//                    frame.write(rightPosition - move, y,     " /  | / |      | \\ |  \\ ");
//                    frame.write(rightPosition - move, y + 1, "|   |_\\_|      |_/_|   |");
//                    frame.write(rightPosition - move, y + 2, " \\__       . .      __/ ");
//                    frame.write(rightPosition - move, y + 3, "    `----._____.---'     ");
//                    if (j % 2 == 0)
//                        move--;
//                }
//                else {
//                    frame.setGreen();
//                    frame.write(rightPosition - move, y - 4, "  `,_ __..===..___..,'  ");
//                    frame.write(rightPosition - move, y - 3, "  |  `'          `'  |  ");
//                    frame.write(rightPosition - move, y - 2, "  |    :'';          |  ");
//                    frame.write(rightPosition - move, y - 1, "  | /'-.`'     '.-'\\ |  ");
//                    frame.write(rightPosition - move, y,     " /  | / |      | \\ |  \\ ");
//                    frame.write(rightPosition - move, y + 1, "|   |_\\_|      |_/_|   |");
//                    frame.write(rightPosition - move, y + 2, " \\__       . .      __/ ");
//                    frame.write(rightPosition - move, y + 3, "   `----._____.---'     ");
//                    if (j % 2 == 0)
//                        move++;
//                }



                frame.setBlue();

                frame.write(rightPosition + j, y - 4, "/ _\\_\\_\\");
                frame.write(rightPosition + j, y - 3, "\\_;  ,()");
                frame.write(rightPosition + j, y - 2, "  |  |        _______        /\\_\\_\\_\\");
                frame.write(rightPosition + j, y - 1, "  \\  \\       ,       ,       ()    _/");
                frame.write(rightPosition + j, y, "   \\  \\     /         \\       \\   _|");
                frame.write(rightPosition + j, y + 1, "    \\  \\__,/.  .\\  /. /\\       / /");
                frame.write(rightPosition + j, y + 2, "     \\_=____\\  ______/\\ \\_____/ /");
                frame.write(rightPosition + j, y + 3, "             \\/_____,| \\___==__/");


                j--;
            }
            else {
                int rand = random.nextInt(2);
                if(rand==0)
                    frame.setYellow();
                if(rand==1)
                    frame.setGreen();
                frame.write(rightPosition - move, y - 4, "    *     *     ");
                frame.write(rightPosition - move, y - 3, " *     *      * ");
                frame.write(rightPosition - move, y - 1, "    *     *      * ");
                frame.write(rightPosition - move, y + 1, " *    *   *   *  ");
                frame.write(rightPosition - move, y + 2, "*   *   *    *   ");
                if(rand==1)
                    frame.setYellow();
                if(rand==0)
                    frame.setGreen();

                frame.write(rightPosition +13, y - 4,    "    *     *     ");
                frame.write(rightPosition +13, y - 3, " *     *      * ");
                frame.write(rightPosition +13, y - 1, "    *     *      * ");
                frame.write(rightPosition +13, y + 1, " *    *   *   *  ");
                frame.write(rightPosition +13, y + 2, "*   *   *    *   ");


                if(i%2==0) {
                    frame.setBlue();
                    frame.writeOutsideBounds(rightPosition + j, y - 5, "/ _\\_\\_\\");
                    frame.write(rightPosition + j, y - 4, "\\_;  ,()");
                    frame.write(rightPosition + j, y - 3, "  |  |        _______        /\\_\\_\\_\\");
                    frame.write(rightPosition + j, y - 2, "  \\  \\       ,       ,       ()    _/");
                    frame.write(rightPosition + j, y - 1, "   \\  \\     /         \\       \\   _|");
                    frame.write(rightPosition + j, y, "    \\  \\__,/.  .\\  /. /\\       / /");
                    frame.write(rightPosition + j, y + 1, "     \\_=____\\  ______/\\ \\_____/ /");
                    frame.write(rightPosition + j, y + 2, "             \\/_____,| \\___==__/");

                }
                else{
                    frame.setRed();
                    frame.writeOutsideBounds(rightPosition + j, y - 5,   "           ");
                    frame.write(rightPosition + j, y - 4, "/ _\\_\\_\\");
                    frame.write(rightPosition + j, y - 3, "\\_;  ,()");
                    frame.write(rightPosition + j, y - 2, "  |  |        _______        /\\_\\_\\_\\");
                    frame.write(rightPosition + j, y - 1, "  \\  \\       ,       ,       ()    _/");
                    frame.write(rightPosition + j, y    , "   \\  \\     /         \\       \\   _|");
                    frame.write(rightPosition + j, y + 1, "    \\  \\__,/.  .\\  /. /\\       / /");
                    frame.write(rightPosition + j, y + 2, "     \\_=____\\  ______/\\ \\_____/ /");
                    frame.write(rightPosition + j, y + 3, "             \\/_____,| \\___==__/");

                }
                sb.append(" ");
                if(counter3 > -24) {
                    counter3--;
                    leftString = sb;
                }
                frame.writeOutsideBounds(rightPosition + j + 8, y - 5, sb.toString());
                frame.writeOutsideBounds(rightPosition + j + counter3 , y - 5, leftString.toString());

            }

            frame.finish(0.2);

        }
    }


    public static void testPicture(String picture){
        PictureTest pic = new PictureTest(picture);
        pictureArray = pic.pictureArray();
    }

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);


        geodudeScene(signBoard,30);
    }
}

