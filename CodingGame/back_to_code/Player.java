package back_to_code;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
class Player {
    private static int Y_HEIGHT = 20;
    private static  int X_WIDTH = 35;
    
    private enum Turn{NO_TURN, LEFT, RIGHT, UP, DOWN};

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int opponentCount = in.nextInt(); // Opponent count
        int firstX = 0;
        int firstY = 0;
        // game loop
        while (true) {
            int gameRound = in.nextInt();
            int x = in.nextInt(); // Your x position
            int y = in.nextInt(); // Your y position
            if(gameRound == 0) {
                firstX = x;
                firstY = y;
            }
            int backInTimeLeft = in.nextInt(); // Remaining back in time
            for (int i = 0; i < opponentCount; i++) {
                int opponentX = in.nextInt(); // X position of the opponent
                int opponentY = in.nextInt(); // Y position of the opponent
                int opponentBackInTimeLeft = in.nextInt(); // Remaining back in time of the opponent
            }
            int[][] field = new int[Y_HEIGHT][X_WIDTH];
            for (int i = 0; i < Y_HEIGHT; i++) {
                String line = in.next(); // One line of the map ('.' = free, '0' = you, otherwise the id of the opponent)
                for(int j = 0; j < X_WIDTH; j++) {
                    field[i][j] = line.charAt(j) == '.' ? 1 :
                                  - (line.charAt(j) - '0');
                }
            }
            String command;
            int nextY;
            int nextX;
            if(x == 0) {
                if(y == 0) {
                    nextX = field[y][x + 1] == 1 ? x + 1 : x;
                    nextY = field[y][x + 1] == 1 ? y : y + 1;
                } else if (y == Y_HEIGHT - 1) {
                    nextX = field[y][x + 1] == 1 ? x + 1 : x;
                    nextY = field[y][x - 1] == 1 ? y : y - 1;
                } else {
                    nextX = x;
                    nextY = field[y][x + 1] == 1 ? y : y + 1;
                }
            } else if (x == X_WIDTH - 1) {
               if(y == 0) {
                   nextX = field[y][x - 1] == 1 ? x - 1 : x;
                   nextY = field[y][x - 1] == 1 ? y : y + 1;
               } else if (y == Y_HEIGHT - 1) {
                   nextX = field[y][x - 1] == 1 ? x - 1 : x;
                   nextY = field[y][x - 1] == 1 ? y : y - 1;
               } else {
                   nextX = x;
                   nextY = field[y][x - 1] == 1 ? y : y + 1;
               }
                
            } else {
                nextX = field[y][x + 1] == 1 ? x + 1 : field[y][x -1] == 1 ? x - 1 : x;
                nextY = y;
            }
            

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(nextX + " " + nextY); // action: "x y" to move or "BACK rounds" to go back in time
        }
    }
}
