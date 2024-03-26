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
public class LinkedFrontBackCappedList<T> implements FrontBackCappedList<T> {

	private Node head, tail;
   
   // YOUR CLASS CODE GOES HERE!

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
