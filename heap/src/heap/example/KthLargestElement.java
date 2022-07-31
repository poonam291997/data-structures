package heap.example;

import java.util.PriorityQueue;

/**
 * Given an integer of array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Solve it in O(n) time complexity.
 */
public class KthLargestElement {

    public static void main(String[] args) {

    }

    private static int getKthLargestElement(int[] nums, int k) {
        // 1. If we sort the array - O(nlogn)
        // 2.If we add elements to minHeap, O(klogk) + O(n-k)logk  = O(nlogk)
        if (k == 0) {
            return -1;
        }
        if(nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b) -> a.intValue() - b.intValue());
        for(int i=0; i<nums.length; i++) {
            minHeap.add(nums[i]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
