package warmup;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class MaxXor {
    static int maxXor(int l, int r) {
        int max = r ^ l;
        for (int i = l; i <= r; i++) {
           max = Math.max(max, r ^ i);
        }
        for (int i = r; i >= l; i--) {
            max = Math.max(max, l ^ i);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}
