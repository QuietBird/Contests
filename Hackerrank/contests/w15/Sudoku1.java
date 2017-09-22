package contests.w15;

import java.util.BitSet;
import java.util.Scanner;

public class Sudoku1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i <= tests; i++) {
            buffer.append("Case #" + i + ":\n");
            int[][] matrix = new int[9][9];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            if(isSudokuValid(matrix)) {
                buffer.append("Serendipity\n");
                continue;
            }
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int l = j; l < 9; l++) {
                        for (int m = 0; m < 9; m++) {
                            if(l==j && m <= k)
                                continue;
                            int temp = matrix[j][k];
                            matrix[j][k] = matrix[l][m];
                            matrix[l][m] = temp;
                            if(isSudokuValid(matrix))
                                buffer.append(String.format("(%d,%d) <-> (%d,%d)\n", j+1, k+1, l+1, m+1));
                            temp = matrix[j][k];
                            matrix[j][k] = matrix[l][m];
                            matrix[l][m] = temp;
                        }
                    }
                    
                }
            }
        }
        System.out.println(buffer.toString());
        scanner.close();
    }

    private static BitSet[] col = new BitSet[10];
    private static BitSet[] row = new BitSet[10];
    private static BitSet[] grid = new BitSet[10];
    
    static {
        for (int i = 0; i < 10; i++) {
            col[i] = new BitSet();
            row[i] = new BitSet();
            grid[i] = new BitSet();
        }
        
    }
    
    private static boolean isSudokuValid(int[][] matrix) {
        for (int i = 0; i < 10; i++) {
            col[i].clear();
            row[i].clear();
            grid[i].clear();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int gridRow = (i / 3) * 3 + j / 3 + 1;
                int digit = matrix[i][j];
                if(col[i].get(digit) || row[digit].get(j) || grid[gridRow].get(digit))
                    return false;
                col[i].set(digit);
                row[digit].set(j);
                grid[gridRow].set(digit);
            }
        }
        return true;
    }
}
