/**
 * MyLinkedList class implements a doubly linked list-based implementation of the MyList interface.
 * @param <E> the type of elements in this list
 * MyLinkedList constructs an empty linked list.Then methods of LinkedList
 *
 */
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, Cloneable {

    private class MyNode {
        E data;
        E element;
        MyNode next;
        MyNode prev;

        public MyNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        MyNode current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean add(E element) {
        addLast(element);
        return true;
    }

    public void add(int index, E element) {
        checkIndex(index);
        if (index == size) {
            addLast(element);
            return;
        }
        MyNode newNode = new MyNode(element);
        if (index == 0) {
            addFirst(element);
            return;
        }
        MyNode current = getNode(index);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);
        MyNode current = getNode(index);
        E removedElement = current.element;
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return removedElement;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public E get(int index) {
        checkIndex(index);
        MyNode node = getNode(index);
        return node.element;
    }

    public E set(int index, E element) {
        checkIndex(index);
        MyNode node = getNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    public boolean addAll(MyList<? extends E> list) {
        return addAll(size, list);
    }

    public boolean addAll(int index, MyList<? extends E> list) {
        checkIndex(index);
        if (list.isEmpty()) {
            return false;
        }

        return true;
    }

    public void addFirst(E element) {
        MyNode newNode = new MyNode(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(E element) {
        MyNode newNode = new MyNode(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList<E> clone() {
        try {
            MyLinkedList<E> clonedList = (MyLinkedList<E>) super.clone();
            clonedList.head = null;
            clonedList.tail = null;
            clonedList.size = 0;
            for (MyNode current = head; current != null; current = current.next) {
                clonedList.addLast(current.element);
            }
            return clonedList;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    private MyNode getNode(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int indexOf(E element) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.element == element) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean exists(E element) {
        return indexOf(element) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.element;
            current = current.next;
        }
        return array;
    }


    public int lastIndexOf(E element) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element==element) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;

    }
}
