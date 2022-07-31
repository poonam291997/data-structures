package heap.concept;

/**
 * Properties of MinHeap
 * 1. It is a complete binary treee
 * 2. Every element is less than or equal to its children, hence minimum element is always on top.
 * @author Poonam Bansal
 */
public class MinHeap implements Heap{

    int[] minHeap;
    int size = 0;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        minHeap = new int[capacity + 1];
    }

    @Override
    public void add(int num) {
        if(size == capacity) {
            throw new IllegalStateException("No more capacity");
        }
        size+=1;
        minHeap[size] = num;
        int i = size;
        int parent = parent(i);
        while(minHeap[i] < minHeap[parent] && i>1) {
            int temp = minHeap[i];
            minHeap[i] = minHeap[parent];
            minHeap[parent] = temp;
            i = parent;
            parent = parent(i);
        }
    }

    @Override
    public int poll() {
        if(size == 0) {
            throw new IllegalStateException("No elements in heap");
        }
        int top = minHeap[1];
        int last = minHeap[size];
        size-=1;
        minHeap[1] = last;
        heapify(1);
        return top;
    }

    @Override
    public int peek() {
        if(size == 0) {
            throw new IllegalStateException("No elements in heap");
        }
        return minHeap[1];
    }

    @Override
    public int parent(int i) {
        return i/2;
    }

    @Override
    public int left(int i) {
        return i*2;
    }

    @Override
    public int right(int i) {
        return (i*2) + 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] getElements() {
        return minHeap;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private void heapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest;
        if(left>size) {
            return;
        }
        if(right>size) {
            smallest = left;
        }
        if(minHeap[left] < minHeap[right]) {
            smallest = left;
        } else {
            smallest = right;
        }
        int temp = minHeap[i];
        minHeap[i] = minHeap[smallest];
        minHeap[smallest] = temp;
        heapify(smallest);
    }
}
