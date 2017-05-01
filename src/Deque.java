import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by GPF on 2017/4/24.
 */
public class Deque<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;

    private class Node{
        private Item item;
        private Node next;
        private Node previous;
    }
    public Deque()                           // construct an empty deque
    {
        this.first = null;
        this.last = null;
        n = 0;
    }
    public boolean isEmpty()                 // is the deque empty?
    {
        return first == null;
    }
    public int size()                        // return the number of items on the deque
    {
        return n;
    }
    public void addFirst(Item item)          // add the item to the front
    {
        if(item == null) throw new NullPointerException(" ");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if(oldfirst != null)
            oldfirst.previous = first;
        n++;
        if(n == 1) last = first;
    }
    public void addLast(Item item)           // add the item to the end
    {
        if(item == null) throw new NullPointerException(" ");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.previous = oldlast;
        if(oldlast != null)
            oldlast.next = last;
        n++;
        if(n == 1) first = last;
    }
    public Item removeFirst()                // remove and return the item from the front
    {
        if(isEmpty()) throw new NoSuchElementException(" ");
        Item item = first.item;
        first = first.next;
        if(first != null)
            first.previous = null;
        n--;
        if(n == 0)
            last = null;
        return item;
    }
    public Item removeLast()                 // remove and return the item from the end
    {
        if(isEmpty()) throw new NoSuchElementException(" ");
        Item item = last.item;
        last = last.previous;
        if(last != null)
            last.next = null;
        n--;
        if(n == 0)
            first = null;
        return item;
    }
    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            if(!hasNext())
                throw new NoSuchElementException(" ");
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args)   // unit testing (optional)
    {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.removeFirst();
        deque.addLast(2);
        deque.removeLast();
    }
}
