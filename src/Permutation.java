import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by GPF on 2017/4/25.
 */
public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while(!StdIn.isEmpty()) {
            String temp = StdIn.readString();
            randomizedQueue.enqueue(temp);
        }
        String[] temp = new String[k];
        for(int i = 0; i < k; i++)
            StdOut.println(randomizedQueue.sample());
    }
}
