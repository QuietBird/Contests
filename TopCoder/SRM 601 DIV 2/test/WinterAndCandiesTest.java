import org.junit.Test;
import static org.junit.Assert.*;

public class WinterAndCandiesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] type = new int[] {1, 3, 2};
		assertEquals(3, new WinterAndCandies().getNumber(type));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] type = new int[] {1, 1, 2};
		assertEquals(4, new WinterAndCandies().getNumber(type));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] type = new int[] {1, 3, 2, 5, 7, 4, 5, 4};
		assertEquals(9, new WinterAndCandies().getNumber(type));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] type = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		assertEquals(62, new WinterAndCandies().getNumber(type));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] type = new int[] {2};
		assertEquals(0, new WinterAndCandies().getNumber(type));
	}
}
