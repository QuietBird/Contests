package warmup;

import java.util.Scanner;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class AcmTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int numberOfTopics = scanner.nextInt();
        int[][] abilities = new int[numberOfPeople][numberOfTopics];
        for (int i = 0; i < numberOfPeople; i++) {
            String topics = scanner.next();
            for (int j = 0; j < numberOfTopics; j++) {
                if(topics.charAt(j) == '1')
                    abilities[i][j] = 1;
            }
        }
        int maxTopics = 0;
        int numberOfGroups = 0;
        for (int i = 0; i < numberOfPeople; i++) {
            for (int j = i+1; j < numberOfPeople; j++) {
                int localTopics = 0;
                for (int k = 0; k < numberOfTopics; k++) {
                    if(abilities[i][k] != 0 || abilities[j][k] != 0)
                        localTopics++;
                }
                if(localTopics > maxTopics) {
                    maxTopics = localTopics;
                    numberOfGroups = 1;
                }
                if(localTopics == maxTopics)
                    numberOfGroups++;
            }
        }
        System.out.println(maxTopics);
        System.out.println(numberOfGroups);
        scanner.close();
    }
}
