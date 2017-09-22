import org.junit.Test;
import static org.junit.Assert.*;

public class PilingRectsDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] X = new int[] {1,2,3,1};
		int[] Y = new int[] {3,2,4,4};
		int limit = 3;
		assertEquals(3, new PilingRectsDiv2().getmax(X, Y, limit));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] X = new int[] {4,7};
		int[] Y = new int[] {7,4};
		int limit = 25;
		assertEquals(2, new PilingRectsDiv2().getmax(X, Y, limit));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] X = new int[] {10};
		int[] Y = new int[] {10};
		int limit = 9999;
		assertEquals(-1, new PilingRectsDiv2().getmax(X, Y, limit));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] X = new int[] {10};
		int[] Y = new int[] {3};
		int limit = 30;
		assertEquals(1, new PilingRectsDiv2().getmax(X, Y, limit));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] X = new int[] {3,6,5,8,2,9,14};
		int[] Y = new int[] {14,6,13,8,15,6,3};
		int limit = 27;
		assertEquals(4, new PilingRectsDiv2().getmax(X, Y, limit));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] X = new int[] {121,168,86,106,36,10,125,97,53,26,148,129,41,18,173,55,13,73,91,174,177,190,28,164,122,92,5,26,58,188,14,67,48,196,41,94,24,89,54,117,12,6,155,103,200,128,184,29,92,149};
		int[] Y = new int[] {199,182,43,191,2,145,15,53,38,37,61,45,157,129,119,123,177,178,183,188,132,108,112,137,92,59,75,196,102,152,114,121,181,93,32,3,24,116,4,163,96,159,196,43,59,150,79,113,20,146};
		int limit = 5345;
		assertEquals(24, new PilingRectsDiv2().getmax(X, Y, limit));
	}
}
