/**
 * MyQueue class implements a queue using an underlying MyLinkedList.
 * @param <T> the type of elements in this queue
 * Constuct an empty queue , and then is methods
 */
public class MyQueue<T>{
    private MyLinkedList<T> list;
    public MyQueue(){
        list = new MyLinkedList<>();
    }
    public void enqueue(T item){
        list.addLast(item);
    }
    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }
}
