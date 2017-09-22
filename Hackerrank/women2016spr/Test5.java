package women2016spr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Test5 {
    @Test(timeout=4000)
    public void test1() {
        String str = "abcde";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 2);
        assertEquals(result.toString(), "cde");
    }

    @Test(timeout=4000)
    public void test2() {
        String str = "dcabe";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 2);
        assertEquals(result.toString(), "dce");
    }
    
    @Test(timeout=4000)
    public void test3() {
        String str = "gffggfff";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 3);
        assertEquals(result.toString(), "gggff");
    }
    
    @Test(timeout=4000)
    public void test4() {
        String str = "ababacbabababcabc";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 14);
        assertEquals(result.toString(), "ccc");
    }
    @Test(timeout=4000)
    public void test5() {
        String str = "ababcababababcabc";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 13);
        assertEquals(result.toString(), "ccbc");
    }
    @Test(timeout=4000)
    public void test6() {
        String str = "xxxyesxxxxxxxxxx";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 2);
        assertEquals(result.toString(), "xyesxxxxxxxxxx");
    }
    @Test(timeout=4000)
    public void test7() {
        String str = "efdgabc";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 3);
        assertEquals(result.toString(), "gabc");
    }

    @Test(timeout=4000)
    public void test8() {
        String str = "aabaafaaa";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 3);
        assertEquals(result.toString(), "bafaaa");
    }

    @Test(timeout=4000)
    public void test9() {
        String str = "xxxzyzyzxyxxyyyzxy";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 4);
        assertEquals(result.toString(), "zzyzxyxxyyyzxy");
    }

    @Test(timeout=4000)
    public void test10() {
        String str = "abczyxxyzabc";
        StringBuilder result = SmitriAndStr5.getStringBuilder(str.toCharArray(), 4);
        assertEquals(result.toString(), "zyxyzabc");
    }
}

