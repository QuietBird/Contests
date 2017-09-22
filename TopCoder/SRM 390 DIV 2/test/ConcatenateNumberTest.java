import org.junit.Test;
import static org.junit.Assert.*;

public class ConcatenateNumberTest {
	
	@Test(timeout=2000)
	public void test0() {
		int number = 2;
		int k = 9;
		assertEquals(9, new ConcatenateNumber().getSmallest(number, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int number = 121;
		int k = 11;
		assertEquals(1, new ConcatenateNumber().getSmallest(number, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int number = 1;
		int k = 2;
		assertEquals(-1, new ConcatenateNumber().getSmallest(number, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int number = 35;
		int k = 98765;
		assertEquals(9876, new ConcatenateNumber().getSmallest(number, k));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int number = 1000000000;
		int k = 3;
		assertEquals(3, new ConcatenateNumber().getSmallest(number, k));
	}
}
