in MyArrayList class i used set method , which sets the value of element if the index in acceptable range , then the new value of the element set. If not  IndexOutOfBoundsException is thrown. 
Add method , adds the item to the specific position . First it checks is the index in acceptable range, then it expands the capacity of the list if necessary , and move the items to the right, to make a spac for the new item. AddFirst , AddLast adds the element to the top , addlast adds to the end.
Get method , returns the item located in specifiead index in the list. If the index in acceptable range it will return the item , if not  IndexOutOfBoundsException is thrown. getFirst()method returns the first item in the list. If the list is empty, an IllegalStateException is thrown.getLast() method returns the last item in the list. If the list is empty, an IllegalStateException is thrown.
Remove() method , delete element from the list by the index. removeFirst() delete first element from the list,removeLast() reduces the size of list by one element.
indexOf return the index of first occurrence of the specified object in the list. LastIndexOf returns the index of the last occurrence of the specified object in the list.
exists() checks if the object in the list.
The toArray() method creates a new array and copies all the list items into it, and then returns this array.
the clear() method clears the list by setting it a new empty array and resetting the size of the list.
The size() method returns the current size of the list.
The iterator() method returns an iterator for the list, which allows you to iterate through the list items in a loop.
In Linked list: head and tail are instance variables pointing to the first and last nodes of the list, respectively. If the list is empty, both variables are set to null.
size is an instance variable that keeps track of the number of items in the list.
The MyLinkedList() constructor initializes an empty list.
The removeFirst() method removes the first item from the list and returns its value. If the list is empty, a NoSuchElementException is thrown.
The getFirst() method returns the value of the first item in the list without deleting it. If the list is empty, a NoSuchElementException is thrown.
The size() method returns the current size of the list.
The isEmpty() method checks if the list is empty.
The contains(E element) method checks whether the specified element is contained in the list.
The add(E element) method adds an element to the end of the list.
The add(int index, E element) method adds an element to the specified index in the list.
The remove(int index) method removes an item from the list at the specified index.
The get(int index) method returns an element.
MyStack class represents a stack data structure implemented using composition with MyArrayList.
I used push, pop, peek, isEmpty, and size methods.
push method adds an element to the top of the stack by invoking the add method of the underlying MyArrayList.
pop method removes and returns the element at the top of the stack.
peek method returns the element at the top of the stack without removing it.
isEmpty method checks whether the stack is empty by delegating to the isEmpty method of the underlying MyArrayList.
size method returns the number of elements in the stack.
MyQueue class: enqueue method adds an element to the rear end of the queue, dequeue method removes and returns the element at the front end of the queue , peek method returns the element at the front end of the queue without removing it.
size method returns the number of elements in the queue
MinHeap class: add() method adds an element to the min-heap.
bubbleUp method moves the element up the heap until it satisfies the min-heap property. RemoveMin method removes and returns the minimum element from the min-heap.
bubbleDown method moves the element down the heap until it satisfies the min-heap property. Swap method swaps two elements.peekMin method returns the minimum element in the min-heap without removing it
