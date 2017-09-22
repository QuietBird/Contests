package warmup;

import java.io.*;
import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class DfsIterator {

    /*
     2
    / \
   0   3
   \
   1
     */
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1));
        graph.add(Collections.<Integer>emptyList());
        graph.add(Arrays.asList(0, 3));
        graph.add(Collections.<Integer>emptyList());

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("avbfg")))) {
            reader.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
