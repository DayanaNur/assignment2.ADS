public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        Integer[] MyArrayList = new Integer[0];
        myList.add(3);
        myList.addFirst(0);
        myList.addLast(1);

        for (Integer item : MyArrayList) {
            System.out.print(item + " ");
        }
        System.out.println("First element: " + myList.getFirst());
        System.out.println("Last element: " + myList.getLast());
        System.out.println("Element at index 1: " + myList.get(1));
        myList.set(1, 5);
        System.out.println("Element at index 1 after setting: " + myList.get(1));
        myList.remove(1);
        myList.removeFirst();
        myList.removeLast();
        System.out.println("Size after removals: " + myList.size());
        myList.add(5);
        myList.add(3);
        myList.add(1);
        System.out.println();
        myList.sort();
        for (Integer item : MyArrayList) {
            System.out.print(item + " ");
        }
        System.out.println();
        myList.add(3);
        System.out.println("Index of 3: " + myList.indexOf(3));
        System.out.println("Last index of 3: " + myList.lastIndexOf(3));
        Object[] array = myList.toArray();
        System.out.print("Array contents: ");
        for (Object item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
        myList.clear();
        System.out.println("Size after clearing: " + myList.size()); // Output: 0
    }
}
