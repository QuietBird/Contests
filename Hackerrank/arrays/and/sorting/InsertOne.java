package arrays.and.sorting;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class InsertOne {
    public static void main(String[] args) {
       insertIntoSorted(new int[]{2, 4, 6, 8, 0});
        insertionSort(new int[]{9, 8, 6, 7, 3, 5, 4, 1, 2});
    }

    public static void insertionSort(int[] ar) {
        for (int n = 1; n < ar.length; n++) {
            int temp = ar[n];
            for(int i = n-1; i >= 0; i--) {
                if(ar[i] > temp) {
                    ar[i+1] = ar[i];
                    ar[i] = temp;
                } else {
                    break;
                }
            }
            printArr(ar);
        }

    }

    public static void insertIntoSorted(int[] ar) {
        int temp = ar[ar.length - 1];
        for(int i = ar.length - 2; i >= 0; i--) {
            if(ar[i] <= temp) {
                ar[i+1] = temp;
                printArr(ar);
                break;
            }
            ar[i+1] = ar[i];
            printArr(ar);
        }
    }

    private static void printArr(int[] ar) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < ar.length; i++) {
            str.append(ar[i]).append(' ');
        }
        System.out.println(str.toString());
    }
}
