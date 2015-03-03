import java.util.*;

public class Queue<E> {

    List<E> queue = new LinkedList<E>();

    public void push(E val) {
    
	queue.add(0, val);
    }

    public E pop() {

	E ret = queue.get(0);
	queue.remove(0);
	return ret;
    }

    public boolean isEmpty() {

	return queue.isEmpty();
    }
}
