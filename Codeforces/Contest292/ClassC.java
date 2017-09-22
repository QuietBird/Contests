package Contest292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClassC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Map<ABCcounter, Set<String>>> mapOfMaps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            int aCounter = 0;
            int bCounter = 0;
            int cCounter = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(c == 'a')
                    aCounter++;
                if(c == 'b')
                    bCounter++;
                if(c == 'c')
                    cCounter++;
            }
            ABCcounter abCcounter = new ABCcounter(aCounter, bCounter, cCounter);
            Map<ABCcounter, Set<String>> stringABCcounterMap = mapOfMaps.get(str.length());
            if(stringABCcounterMap == null) {
                stringABCcounterMap = new HashMap<>();
                mapOfMaps.put(str.length(), stringABCcounterMap);
            }
            Set<String> sameStr = stringABCcounterMap.get(abCcounter); 
            if(sameStr == null) {
                sameStr = new HashSet<>();
                stringABCcounterMap.put(abCcounter, sameStr);
            }
            sameStr.add(str);
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String test = scanner.next();
            Map<ABCcounter, Set<String>> dictionaryMap = mapOfMaps.get(test.length());
            if(dictionaryMap == null) {
                builder.append("NO\n");
                continue;
            }
            int aCounter = 0;
            int bCounter = 0;
            int cCounter = 0;
            for (int j = 0; j < test.length(); j++) {
                char c = test.charAt(j);
                if(c == 'a')
                    aCounter++;
                if(c == 'b')
                    bCounter++;
                if(c == 'c')
                    cCounter++;
            }
            boolean matchFound = false;
            dictionaryMap.get(new ABCcounter(aCounter, bCounter, cCounter));
            /*for (String s : dictionaryMap.keySet()) {
                *//*if(Math.abs(abCcounter.aCounter - aCounter) > 1
                        || Math.abs(abCcounter.bCounter - bCounter) > 1
                        || Math.abs(abCcounter.cCounter - cCounter) > 1 )
                {
                    continue;
                }*//*
                boolean differenceFound = false;
                boolean difference2Found = false;
                for (int j = 0; j < s.length(); j++) {
                    if(s.charAt(j) == test.charAt(j))
                        continue;
                    if(!differenceFound) {
                        differenceFound = true;
                    } else {
                        difference2Found = true;
                        break;
                    }
                }
                if(differenceFound && !difference2Found) {
                    matchFound = true;
                    break;
                }

            }*/
            builder.append(matchFound ? "YES\n" : "NO\n");
        }
        System.out.println(builder.toString());
        scanner.close();
    }

    private static class ABCcounter {
        private final int aCounter;
        private final int bCounter;
        private final int cCounter;

        private ABCcounter(int aCounter, int bCounter, int cCounter) {
            this.aCounter = aCounter;
            this.bCounter = bCounter;
            this.cCounter = cCounter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ABCcounter that = (ABCcounter) o;

            if (aCounter != that.aCounter) return false;
            if (bCounter != that.bCounter) return false;
            if (cCounter != that.cCounter) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = aCounter;
            result = 31 * result + bCounter;
            result = 31 * result + cCounter;
            return result;
        }
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