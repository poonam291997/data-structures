package heap.concept;

/**
 * Heap interface which can be implemented by MaxHeap and MinHeap
 * @author Poonam Bansal
 */
public interface Heap {

    void add(int num);
    int poll();
    int peek();
    int parent(int i);

    int left(int i);

    int right(int i);

    int size();

    int[] getElements();

    boolean isEmpty();


}
