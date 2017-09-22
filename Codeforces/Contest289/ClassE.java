package Contest289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class ClassE {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        double result = 0;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int vovelsSumm = 0;
            int[] vovels = new int[500000];
            int r;
            int i = 0;
            while ((r = reader.read()) != -1) {
                vovels[i] = vovelsSumm;
                char c = (char) r;
                if(c < 'A' || c > 'Z')
                    break;
                if (c == 'I' || c == 'E' || c == 'A' || c == 'O' || c == 'U' || c == 'Y') {
                    vovelsSumm++;
                    result += 1.0;
                }
                for (int j = 0; j < i; j++) {
                    double delta = (vovelsSumm - vovels[j]) / (double) (i - j + 1);
                    result += delta;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // wow 1 + 0.5 + 0.5 + 1/3 = 2.33
        // oow 2 + 1 + 1/2 + 2/3 = 4.16666 1 2 2 (2-1)/3
        // YISVO
        // 3 + 1 + 1/2 + 1/2 + 2/3 + 1/3 + 1/3 + 2/4 + 2/4 + 3/5 = 7.933333
        // w - 0 wo 1+1/2   wow 0 + 1/2 + 1/3 wowo + 1+ 1/2 + 2/3 + 3/4
        // [1,2,3] IOI 6
        // 3 + i = 1
        //     j = 0
        //QFYSEZEYYAAIASDNKUHUNYGIIOOJQYBABUPLYEXPIOJWJAOAAEOWAEYURUWYIEPXXEEOUBZYIYXEEZIKIJYIIPEEJTSYJYFCCQGVIUCCVUAHHOCAXOCCDFNKOLIBYAYNHAOYOEROIAKYDVPEJRSKCOSSXYTUIRZZHWSEZEEZRUAWIMWYOZAUAOEAOAOROXIEKPITEAZOWUOEASRAAOEUYSOEUZIZYINIJUGYRJYODEQDGLUFWQKYNEUWGCTIPUACJMAHIUYYVYOCEEAIWEAYCQIVXYAEOSIIZUCPGBOEYUFJFFJJAICGDPHAXOXQGZYLLUANEKEEEITQDONWYQLPTIPYNFPJFAYKZTFPFFOOIYODUTOBVUUAYEAPIWEEGKAAEYEUDLYEUOZJIIIHVBENEBASIOLYJYYOVKMJJSHORIEDIAFEOMTYMPTISOADUUGTURYAKHYTEUIVEEEXGUDOTDYTABEBBHAUVIXIHERYJEMKMYQEEZOJYJGYGHEOABC
        
        System.out.println(result);
        System.err.println(System.currentTimeMillis() - now);
    }

    private static class MyScanner {
            private BufferedReader br;
            private StringTokenizer st;

            public MyScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException ignored) {
                    }
                }
                return st.nextToken();
            }

            public int nextInt() {
                return Integer.parseInt(next());
            }

            public long nextLong() {
                return Long.parseLong(next());
            }

            public double nextDouble() {
                return Double.parseDouble(next());
            }

            public String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException ignored) {
                }
                return str;
            }

            public void close() {
                try {
                    br.close();
                } catch (IOException ignored) {
                }
            }
        }
}
