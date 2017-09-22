package contests.women2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class Task5 {
    private static int numOfClients;
    private static int numOfHouses;
    private static ArrayList<ArrayList<Integer>> adj;
    private static boolean used[];
    private static int mtSize = 0;
    private static int mt[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numOfClients = scanner.nextInt();
        numOfHouses = scanner.nextInt();
        
        ArrayList<Client> clients = new ArrayList<>();        
        for (int i = 0; i < numOfClients; i++) {
            clients.add(new Client(scanner.nextInt(), scanner.nextInt()));
            
        }
        ArrayList<House> houses = new ArrayList<>();
        for (int i = 0; i < numOfHouses; i++) {
            houses.add(new House(scanner.nextInt(), scanner.nextInt()));
        }
        adj = new ArrayList<>();
        for (int i = 0; i < numOfClients; ++i) {
            adj.add(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < numOfClients; i++) {
            Client client = clients.get(i);
            for (int j = 0; j < numOfHouses; j++) {
                House house = houses.get(j);
                
                if(house.area > client.area && house.price <= client.price) {
                    adj.get(i).add(j);
                }
            }
        }
        Stream
        Consumer

        used = new boolean[numOfClients];
        mt = new int[numOfHouses];
        Arrays.fill(mt, -1);

        for (int v = 0; v < numOfClients; ++v) {
            Arrays.fill(used, false);
            if (kuhn(v)) {
                mtSize++;
            }
        }
        System.out.println(mtSize);
        scanner.close();
    }

    private static boolean kuhn(int v) {
        if (used[v]) {
            return false;
        }
        used[v] = true;  
        for (int i = 0; i < adj.get(v).size(); ++i) {
            int w = adj.get(v).get(i);
            if (mt[w] == -1 || kuhn(mt[w])) {
                mt[w] = v;
                return true;
            }
        }
        return false;
    }
    

    private static class House {
        private int price;
        private int area;

        public House(int area, int price){
            this.price = price;
            this.area = area;
        }
    }

    private static class Client {
        private int price;
        private int area;

        public Client(int area, int price){
            this.price = price;
            this.area = area;
        }
    }
}
