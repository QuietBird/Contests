package contests.summer.code2015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine().trim());
        Object o;


        Object enclosingInstance = Solution.class.newInstance();
        Constructor<?> ctor = Private.class.getDeclaredConstructor(Solution.class);

        o = ctor.newInstance(enclosingInstance);

        Method m = Private.class.getDeclaredMethod("powerof2", Integer.TYPE);
        m.setAccessible(true);
        String result = (String) m.invoke(o, num);
        System.out.println(result);
        



        System.out.println("An instance of class: "+o.getClass().getSimpleName()+" has been created");
    }//end of main
    class Private
    {
        private String powerof2(int num)
        {
            return ((num&num-1)==0)?"power of 2":"not a power of 2";
        }
    }//end of Privtate
}
