import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CountOccurrences {


    private static Map<Integer, Integer> countOccurrences(final ArrayList<Integer> array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : array)
            map.merge(i, 1, Integer::sum);
        return map;
    }

    private static int readPositiveInteger(final BufferedReader reader) {
        while(true) {
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n <= 0)
                    System.err.println("Type a positive integer");
                else
                    return n;
            } catch (IOException e) {
                System.err.println("An error occurred while reading the line, try again");
            } catch (NumberFormatException e) {
                System.err.println("Please, type an integer");
            }
        }
    }


    private static ArrayList<Integer> getRandomTuple(final int n) {
        Random random = new Random();
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            result.add(random.nextInt(15));
        return result;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = readPositiveInteger(bufferedReader);
        ArrayList<Integer> list = getRandomTuple(n);
        for(Integer i : list)
            System.out.print(i + " ");
        Map<Integer, Integer> map = countOccurrences(list);
        for(Map.Entry<Integer, Integer> e : map.entrySet())
            System.out.println(e.getKey() + " - " + e.getValue());
    }


}
