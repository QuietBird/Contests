import org.junit.Test;
import static org.junit.Assert.*;

public class VariableSpeedLimitTest {
	
	@Test(timeout=2000)
	public void test0() {
		int journeyLength = 100;
		int[] speedLimit = new int[] {50};
		assertEquals(2.0, new VariableSpeedLimit().journeyTime(journeyLength, speedLimit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int journeyLength = 100;
		int[] speedLimit = new int[] {50,25};
		assertEquals(2.5, new VariableSpeedLimit().journeyTime(journeyLength, speedLimit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int journeyLength = 1000;
		int[] speedLimit = new int[] {50,40,30,40,50};
		assertEquals(24.0, new VariableSpeedLimit().journeyTime(journeyLength, speedLimit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int journeyLength = 2058;
		int[] speedLimit = new int[] {80,43,57,23,28,45,60,75,73,80};
		assertEquals(37.4, new VariableSpeedLimit().journeyTime(journeyLength, speedLimit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int journeyLength = 17216;
		int[] speedLimit = new int[] {26,30,62,55,51,56,58,4,60,23,31};
		assertEquals(415.03333333333336, new VariableSpeedLimit().journeyTime(journeyLength, speedLimit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test5() {
		int journeyLength = 9839;
		int[] speedLimit = new int[] {45,90,13,4,81,50,81,10,64,86,69};
		assertEquals(182.8395061728395, new VariableSpeedLimit().journeyTime(journeyLength, speedLimit), 1e-9);
	}
}
