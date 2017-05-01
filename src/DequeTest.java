import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by GPF on 2017/4/25.
 */
public class DequeTest {
    static Deque<Integer> deque;
    @BeforeEach
    void init() {
        deque = new Deque<Integer>();
    }

    @Test
    void test1() {
        deque.addFirst(1);
        assert(deque.size() == 1);
        assert(!deque.isEmpty());
        assert(deque.removeFirst() == 1);
    }

    @Test
    void test2() {
        deque.addLast(1);
        assert(deque.size() == 1);
        assert(!deque.isEmpty());
        assert(deque.removeLast() == 1);
    }

    @Test
    void test3() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        int temp[] = new int[]{3,1,2,4};
        int i = 0;
        for(int a : deque){
            assert(temp[i] == a);
            i++;
        }

    }

    @Test
    void test4() {
        deque.addFirst(1);
        deque.removeFirst();
        deque.addLast(2);
        deque.removeLast();
        assert(deque.isEmpty());
        deque.addLast(3);
        deque.addLast(4);
        deque.removeLast();
        deque.addFirst(1);
        deque.removeFirst();
        deque.removeFirst();
        assert(deque.isEmpty());
    }

    @Test
    void test5(){
        deque.addFirst(5);
        assert(deque.removeLast() == 5);
        assert(deque.isEmpty());
    }

    @Test
    void test6() {
        deque.addLast(2);
        assert(deque.removeFirst() == 2);
        assert(deque.isEmpty());

    }
}
