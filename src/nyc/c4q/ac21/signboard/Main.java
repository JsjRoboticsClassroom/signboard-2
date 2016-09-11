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
        Random random = new Random();
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
                frame.write(x, y, "!");
        }
            if (0 < x + 1 && x + 1 < width) {
                frame.setBlue();
                frame.write(x + 1, y, "!");
        }
            if (x + 2 < width) {
                frame.setRed();
                frame.write(x + 2, y, "!");
        }
        }
            frame.finish(0.15);
        }
        }

/**
 * Draws a scene with text scrolling across the screen..
 * @param board
 *   The board on which to draw.
 * @param text
 *   The text to scroll.
 */
//    public static void scrollTextScene(SignBoard board, String text) {
//        int width = board.getWidth();
//        int y = board.getHeight() / 2;
//        for (int x = -text.length(); x <= width; ++x) {
//            SignBoard.Frame frame = board.newFrame();
//
//            if (x >= width)
//                break;
//
//            if (x < 0)
//                // Scrolling on to the left side.
//                frame.write(0, y, text.substring(-x));
//
//            else if (x + text.length() <= width)
//                // Fully on the board.
//                frame.write(x, y, text);
//
//            else
//                // Scrolling off the board.
//                frame.write(x, y, text.substring(0, width - x));
//            frame.finish(0.05);
//        }
//    }

/**
 * Draws a scene which flashes the words "POKEMON".
 * @param board
 *   The board on which to draw.
 * @param cycles
 *   The number of cycles to draw for.
 */

public static void flashGottaCatch(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 7;
        int rightPosition = 2 * width / 4 - 7;
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
            frame.write(leftPosition, y - 2, "GGGGGGGG    OOOOOO   TTTTTTTT TTTTTTTT    A    ");
            frame.write(leftPosition, y - 1, "GG         OO    OO     TT       TT      A A   ");
            frame.write(leftPosition, y    , "GG  GGGG  OOO    OOO    TT       TT     AAAAA  ");
            frame.write(leftPosition, y + 1, "GG   GGG   OO    OO     TT       TT    AA   AA ");
            frame.write(leftPosition, y + 2, "GGGGGGGG    OOOOOO      TT       TT   AA     AA");
        }
        else {
            frame.write(rightPosition, y - 2, "CCCCCCC     A   TTTTTTTT CCCCCCC  HH    HH ");
            frame.write(rightPosition, y - 1, "CC         A A     TT    CC       HH    HH ");
            frame.write(rightPosition, y    , "CC        AAAAA    TT    CC       HHHHHHHH ");
            frame.write(rightPosition, y + 1, "CC       AA   AA   TT    CC       HH    HH ");
            frame.write(rightPosition, y + 2, "CCCCCCC AA     AA  TT    CCCCCCC  HH    HH ");
        }

            frame.finish(0.20);
        }
        }

public static void flashEmAll(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 12;
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
            frame.write(leftPosition, y - 2, "EEEEEEE  MMM    MMM");
            frame.write(leftPosition, y - 1, "EE       MMMM  MMMM");
            frame.write(leftPosition, y    , "EEEEEEE  MM MMMM MM");
            frame.write(leftPosition, y + 1, "EE       MM      MM");
            frame.write(leftPosition, y + 2, "EEEEEEE  MM      MM");
        }
        else {
            frame.write(rightPosition, y - 2, "    A      LL      LL      ");
            frame.write(rightPosition, y - 1, "   A A     LL      LL      ");
            frame.write(rightPosition, y    , "  AAAAA    LL      LL      ");
            frame.write(rightPosition, y + 1, " AA   AA   LL      LL      ");
            frame.write(rightPosition, y + 2, "AA     AA  LLLLLLL LLLLLLL");
        }

            frame.finish(0.30);
        }
        }

public static void flashPokemart(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 17;
        int rightPosition = 3 * width / 4 - 17;
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
            frame.write(leftPosition, y - 2, "PPPPPP    0OOOO0    KK  KK  EEEEEEE  MMM    MMM      A      RRRRRR  TTTTTTTT");
            frame.write(leftPosition, y - 1, "PP  PP   OO    OO   KK KK   EE       MMMM  MMMM     A A     RR  RR     TT");
            frame.write(leftPosition, y    , "PPPPPP  OOO    OOO  KKKK    EEEEEEE  MM MMMM MM    AAAAA    RRRRRR     TT");
            frame.write(leftPosition, y + 1, "PP       OO    OO   KK KK   EE       MM  MM  MM   AA   AA   RR  RR     TT");
            frame.write(leftPosition, y + 2, "PP        0OOOO0    KK  KK  EEEEEEE  MM  MM  MM  AA     AA  RR   RR    TT");

        }
            frame.finish(0.30);
        }
        }

public static void flashPokeball(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 16;
        int rightPosition = 3 * width / 4 - 16;
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
            frame.write(leftPosition, y - 2, "PPPPPP    OOOOOO    KK  KK  EEEEEEE  BBBBBBB      A      LL      LL");
            frame.write(leftPosition, y - 1, "PP  PP   OO    OO   KK KK   EE       BB   BB     A A     LL      LL");
            frame.write(leftPosition, y    , "PPPPPP  OOO    OOO  KKKK    EEEEEEE  BBBBBBB    AAAAA    LL      LL");
            frame.write(leftPosition, y + 1, "PP       OO    OO   KK KK   EE       BB   BB   AA   AA   LL      LL");
            frame.write(leftPosition, y + 2, "PP        OOOOOO    KK  KK  EEEEEEE  BBBBBBB  AA     AA  LLLLLLL LLLLLLL");

        }
            frame.finish(0.10);
        }
    }

public static void flashGreatball(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 19;
        int rightPosition = 3 * width / 4 - 19;
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
            frame.write(leftPosition, y - 2, "GGGGGGGG  RRRRRR   EEEEEEE      A   TTTTTTTT BBBBBBB      A     LL      LL");
            frame.write(leftPosition, y - 1, "GG        RR  RR   EE          A A     TT    BB   BB     A A    LL      LL");
            frame.write(leftPosition, y    , "GG  GGGG  RRRRRR   EEEEEE     AAAAA    TT    BBBBBBB    AAAAA   LL      LL");
            frame.write(leftPosition, y + 1, "GG   GGG  RR  RR   EE        AA   AA   TT    BB   BB   AA   AA  LL      LL");
            frame.write(leftPosition, y + 2, "GGGGGGGG  RR   RR  EEEEEEE  AA     AA  TT    BBBBBBB  AA     AA LLLLLLL LLLLLLL");

        }
            frame.finish(0.10);
        }
        }

public static void flashUltraball(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 18;
        int rightPosition = 3 * width / 4 - 18;
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
            frame.write(leftPosition, y - 2, "UU   UU  LL    TTTTTTTT RRRRRR       A      BBBBBBB      A     LL      LL");
            frame.write(leftPosition, y - 1, "UU   UU  LL       TT    RR  RR      A A     BB   BB     A A    LL      LL");
            frame.write(leftPosition, y    , "UU   UU  LL       TT    RRRRRR     AAAAA    BBBBBBB    AAAAA   LL      LL");
            frame.write(leftPosition, y + 1, "UU   UU  LL       TT    RR  RR    AA   AA   BB   BB   AA   AA  LL      LL");
            frame.write(leftPosition, y + 2, "UUUUUUU  LLLLLLL  TT    RR   RR  AA     AA  BBBBBBB  AA     AA LLLLLLL LLLLLLL");

        }
            frame.finish(0.10);
        }
        }

public static void flashLuckyEggs(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4;
        int rightPosition = 3 * width / 4;
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
            frame.write(leftPosition, y - 2, "LL       UU   UU  CCCCCCC  KK  KK  YYY  YYY ");
            frame.write(leftPosition, y - 1, "LL       UU   UU  CC       KK KK    YY  YY  ");
            frame.write(leftPosition, y    , "LL       UU   UU  CC       KKKK       YY    ");
            frame.write(leftPosition, y + 1, "LL       UU   UU  CC       KK KK      YY    ");
            frame.write(leftPosition, y + 2, "LLLLLLL  UUUUUUU  CCCCCCC  KK  KK     YY    ");
        }
        else {
            frame.write(leftPosition, y - 2, "EEEEEEE  GGGGGGGG  GGGGGGGG  SSSSSSS");
            frame.write(leftPosition, y - 1, "EE       GG        GG        SS     ");
            frame.write(leftPosition, y    , "EEEEEEE  GG  GGGG  GG  GGGG  SSSSSSS");
            frame.write(leftPosition, y + 1, "EE       GG   GGG  GG   GGG       SS");
            frame.write(leftPosition, y + 2, "EEEEEEE  GGGGGGGG  GGGGGGGG  SSSSSSS");
        }

            frame.finish(0.15);
        }
        }

public static void flashRareCandy(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 7;
        int rightPosition = 2 * width / 4 - 7;
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
            frame.write(leftPosition, y - 2, "RRRRRR       A      RRRRRR   EEEEEEE ");
            frame.write(leftPosition, y - 1, "RR  RR      A A     RR  RR   EE      ");
            frame.write(leftPosition, y    , "RRRRRR     AAAAA    RRRRRR   EEEEEEE ");
            frame.write(leftPosition, y + 1, "RR  RR    AA   AA   RR  RR   EE      ");
            frame.write(leftPosition, y + 2, "RR   RR  AA     AA  RR   RR  EEEEEEE ");
        }
        else {
            frame.write(rightPosition, y - 2, "CCCCCCC     A      NNN   NN  DDDDDD  YYY  YYY ");
            frame.write(rightPosition, y - 1, "CC         A A     NNNN  NN  D    DD  YY  YY  ");
            frame.write(rightPosition, y    , "CC        AAAAA    NN NN NN  D    DD    YY    ");
            frame.write(rightPosition, y + 1, "CC       AA   AA   NN  NNNN  D    DD    YY    ");
            frame.write(rightPosition, y + 2, "CCCCCCC AA     AA  NN   NNN  DDDDDD     YY    ");
        }

        frame.finish(0.15);
        }
        }

public static void flashPotions(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 12;
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
        frame.write(leftPosition, y - 2, "PPPPPPP    OOOOOO   TTTTTTTT  II    OOOOOO    NNN   NN  SSSSSSS");
        frame.write(leftPosition, y - 1, "PP   PP   OO    OO     TT     II   OO    OO   NNNN  NN  SS     ");
        frame.write(leftPosition, y    , "PPPPPPP  OOO    OOO    TT     II  OOO    OOO  NN NN NN  SSSSSSS ");
        frame.write(leftPosition, y + 1, "PP        OO    OO     TT     II   OO    OO   NN  NNNN       SS ");
        frame.write(leftPosition, y + 2, "PP         OOOOOO      TT     II    OOOOOO    NN   NNN  SSSSSSS ");

        }
        frame.finish(0.10);
        }
        }

public static void AmbulanceRight1(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4   ;
        int rightPosition = 3 * width / 4 ;
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
        frame.write(leftPosition, y - 4, "o_______________}o{         ");
        frame.write(leftPosition, y - 3, "|   POKEMON    |   \\       ");
        frame.write(leftPosition, y - 2, "|   CENTER     |____\\_____ ");
        frame.write(leftPosition, y - 1, "| _____        |    |_o__ | ");
        frame.write(leftPosition, y    , "[/ ___ \\       |   / ___ \\|");
        frame.write(leftPosition, y + 1, "[]_/.-.\\_\\______|__/_/.-.\\_[]");
        frame.write(leftPosition, y + 2, "   |(O)|             |(O)|      ");
        }
        frame.finish(0.10);
        }
        }

public static void AmbulanceRight2(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 2;
        int rightPosition = 3 * width / 2;
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
        frame.write(leftPosition, y - 4, "o_______________}o{         ");
        frame.write(leftPosition, y - 3, "|   POKEMON    |   \\       ");
        frame.write(leftPosition, y - 2, "|   CENTER     |____\\_____ ");
        frame.write(leftPosition, y - 1, "| _____        |    |_o__ | ");
        frame.write(leftPosition, y, "[/ ___ \\       |   / ___ \\|");
        frame.write(leftPosition, y + 1, "[]_/.-.\\_\\______|__/_/.-.\\_[]");
        frame.write(leftPosition, y + 2, "   |(O)|             |(O)|      ");
        }
        frame.finish(0.10);
        }
        }

public static void AmbulanceRight3(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 + 25;
        int rightPosition = 3 * width / 4 + 25;
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
        frame.write(leftPosition, y - 4, "o_______________}o{         ");
        frame.write(leftPosition, y - 3, "|   POKEMON    |   \\       ");
        frame.write(leftPosition, y - 2, "|   CENTER     |____\\_____ ");
        frame.write(leftPosition, y - 1, "| _____        |    |_o__ | ");
        frame.write(leftPosition, y, "[/ ___ \\       |   / ___ \\|");
        frame.write(leftPosition, y + 1, "[]_/.-.\\_\\______|__/_/.-.\\_[]");
        frame.write(leftPosition, y + 2, "   |(O)|             |(O)|      ");
        }
        frame.finish(0.10);
        }
        }

public static void AmbulanceLeft1(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 + 4;
        int rightPosition = 3 * width / 4 + 4;
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
        frame.write(leftPosition, y - 4, "         }o{_______________o     ");
        frame.write(leftPosition, y - 3, "        /   |   POKEMON    |     ");
        frame.write(leftPosition, y - 2, "  _____/____|   CENTER     |     ");
        frame.write(leftPosition, y - 1, " | __o_|    |        _____ |     ");
        frame.write(leftPosition, y    , " |/ ___ \\   |       / ___ \\]     ");
        frame.write(leftPosition, y + 1, "[]_/.-.\\_\\__|______/_/.-.\\_[]           ");
        frame.write(leftPosition, y + 2, "   |(o)|             |(o)|             ");
        }

        frame.finish(0.10);
        }
        }

public static void AmbulanceLeft2(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 15;
        int rightPosition = 3 * width / 4 - 15;
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
        frame.write(leftPosition, y - 4, "         }o{_______________o     ");
        frame.write(leftPosition, y - 3, "        /   |   POKEMON    |     ");
        frame.write(leftPosition, y - 2, "  _____/____|   CENTER     |     ");
        frame.write(leftPosition, y - 1, " | __o_|    |        _____ |     ");
        frame.write(leftPosition, y    , " |/ ___ \\   |       / ___ \\]     ");
        frame.write(leftPosition, y + 1, "[]_/.-.\\_\\__|______/_/.-.\\_[]           ");
        frame.write(leftPosition, y + 2, "   |(o)|             |(o)|             ");
        }

        frame.finish(0.10);
        }
        }

public static void AmbulanceLeft3(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 20;
        int rightPosition = 3 * width / 4 - 20;
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
        frame.write(leftPosition, y - 4, "         }o{_______________o     ");
        frame.write(leftPosition, y - 3, "        /   |   POKEMON    |     ");
        frame.write(leftPosition, y - 2, "  _____/____|   CENTER     |     ");
        frame.write(leftPosition, y - 1, " | __o_|    |        _____ |     ");
        frame.write(leftPosition, y    , " |/ ___ \\   |       / ___ \\]     ");
        frame.write(leftPosition, y + 1, "[]_/.-.\\_\\__|______/_/.-.\\_[]           ");
        frame.write(leftPosition, y + 2, "   |(o)|             |(o)|             ");
        }

        frame.finish(0.10);
        }
        }

    public static void flashPikachu(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition =  3 * width / 4 - 8;
        int middlePosition = 3 * width / 6 - 12; //5 to not hit face
        int y = board.getHeight() / 2;
        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();
            // Choose a color at random.
            int color = random.nextInt(3);
            if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i % 2 == 0) {
                frame.write(leftPosition, y - 4, "           |`\\     ,_\t       _   ");
                frame.write(leftPosition, y - 3, "           |  `\\   \\ '.        .’.’  ");
                frame.write(leftPosition, y - 2, "           |    `\\  \\  '-\"\"\"\"-' /\t   ");
                frame.write(leftPosition, y - 1, "           `.     `\\/          |`    ");
                frame.write(leftPosition, y ,    "             `>    /;   ^     ^ \\ \t    ");
                frame.write(leftPosition, y + 1, "              /   / |       .    ;\t   ");
                frame.write(leftPosition, y + 2, "             <  (`\";\\ ()   ~~~  (/_  ");
                frame.write(leftPosition, y + 3, "              ‘;;\\__`,__ _ __ _.-‘`) ");
                frame.write(rightPosition, y - 4, "   MMMMMMM     ");
                frame.write(rightPosition, y - 3, " MMMMMMMMMMM   ");
                frame.write(rightPosition, y - 2, "MMMM/   \\MMMM ");
                frame.write(rightPosition, y - 1, "MM  \\ _ /  MM ");
                frame.write(rightPosition, y ,    " NM       MN   ");
                frame.write(rightPosition, y + 1, "    MMMMMM     ");
            }
            else {
                frame.write(leftPosition, y - 4, "           |`\\     ,_\t      _   ");
                frame.write(leftPosition, y - 3, "           |  `\\   \\ '.        .’.’  ");
                frame.write(leftPosition, y - 2, "           |    `\\  \\  '-\"\"\"\"-' /\t   ");
                frame.write(leftPosition, y - 1, "           `.     `\\/          |`    ");
                frame.write(leftPosition, y ,    "             `>    /;   O     O \\ \t    ");
                frame.write(leftPosition, y + 1, "              /   / |       .    ;\t   ");
                frame.write(leftPosition, y + 2, "             <  (`\";\\ ()  ---   (/_  ");
                frame.write(leftPosition, y + 3, "              ‘;;\\__`,__ _ __ _.-‘`) ");
                frame.write(middlePosition, y - 3, "   MMMMMMM    ");
                frame.write(middlePosition, y - 2, " MMMMMMMMMMM  ");
                frame.write(middlePosition, y - 1, "MMMM/  \\MMMM ");
                frame.write(middlePosition, y ,    "MM  \\ _ /  MM");
                frame.write(middlePosition, y + 1, " NM       MN  ");
                frame.write(middlePosition, y + 2, "    MMMMMM    ");
            }
            frame.finish(0.40);
        }
    }

    public static void pokemonTitleBoard(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int frameOne = width /2 - 30;
        int frameTwo = width /2 - 30;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 4; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.

            if (i == 0) {
                frame.write(frameOne, y - 4, "");

            }
            if (i == 1) {
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");

            }

            if (i == 2) {
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");

            }

            if (i == 3) {
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");

            }

            if (i == 4) {
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");

            }

            if (i == 5) {
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");

            }

            if (i == 6) {
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");

            }

            if (i == 7) {
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");

            }


            if (i == 8){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 9){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 10){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 11){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 12){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 13){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 14){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 15){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 16){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 17){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 18){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 19){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 20){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 21){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 22){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 23){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 24){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }


            if (i == 25){
                frame.write(frameOne, y - 4, "  .:XHHHHk.              db.   .;;.     dH  MX                 ");
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 26){
                frame.write(frameOne, y - 3, "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN      ");
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 27){
                frame.write(frameOne, y - 2, "QMMMMMb    MMX       MMMMMMP !M'  :M~   MMM MMM  .oo. XMMM 'MMM");
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 28){
                frame.write(frameOne, y - 1, "  `MMMM.  )M> :X!Hk. MMMM   XMM.oMM  .  MMMMMMM X?XMMM MMM>!MM ");
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 29){
                frame.write(frameOne, y    , "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM    MX MMXXMM  ");
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 30){
                frame.write(frameOne, y + 1, "    ~MMMMM~ XMM. .XM XM` MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP  ");
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 31){
                frame.write(frameOne, y + 2, "     ?MMM>   MMMMMM! MM  `?MMRb.    MMM       MMMMM  XXM IMMM  ");
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }

            if (i == 32){
                frame.write(frameOne, y + 3, "      MMMX                                          dMI  IMMP  ");
            }
            if (i == 33){

            }
            frame.finish(0.10);
        }
    }

    public static void controllerFlash(SignBoard board, int cycles) {
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
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i % 2 == 0) {
                frame.write(leftPosition, y - 2, " ▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▄ ");
                frame.write(leftPosition, y - 1, "█░░░█░░░░░░░░░░▄▄░██░█");
                frame.write(leftPosition, y    , "█░▀▀█▀▀░▄▀░▄▀░░▀▀░▄▄░█");
                frame.write(leftPosition, y + 1, "█░░░▀░░░▄▄▄▄▄░░██░▀▀░█");
                frame.write(leftPosition, y + 2, " ▀▄▄▄▄▄▀─────▀▄▄▄▄▄▄▀");
            }
            else {
                frame.write(rightPosition, y - 2, " ▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▄ ");
                frame.write(rightPosition, y - 1, "█░░░█░░░░░░░░░░▄▄░██░█");
                frame.write(rightPosition, y    , "█░▀▀█▀▀░▄▀░▄▀░░▀▀░▄▄░█");
                frame.write(rightPosition, y + 1, "█░░░▀░░░▄▄▄▄▄░░██░▀▀░█");
                frame.write(rightPosition, y + 2, " ▀▄▄▄▄▄▀─────▀▄▄▄▄▄▄▀");
            }

            frame.finish(0.40);
        }
    }

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
                frame.setWhite();

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



    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);
        // Run the sign board forever.
        while (true) {
        pokemonTitleBoard(signBoard, 8);
        flashPokemart(signBoard,4);
        controllerFlash(signBoard, 2);
        flashGottaCatch(signBoard,2);
        flashEmAll(signBoard,2);
        flashPokeball(signBoard,4);
        flashPikachu(signBoard,2);
        flashGreatball(signBoard,4);
        flashPikachu(signBoard,2);
        flashUltraball(signBoard,4);
        flashPikachu(signBoard,2);
        flashLuckyEggs(signBoard,4);
        flashRareCandy(signBoard,4);
        flashPotions(signBoard,4);
        geodudeScene(signBoard,30);
        AmbulanceRight1(signBoard,1);
        AmbulanceRight2(signBoard,1);
        AmbulanceRight3(signBoard,1);
        AmbulanceLeft1(signBoard,1);
        AmbulanceLeft2(signBoard,1);
        AmbulanceLeft3(signBoard,1);
        flashGottaCatch(signBoard,2);
        flashEmAll(signBoard,2);
        pokemonTitleBoard(signBoard, 8);
        ribbonScene(signBoard,5);
        }
        }
        }