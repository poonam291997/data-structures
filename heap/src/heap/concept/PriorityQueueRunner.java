package heap.concept;

import java.util.*;

/**
 * Example of some commonly used methods of PriorityQueue(pq) class in Java
 * constructor -> default, takes initial size, takes initial size and comparator
 * add() -> adds a new element to pq and maintains priority order
 * peek() -> returns topmost element in pq
 * poll() -> Removes topmost element in pq and returns the element
 * remove() -> Removes a particular element from pq, returns true if element exists and is succesfully removed, else false
 * @author Poonam Bansal
 */
public class PriorityQueueRunner {

    public static void main(String[] args) {
        // priority queue with default comparator - sorts in ascending/natural order
        int size = 100;
        System.out.println("PriorityQueue with default comparator");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(size);
        priorityQueue(priorityQueue);

        System.out.println("PriorityQueue with custom comparator");
        priorityQueue = new PriorityQueue<>(size, (a,b) -> b-a);
        priorityQueue(priorityQueue);

        System.out.println("PriorityQueue with less size and more elements");
        priorityQueue = new PriorityQueue<>(2, (a,b) -> b-a);
        priorityQueue(priorityQueue);
    }

    private static void priorityQueue(PriorityQueue<Integer> priorityQueue) {
        priorityQueue.add(200);
        priorityQueue.add(300);
        priorityQueue.add(100);
        System.out.println("Top element is " + priorityQueue.peek());
        System.out.println("Polled element " + priorityQueue.poll());
        System.out.println("Top element is " + priorityQueue.peek());
        System.out.println("Size is " + priorityQueue.size());
        System.out.println("Removing element 100 " + priorityQueue.remove(100));
        System.out.println("Removing element 300 " + priorityQueue.remove(300));
        System.out.println("Top element is " + priorityQueue.peek());
    }
}
