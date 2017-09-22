import org.junit.Test;
import static org.junit.Assert.*;

public class BlackBoxDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String front = "BB";
		String side = "BB";
		assertEquals(7, new BlackBoxDiv2().count(front, side));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String front = "...";
		String side = ".....";
		assertEquals(1, new BlackBoxDiv2().count(front, side));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String front = "...";
		String side = "BBB";
		assertEquals(0, new BlackBoxDiv2().count(front, side));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String front = "...BB.B....";
		String side = "B.B.B.B.B";
		assertEquals(16081, new BlackBoxDiv2().count(front, side));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String front = "BBBBB.BBBBBBBBB.BBBBBBB.BBBB.B.BB..BB.B.BBBBBBBBBB";
		String side = ".B.BBB..BBBBBB.BBBB.B...BBBB.BB.BBBBBBBBBB.....BBB";
		assertEquals(771030153, new BlackBoxDiv2().count(front, side));
	}
}
