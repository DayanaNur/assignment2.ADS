/**
 * MyStack class implements a stack using an underlying MyArrayList.
 * @param <T> the type of elements in this stack
 * MyStack constructs an empty stack, then is the methods
 */
public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<T>() {

            public void push(T item) {
                list.add(item);
            }

            public T pop() {
                if (isEmpty()) {
                    throw new IllegalStateException("Stack is empty");
                }
                return list.remove(list.size() - 1);
            }

            public T peek() {
                if (isEmpty()) {
                    throw new IllegalStateException("Stack is empty");
                }
                return list.get(list.size() - 1);
            }

            public boolean isEmpty() {
                return list.isEmpty();
            }

            public int size() {
                return list.size();
            }
        };
    }
}
