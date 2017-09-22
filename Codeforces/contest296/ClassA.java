package contest296;

import java.util.Scanner;

public class ClassA {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int whiteSumm = 0;
        int blackSumm = 0;        
        for(int i = 0; i < 8; i++) {
            String row  = scan.next();
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if(c == '.')
                    continue;
                int weigthChar = calcWeight(c);
                if(Character.isUpperCase(c)) {
                    whiteSumm += weigthChar;
                } else {
                    blackSumm += weigthChar;
                }
            }
        }
        scan.close();
        String result = whiteSumm > blackSumm ? "White" : whiteSumm == blackSumm ? "Draw" : "Black";
        System.out.println(result);
    }

    private static int calcWeight(char c) {
        c = Character.toLowerCase(c);
        switch(c)  {
            case  'q':
                return 9;
            case 'r':
                return 5;
            case 'b':
            case 'n':
                return 3;
            case 'p':
                return 1;
        }
        return 0;
    }
}
