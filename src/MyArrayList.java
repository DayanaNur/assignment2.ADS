import java.util.Iterator;

public abstract class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;

    public MyArrayList() {
        this.arr = (T[]) new Object[10];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.arr = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            int newCapacity = arr.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(arr, 0, newArray, 0, size);
            arr = newArray;
        }
    }

    public void add(T item) {
        addLast(item);
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        arr[index] = item;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity(size + 1);
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        ensureCapacity(size + 1);
        arr[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return arr[index];
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T removedElement = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        return removedElement;
    }

    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return arr[0];
    }

    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return arr[size - 1];
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
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable<T>) arr[j]).compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(object)) {
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
        System.arraycopy(arr, 0, array, 0, size);
        return array;
    }

    public void clear() {
        arr = (T[]) new Object[5];
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
                return arr[currentIndex++];
            }
        };
    }
}
