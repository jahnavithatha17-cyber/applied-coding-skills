import java.util.*;

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // Add current request
        queue.offer(t);

        // Remove requests outside [t - 3000, t]
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
