import org.junit.Test;
import static org.junit.Assert.*;

public class StonesGameTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 3;
		int M = 1;
		int K = 1;
		int L = 2;
		assertEquals("Draw", new StonesGame().winner(N, M, K, L));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 5;
		int M = 1;
		int K = 2;
		int L = 2;
		assertEquals("Romeo", new StonesGame().winner(N, M, K, L));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 5;
		int M = 5;
		int K = 2;
		int L = 3;
		assertEquals("Strangelet", new StonesGame().winner(N, M, K, L));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 5;
		int M = 5;
		int K = 2;
		int L = 2;
		assertEquals("Draw", new StonesGame().winner(N, M, K, L));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 1000000;
		int M = 804588;
		int K = 705444;
		int L = 292263;
		assertEquals("Romeo", new StonesGame().winner(N, M, K, L));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int N = 1000000;
		int M = 100000;
		int K = 500000;
		int L = 600000;
		assertEquals("Strangelet", new StonesGame().winner(N, M, K, L));
	}
}
