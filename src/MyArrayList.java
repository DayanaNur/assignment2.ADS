import java.util.Iterator;

public class MyArrayList<T>  {
    private Object[] elements;
    private int size;
    private static final int default_value = 10;

    public MyArrayList() {
        this.elements = new Object[default_value];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    public void add(T item) {
        addLast(item);
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        elements[index] = item;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }

    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return (T) elements[0];
    }

    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return (T) elements[size - 1];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }
    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        remove(0);
    }
    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        size--;
    }

    public void sort() {
        for (int i = 1; i < size; i++) {
            T key = (T) elements[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable<T>) elements[j]).compareTo(key) > 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    public void clear() {
        elements = new Object[default_value];
        size = 0;
    }
    public int size() {
        return size;
    }
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements to iterate");
                }
                return (T) elements[currentIndex++];
            }
        };
    }
}

