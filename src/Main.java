public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> MyList = new MyArrayList<>() {
            @Override
            public boolean isEmpty() {
                return false;
            }
        };
        MyList.add(10);
        MyList.add(20);
        MyList.add(30);
        MyList.add(1, 15);
        MyList.set(2, 25);
        System.out.println("Element at index 2: " + MyList.get(2));
        MyList.addFirst(5);
        MyList.addLast(35);
        MyList.remove(3);
        MyList.removeFirst();
        MyList.removeLast();
        System.out.println("Size of list: " + MyList.size());
        System.out.println("Does list contain 25?: " + MyList.exists(25));
        System.out.println("Index of element 20: " + MyList.indexOf(20));
        Object[] array = MyList.toArray();
        System.out.print("Size of array list: ");
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
        MyList.clear();
        System.out.println("Size of list after clear: " + MyList.size());
    }
}
