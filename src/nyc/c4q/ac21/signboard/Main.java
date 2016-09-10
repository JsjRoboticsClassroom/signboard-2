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
    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
//            ribbonScene(signBoard, 48);
//            scrollTextScene(signBoard, "###  F A L A F E L  ###");
//            ribbonScene(signBoard, 48);
            pokemonTitleBoard(signBoard, 8);
            controllerFlash(signBoard, 8);
        }
    }
}
