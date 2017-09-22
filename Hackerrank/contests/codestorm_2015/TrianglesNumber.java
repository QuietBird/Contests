import java.awt.*;
import java.awt.geom.Rectangle2D;

class Solution {
    public int solution(int x1_1, int y1_1, int x2_1, int y2_1, int x1_2, int y1_2, int x2_2, int y2_2)     {
        long area1 = (x2_1 - x1_1) * (y2_1 - y1_1);
        long area2 = (x2_2 - x1_2) * (y2_2 - y1_2);
        long intersectionArea = findCommonArea(x1_1, y1_1, x2_1, y2_1, x1_2, y1_2, x2_2, y2_2);
        long summ = area1 + area2 - intersectionArea;
        if(summ > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)summ;
    }

    private static long findCommonArea(int x1_1, int y1_1, int x2_1, int y2_1, int x1_2, int y1_2, int x2_2, int y2_2)
    {
        int width1 = (x2_1 - x1_1);
        int height1 = (y2_1 - y1_1);
        int width2 = (x2_2 - x1_2);
        int height2 = (y2_2 - y1_2);

        Rectangle r1 = new Rectangle(x1_1, y1_1 + height1, width1, height1);
        Rectangle r2 = new Rectangle(x1_2, y1_2 + height2, width2, height2);
        Rectangle2D intersection = r1.createIntersection(r2);
        if(intersection.isEmpty())
            return 0;
        return Math.round(intersection.getWidth() * intersection.getHeight());
    }
}