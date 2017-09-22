import org.junit.Test;
import static org.junit.Assert.*;

public class DivideByZeroTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] numbers = new int[] {9, 2};
		assertEquals(3, new DivideByZero().CountNumbers(numbers));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] numbers = new int[] {8, 2};
		assertEquals(3, new DivideByZero().CountNumbers(numbers));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] numbers = new int[] {50};
		assertEquals(1, new DivideByZero().CountNumbers(numbers));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] numbers = new int[] {1, 5, 8, 30, 15, 4};
		assertEquals(11, new DivideByZero().CountNumbers(numbers));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] numbers = new int[] {1, 2, 4, 8, 16, 32, 64};
		assertEquals(7, new DivideByZero().CountNumbers(numbers));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] numbers = new int[] {6, 2, 18};
		assertEquals(7, new DivideByZero().CountNumbers(numbers));
	}
}
