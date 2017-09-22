package acmp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Task109 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufReader = null;
        try {
            fileReader = new FileReader("INPUT.TXT");
            bufReader = new BufferedReader(fileReader);
            String s = bufReader.readLine();
            String[] split = s.split("\\\\");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            BigInteger bigA = BigInteger.valueOf(a);
            BigInteger bigB = BigInteger.valueOf(b);
            bigA.gcd(bigB);
        } catch (IOException ignored) {
            
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ignored) {
                    
                }
            }
            if (bufReader != null) {
                try {
                    bufReader.close();
                } catch (IOException ignored) {
                   
                }
            }
        }
    }
}
