package heap.example;

import heap.concept.MinHeap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {

    }

    private static int[] getTopKFrequentElements(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry.getKey());
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i=k-1; i>=0 ; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
