package heap.example;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestInStream {

    PriorityQueue<Integer> minHeap;
    int k;

    public static void main(String[] args) {

    }

    public KthLargestInStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size()>k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
