import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class MarsLander {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the number of points used to draw the surface of Mars.
        int prevY = -1;
        int prevX = -1;
        int xStart =-1;
        int xEnd = -1;
        int height = 0;
        int[] surfaceX = new int[N];
        int[] surfaceY = new int[N];
        for (int i = 0; i < N; i++) {            
            int LAND_X = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int LAND_Y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            surfaceX[i] = LAND_X;
            surfaceY[i] = LAND_Y;
            if(prevY != LAND_Y) {
                prevX = LAND_X;
                prevY = LAND_Y;
            } else {
                xStart = prevX;
                xEnd = LAND_X;
                height = LAND_Y;
            }
        }

        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int HS = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int VS = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int F = in.nextInt(); // the quantity of remaining fuel in liters.
            int R = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int P = in.nextInt(); // the thrust power (0 to 4).
            String command = R +" " +P;
            if(X > xEnd || X < xStart) {
               // command = goToLandingZone();
            } else {
                //command = normalize();
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("-20 3"); // R P. R is the desired rotation angle. P is the desired thrust power.
        }
    }
    
    
    
    // vs = vs0 - (g - cos R * P)t
    // hs = hs0 + sin R * P * t
    // s = s0 + v*t + a*t^2 /2
}