import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by GPF on 2017/4/25.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    public RandomizedQueue()                 // construct an empty randomized queue
    {
        a = (Item[]) new Object[2];
        n = 0;

    }
    public boolean isEmpty()                 // is the queue empty?
    {
        return n == 0;
    }
    public int size()                        // return the number of items on the queue
    {
        return n;
    }

    private void resize(int capacity)
    {
        assert capacity >= n;

        Item[] temp = (Item[]) new Object[capacity];
        int j = 0;
        for(int i = 0; i < n; i++) {
            temp[j++] = a[i];
        }
        a = temp;
    }
    public void enqueue(Item item)           // add the item
    {
        if(item == null)
            throw new NullPointerException(" ");
        if(n == a.length) resize(2 * a.length);
        a[n++] = item;
    }
    private void swap(int i, int j) {
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public Item dequeue()                    // remove and return a random item
    {
        if(isEmpty()) throw new NoSuchElementException(" ");
        int index = StdRandom.uniform(n);
        swap(n - 1, index);
        Item item = a[n - 1];
        a[n - 1] = null;
        n--;
        if(n > 0 && n <= a.length / 4) resize(a.length / 2);
        return item;
    }
    public Item sample()                     // return (but do not remove) a random item
    {
        if(isEmpty()) throw new NoSuchElementException(" ");
        int index = StdRandom.uniform(n);
        return a[index];
    }
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item>{
        private int i;

        public RandomizedQueueIterator() {
            i = 0;
        }
        public boolean hasNext() {
            return i != n;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
//    public int getN() {return n;}
//    public int getC() {return current;}

    public static void main(String[] args)   // unit testing (optional)
    {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
//        for(int i = 0; i < 1000; i++)
//            randomizedQueue.enqueue(i + "");
//
//        for(int i = 0; i < 1100; i++)
//            System.out.println(i+ ":" + randomizedQueue.dequeue() + " " + randomizedQueue.getC() + " " + randomizedQueue.getN());
//
//        for(int i = 0; i < 100; i++)
//            randomizedQueue.enqueue(i + "");
//
//        for(int i = 0; i < 550; i++)
//            System.out.println(i+ ":" + randomizedQueue.dequeue() + " " + randomizedQueue.getC() + " " + randomizedQueue.getN());
//
//        System.out.println(randomizedQueue.getN() + " " + randomizedQueue.getC());

    }
}
