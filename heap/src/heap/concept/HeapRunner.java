package heap.concept;

public class HeapRunner {

    public static void main(String[] args) {

        System.out.println("Min heap.concept.Heap");
        Heap minHeap = new MinHeap(3);
        testHeap(minHeap);

        System.out.println("Max heap.concept.Heap");
        Heap maxHeap = new MaxHeap(3);
        testHeap(maxHeap);
    }

    private static void testHeap(Heap minHeap) {
        minHeap.add(200);
        minHeap.add(300);
        minHeap.add(100);
        System.out.println("Top element is " + minHeap.peek());
        System.out.println("Polled element " + minHeap.poll());
        System.out.println("Top element is " + minHeap.peek());
        minHeap.add(50);
        System.out.println("Top element is " + minHeap.peek());
        System.out.println(minHeap.size());
        int[] elements = minHeap.getElements();
        for(int i=1; i<=minHeap.size(); i++) {
            System.out.print(elements[i] + " ");
        }
    }
}
