package heap.concept;

/**
 * Properties of MaxHeap
 * 1. It is a complete binary treee
 * 2. Every element is greater than or equal to its children, hence maximum element is always on top.
 * @author Poonam Bansal
 */
public class MaxHeap implements Heap {

    int[] maxHeap;
    int size;
    int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        maxHeap = new int[capacity+1];
        size = 0;
    }
    @Override
    public void add(int num) {

        if(size == capacity) {
            throw new IllegalStateException("No more capacity");
        }
        size++;
        maxHeap[size] = num;
        int i = size;
        int parent = parent(i);
        while(i>1 && maxHeap[parent] < maxHeap[i]) {
            int temp = maxHeap[i];
            maxHeap[i] = maxHeap[parent];
            maxHeap[parent] = temp;
            i = parent;
            parent = parent(i);
        }
    }

    @Override
    public int poll() {
        if(size == 0) {
            throw new IllegalStateException("No elements in heap");
        }
        int top = maxHeap[1];
        maxHeap[1] = maxHeap[size];
        size--;
        heapify(1);
        return top;
    }

    @Override
    public int peek() {
        if(size == 0) {
            throw new IllegalStateException("heap.concept.Heap is empty");
        }
        return maxHeap[1];
    }

    @Override
    public int parent(int i) {
        return i/2;
    }

    @Override
    public int left(int i) {
        return 2*i;
    }

    @Override
    public int right(int i) {
        return (2*i)+1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] getElements() {
        return maxHeap;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if(left <= size && maxHeap[left] > maxHeap[largest]) {
            largest = left;
        }
        if(right<=size && maxHeap[right] > maxHeap[largest]) {
            largest = right;
        }
        if(i!=largest) {
            int temp = maxHeap[i];
            maxHeap[i] = maxHeap[largest];
            maxHeap[largest] = temp;
            heapify(largest);
        }
    }

}
