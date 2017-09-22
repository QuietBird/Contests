import org.junit.Test;
import static org.junit.Assert.*;

public class QuadraticLawTest {
	
	@Test(timeout=2000)
	public void test0() {
		long d = 1L;
		assertEquals(0L, new QuadraticLaw().getTime(d));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long d = 2L;
		assertEquals(1L, new QuadraticLaw().getTime(d));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long d = 5L;
		assertEquals(1L, new QuadraticLaw().getTime(d));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long d = 6L;
		assertEquals(2L, new QuadraticLaw().getTime(d));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long d = 7L;
		assertEquals(2L, new QuadraticLaw().getTime(d));
	}
	
	@Test(timeout=2000)
	public void test5() {
		long d = 1482L;
		assertEquals(38L, new QuadraticLaw().getTime(d));
	}
	
	@Test(timeout=2000)
	public void test6() {
		long d = 1000000000000000000L;
		assertEquals(999999999L, new QuadraticLaw().getTime(d));
	}
	
	@Test(timeout=2000)
	public void test7() {
		long d = 31958809614643170L;
		assertEquals(178770270L, new QuadraticLaw().getTime(d));
	}

    /*@Test(timeout=2000)
    public void test8() {
        long d = 1000000000000000000L;
        assertEquals(178770270L, new QuadraticLaw().getTime(d));
    }*/
}
