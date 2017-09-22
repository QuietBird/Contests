import org.junit.Test;
import static org.junit.Assert.*;

public class IdentifyingWoodTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "absdefgh";
		String t = "asdf";
		assertEquals("Yep, it's wood.", new IdentifyingWood().check(s, t));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "oxoxoxox";
		String t = "ooxxoo";
		assertEquals("Nope.", new IdentifyingWood().check(s, t));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "oxoxoxox";
		String t = "xxx";
		assertEquals("Yep, it's wood.", new IdentifyingWood().check(s, t));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "qwerty";
		String t = "qwerty";
		assertEquals("Yep, it's wood.", new IdentifyingWood().check(s, t));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "string";
		String t = "longstring";
		assertEquals("Nope.", new IdentifyingWood().check(s, t));
	}
}
