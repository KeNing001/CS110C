/* @course: CS 111C Data Structures and Algorithms: Java 
 * @Section: 933 
 * CRN: 35087
 * @instructor: Jessica Masters
 * @authors(A to Z): Dennis Sun (ysun52@mail.ccsf.edu) ; 
 *                   Junru Zhou (jzhou223@mail.ccsf.edu);
 * 					 Keke Ning (kning2@mail.ccsf.edu);
 * @members: 3
 * @project B
 * @date: 03/26/2024
 * @file: LinkedFrontBackCappedList.java
 * @purpose: Implements the interface, the class uses linked nodes to implement the list.
 * @version 0.1
*/
public class LinkedFrontBackCappedList<T> implements FrontBackCappedList<T>, Comparable<LinkedFrontBackCappedList<T>> {

	private Node head, tail;
	private int size, capacity;
	private static final int DEFAULT_CAPACITY = 100;

	public LinkedFrontBackCappedList() {
		this(DEFAULT_CAPACITY);
	}

	public LinkedFrontBackCappedList(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	@Override
	public boolean addFront(T newEntry) {
		if (isFull()) {
			return false;
		}
		Node newNode = new Node(newEntry, head);
		head = newNode;
		if (isEmpty()) {
			tail = head;
		}
		size++;
		return true;
	}

	@Override
	public boolean addBack(T newEntry) {
		if (isFull()) {
			return false;
		}
		if (isEmpty()) {
			return addFront(newEntry);
		}
		Node newNode = new Node(newEntry);
		tail.next = newNode;
		tail = newNode;
		size++;
		return true;
	}

	@Override
	public T removeFront() {
		if (isEmpty()) {
			return null;
		}
		Node removeNode = head;
		head = head.next;
		size--;
		if (0 == size) {
			tail = null;
		}
		return removeNode.data;
	}

	@Override
	public T removeBack() {
		if (isEmpty()) {
			return null;
		}
		Node removeNode = tail;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			tail.next = null;
		}
		size--;
		return removeNode.data;
	}

	@Override
	public void clear() {
		while (null != head) {
			Node tmpNode = head;
			head = head.next;
			tmpNode.next = null;
		}
		tail = null;
		size = 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		if (givenPosition > size - 1 || givenPosition < 0) {
			return null;
		}
		if (givenPosition == size - 1) {
			return tail.data;
		}
		Node current = head;
		for (int i = 0; i < givenPosition; i++) {
			current = current.next;
		}
		return current.data;
	}

	@Override
	public int indexOf(T anEntry) {
		int index = 0;
		Node current = head;
		while (null != current) {
			if (current.data.equals(anEntry)) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T anEntry) {
		int index = 0;
		int lastIndex = -1;
		Node current = head;
		while (null != current) {
			if (current.data.equals(anEntry)) {
				lastIndex = index;
			}
			index++;
			current = current.next;
		}
		return lastIndex;
	}

	@Override
	public boolean contains(T anEntry) {
		return indexOf(anEntry) >= 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return 0 == this.size;
	}

	@Override
	public boolean isFull() {
		return this.size == this.capacity;
	}

	@Override
	public String toString() {
		// [7, 9, 5, 5, 3, 2, 1, 9, 8, 6]\tsize=10\tcapacity=10\thead=7 tail=6
		String s = "[";
		Node current = head;
		while (null != current) {
			s += current.data + ", ";
			current = current.next;
		}
		if (!isEmpty()) {
			s = s.substring(0, s.length() - 2);
		}
		s += "]";
		String headTailString = "";
		if (null != head) {
			headTailString = "\thead=" + this.head.data + " tail=" + this.tail.data;
		}

		return s + "\tsize=" + this.size + "\tcapacity=" + this.capacity + headTailString;
	}

	@Override
	public int compareTo(LinkedFrontBackCappedList<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public class Node {
		public T data;
		public Node next;

		private Node(T dataValue) {
			data = dataValue;
			next = null;
		}

		private Node(T dataValue, Node nextNode) {
			data = dataValue;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
}
