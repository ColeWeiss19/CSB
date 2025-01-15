import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Enqueue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Dequeue
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.poll());
        }
    }
}
