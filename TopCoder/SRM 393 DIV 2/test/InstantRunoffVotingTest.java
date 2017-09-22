import org.junit.Test;
import static org.junit.Assert.*;

public class InstantRunoffVotingTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] voters = new String[] {"01","10","01","01","10"};
		assertEquals(0, new InstantRunoffVoting().winner(voters));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] voters = new String[] {"120","102","210","021","012"};
		assertEquals(1, new InstantRunoffVoting().winner(voters));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] voters = new String[] {"10","01"};
		assertEquals(-1, new InstantRunoffVoting().winner(voters));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] voters = new String[] {"3120","3012","1032"
,"3120","2031","2103"
,"1230","1230"};
		assertEquals(-1, new InstantRunoffVoting().winner(voters));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] voters = new String[] {"24103","30412","32014","21043","30412"
,"32401","14203","04123","30241","02413"
,"13042","01432","01342","32401","24301"
,"12430","41023","02413","42310","12043"};
		assertEquals(1, new InstantRunoffVoting().winner(voters));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] voters = new String[] {"0649853172","2146875039","2671548309"
,"5897216403","4719823056","7945213860"
,"9021538647","9286145307","9176403528"
,"3709486152"};
		assertEquals(9, new InstantRunoffVoting().winner(voters));
	}
}
