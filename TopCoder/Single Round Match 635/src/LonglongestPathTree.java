import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LonglongestPathTree {
	
	public long getLength(int[] A, int[] B, int[] L) {
        int N = A.length;
        int[][] treeArray = new int[2*N][2*N];
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int i1 = A[i];
            int j1 = B[i];
            int length = L[i];
            minLength = Math.min(minLength, length);
            treeArray[i1][j1] = length;
            treeArray[j1][i1] = length;
        }
        boolean foundNode = false;

        for(int i = 0; i < N; i++) {
            int counter = 0;
            for (int j = 0; j < N; j++)
                if (treeArray[i][j] > 0) {
                    counter++;
                    if(counter >= 3)
                        foundNode = true;
                }
        }
        long summ = 0L;
		for(int i : L)
            summ += i;
        if(foundNode)
            summ -= minLength;
        return summ;
	}
}
