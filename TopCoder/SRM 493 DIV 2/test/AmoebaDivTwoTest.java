import org.junit.Test;
import static org.junit.Assert.*;

public class AmoebaDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] table = new String[] {"MA"};
		int K = 2;
		assertEquals(0, new AmoebaDivTwo().count(table, K));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] table = new String[] {"AAA",
 "AMA",
 "AAA"};
		int K = 3;
		assertEquals(4, new AmoebaDivTwo().count(table, K));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] table = new String[] {"AA",
 "AA",
 "AA"};
		int K = 2;
		assertEquals(7, new AmoebaDivTwo().count(table, K));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] table = new String[] {"MMM",
 "MMM",
 "MMM"};
		int K = 1;
		assertEquals(0, new AmoebaDivTwo().count(table, K));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] table = new String[] {"AAM",
 "MAM",
 "AAA"};
		int K = 1;
		assertEquals(6, new AmoebaDivTwo().count(table, K));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] table = new String[] {"AAA",
 "AAM",
 "AAA"};
		int K = 2;
		assertEquals(9, new AmoebaDivTwo().count(table, K));
	}
}
