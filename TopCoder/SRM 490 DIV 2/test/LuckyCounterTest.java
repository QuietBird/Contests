import org.junit.Test;
import static org.junit.Assert.*;

public class LuckyCounterTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] moments = new String[] {"12:21", "11:10"};
		assertEquals(1, new LuckyCounter().countLuckyMoments(moments));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] moments = new String[] {"00:00", "00:59", "23:00"};
		assertEquals(1, new LuckyCounter().countLuckyMoments(moments));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] moments = new String[] {"12:34"};
		assertEquals(0, new LuckyCounter().countLuckyMoments(moments));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] moments = new String[] {"12:11", "22:22", "00:01", "03:30", "15:15", "16:00"};
		assertEquals(3, new LuckyCounter().countLuckyMoments(moments));
	}
}
