import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 * horis       vert
1 1 0		1 0 0    (0 1 H) (1 0 V) Illegal
0 0 0 		1 0 0
0 0 0		0 0 0

0 1 1		1 0 0     (1 1 H) (1 0 V)        1
0 0 0 		1 0 0
0 0 0		0 0 0

1 1 0		0 0 0     (0 1 H) (1 1 V)        2
0 0 0 		1 0 0
0 0 0		1 0 0

1 1 0		0 1 0     (0 1 H) (2 0 V)        3
0 0 0 		0 1 0
0 0 0		0 0 0

0 0 0		1 0 0     (0 2 H) (1 0 V)        4
1 1 0 		1 0 0
0 0 0		0 0 0


0 1 1		0 0 0     (1 1 H) (1 1 V)        5
0 0 0 		1 0 0
0 0 0		1 0 0

1 1 0		0 0 0     (0 1 H) (2 1 V)        6
0 0 0 		0 1 0
0 0 0		0 1 0

0 0 0		0 1 0     (0 2 H) (2 0 V)        7
1 1 0 		0 1 0
0 0 0		0 0 0

0 0 0		1 0 0     (1 2 H) (1 0 V)        8
0 1 1 		1 0 0
0 0 0		0 0 0
 */
public class TestPlayer {
    
    @Test 
    public void testCross0() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(0, 1);
        assertFalse(Player.WallBuilder.canMakeVerticalWall(new Point(1, 0), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(1, 0);
        assertFalse(Player.WallBuilder.canMakeHorizontalWall(new Point(0, 1), field));
    }

    @Test
    public void testContinuation0() {
        Player.Field field = new Player.Field(4, 4);
        field.addHorizontalWall(0, 1);
        assertFalse(Player.WallBuilder.canMakeHorizontalWall(new Point(0, 1), field));
        assertFalse(Player.WallBuilder.canMakeHorizontalWall(new Point(1, 1), field));
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(2, 1), field));
        field = new Player.Field(4, 4);
        field.addVerticalWall(1, 0);
        assertFalse(Player.WallBuilder.canMakeVerticalWall(new Point(1, 0), field));
        assertFalse(Player.WallBuilder.canMakeVerticalWall(new Point(1, 1), field));
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(1, 2), field));
    }


    @Test
    public void testContinuationGame() {
        Player.Field field = new Player.Field(9, 9);
        field.addVerticalWall(8, 5);
        assertFalse(Player.WallBuilder.canMakeVerticalWall(new Point(8, 6), field));
    }
    
    @Test
    // (1 1 H) (1 0 V)
    public void testCross1() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(1, 1);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(1, 0), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(1, 0);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(1, 1), field));
    }

    @Test
    // (0 1 H) (1 1 V)
    public void testCross2() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(0, 1);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(1, 1), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(1, 1);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(0, 1), field));
    }

    @Test
    // (0 1 H) (2 0 V)
    public void testCross3() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(0, 1);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(2, 0), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(2, 0);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(0, 1), field));
    }

    @Test
    // (0 2 H) (1 0 V)
    public void testCross4() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(0, 2);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(1, 0), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(1, 0);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(0, 2), field));
    }

    @Test
    // (1 1 H) (1 1 V)
    public void testCross5() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(1, 1);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(1, 1), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(1, 1);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(1, 1), field));
    }

    @Test
    // (0 1 H) (2 1 V)
    public void testCross6() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(0, 1);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(2, 1), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(2, 1);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(0, 1), field));
    }

    @Test
    // (0 2 H) (2 0 V)
    public void testCross7() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(0, 2);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(2, 0), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(2, 0);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(0, 2), field));
    }

    @Test
    // (1 2 H) (1 0 V)
    public void testCross8() {
        Player.Field field = new Player.Field(3, 3);
        field.addHorizontalWall(1, 2);
        assertTrue(Player.WallBuilder.canMakeVerticalWall(new Point(1, 0), field));
        field = new Player.Field(3, 3);
        field.addVerticalWall(1, 0);
        assertTrue(Player.WallBuilder.canMakeHorizontalWall(new Point(1, 2), field));
    }
}
