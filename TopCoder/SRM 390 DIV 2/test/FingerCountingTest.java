import org.junit.Test;
import static org.junit.Assert.*;

public class FingerCountingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int weakFinger = 2;
		int maxCount = 3;
		assertEquals(15, new FingerCounting().maxNumber(weakFinger, maxCount));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int weakFinger = 1;
		int maxCount = 0;
		assertEquals(0, new FingerCounting().maxNumber(weakFinger, maxCount));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int weakFinger = 5;
		int maxCount = 0;
		assertEquals(4, new FingerCounting().maxNumber(weakFinger, maxCount));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int weakFinger = 2;
		int maxCount = 48;
		assertEquals(193, new FingerCounting().maxNumber(weakFinger, maxCount));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int weakFinger = 5;
		int maxCount = 973;
		assertEquals(7788, new FingerCounting().maxNumber(weakFinger, maxCount));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int weakFinger = 3;
		int maxCount = 99999;
		assertEquals(399998, new FingerCounting().maxNumber(weakFinger, maxCount));
	}
}
