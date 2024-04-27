/**
 * MyMinHeap class implements a min-heap data structure using an underlying MyArrayList.
 * @param <T> the type of elements stored in the heap, which must be Comparable
 *  Constructs an empty min-heap.
 *  bubbleUp moves the element at the specified index up the heap to maintain the heap property.
 *  bubbleDown moves the element at the specified index down the heap to maintain the heap property.
 */
public class MyMinHeap <T extends Comparable <T>>{
    private MyArrayList<T> heap;
    public MyMinHeap(){
        heap = new MyArrayList<>() {
            @Override
            public boolean isEmpty() {
                return false;
            }
        };
    }
    public void add(T item){
        heap.add(item);
        bubbleUp(heap.size() - 1);
    }
    private void bubbleUp(int index){
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0){
            swap(index , parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) /2;
        }
    }
    public T removeMin(){
        if (isEmpty()){
            throw new IllegalStateException("Heap is empty");

        }
        T min = heap.get(0);
        heap.set(0 , heap.remove(heap.size()- 1));
        bubbleDown(0);
        return min;
    }
    private void bubbleDown(int index){
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;
        if(leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0){

        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }
        if (smallestIndex != index) {
            swap(index, smallestIndex);
            bubbleDown(smallestIndex);
        }
    }
    private void swap(int i , int j){
        T temp = heap.get(i);
        heap.set(i , heap.get(j));
        heap.set(j , temp);
    }
    public T peekMin(){
        if(isEmpty()){
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    public int size(){
        return heap.size();
    }
}
