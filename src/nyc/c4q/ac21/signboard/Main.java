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
    public static void flashPokemonScene(SignBoard board, int cycles) {
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
                frame.write(leftPosition, y - 2, "PPPPPP    0OOOO0    KK  KK  EEEEEEE  MMM    MMM    00OOOO    NNN   NN");
                frame.write(leftPosition, y - 1, "PP  PP   OO    OO   KK KK   EE       MMMM  MMMM   OO    OO   NNNN  NN");
                frame.write(leftPosition, y    , "PPPPPP  OOO    OOO  KKKK    EEEEEEE  MM MMMM MM  OOO    000  NN NN NN");
                frame.write(leftPosition, y + 1, "PP       OO    OO   KK KK   EE       MM  MM  MM   OO    OO   NN  NNNN");
                frame.write(leftPosition, y + 2, "PP        0OOOO0    KK  KK  EEEEEEE  MM  MM  MM    00OOOO    NN   NNN");

            }
//            else {
//                frame.write(rightPosition, y - 2, "GGGGGGGG    00OOOO   ");
//                frame.write(rightPosition, y - 1, "GG         OO    OO  ");
//                frame.write(rightPosition, y    , "GG  GGGG  OOO    OOO ");
//                frame.write(rightPosition, y + 1, "GG   GGG   OO    OO  ");
//                frame.write(rightPosition, y + 2, "GGGGGGGG    00OOOO   ");
//            }

            frame.finish(0.30);
        }
    }



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
            if (i % 2 == 0)
                frame.write(leftPosition, y - 4, "o_______________}o{         ");
                frame.write(leftPosition, y - 3, "|   POKEMON    |   \\       ");
                frame.write(leftPosition, y - 2, "|   CENTER     |____\\_____ ");
                frame.write(leftPosition, y - 1, "| _____        |    |_o__ | ");
                frame.write(leftPosition, y, "[/ ___ \\       |   / ___ \\|");
                frame.write(leftPosition, y + 1, "[]_/.-.\\_\\______|__/_/.-.\\_[]");
                frame.write(leftPosition, y + 2, "   |(O)|             |(O)|      ");

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

                frame.finish(0.10);
            }
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

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);
        // Run the sign board forever.
        while (true) {
//            scrollTextScene(signBoard, "POKEMON CENTER");
            ribbonScene(signBoard,10);
            flashPokemonScene(signBoard,4);
            flashGottaCatch(signBoard,4);
            flashEmAll(signBoard,4);
            flashPokemart(signBoard,4);
            flashPokeball(signBoard,4);
            flashGreatball(signBoard,4);
            flashUltraball(signBoard,4);
            flashLuckyEggs(signBoard,4);
            flashRareCandy(signBoard,4);
            flashPotions(signBoard,4);
            AmbulanceRight1(signBoard,1);
            AmbulanceRight2(signBoard,1);
            AmbulanceRight3(signBoard,1);
            AmbulanceLeft1(signBoard,1);
            AmbulanceLeft2(signBoard,1);
            AmbulanceLeft3(signBoard,1);
            ribbonScene(signBoard,10);
        }
    }
}