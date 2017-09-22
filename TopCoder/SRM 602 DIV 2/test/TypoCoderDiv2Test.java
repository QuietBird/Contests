import org.junit.Test;
import static org.junit.Assert.*;

public class TypoCoderDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] rating = new int[] {1000,1200,1199};
		assertEquals(2, new TypoCoderDiv2().count(rating));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] rating = new int[] {1500,2200,900,3000};
		assertEquals(3, new TypoCoderDiv2().count(rating));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] rating = new int[] {600,700,800,900,1000,1100,1199};
		assertEquals(0, new TypoCoderDiv2().count(rating));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] rating = new int[] {0,4000,0,4000,4000,0,0};
		assertEquals(4, new TypoCoderDiv2().count(rating));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] rating = new int[] {575,1090,3271,2496,859,2708,3774,2796,1616,2552,3783,2435,1111,526,562};
		assertEquals(4, new TypoCoderDiv2().count(rating));
	}
}
