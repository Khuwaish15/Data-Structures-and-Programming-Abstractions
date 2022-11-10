package CSE260;
import java.util.ListIterator;

public class DoubleLinkedList {
	private Node<E> head, tail;
	protected int size = 0;
	public DoubleLinkedList() {
		head = new Node<E>(null);
		tail = new Node<E>(null);
		head.next = tail;
		tail.previous = head;
	}
	
	public DoubleLinkedList(E[] objects) {
		head = new Node<E>(null);
		tail = new Node<E>(null);
		head.next = tail;
		tail.previous;
		for(int i = 0; i < objects.length; i++)
			add(objects[i]);
	}
	private static class Node<E>{
		E element;
		Node<E> next;
		Node<E> previous;
		public Node(E e) {
			element = e;
		}
	}
	
	public boolean add(E e) {
		add(size, e);
		return true;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
}

public boolean removeElement(E e) {
	int i = indexOf(e);
	if(i >= 0) {
		remove(i);
		return true;
	} else
		return false;
}

public boolean removeElement(E e) {
	int i = indexOf(e);
	if(i >= 0) {
		remove(i);
		return true;
	}else
		return false;
}

public E getFirst() {
	if(size == 0) {
		return null;
	}else {
		return head.next.element;
	}
}

public E getLast() {
	if(size == 0) {
		return null;
} else {
	return tail.previous.element;
}
}

public void addFirst(E e) {
	Node<E> newNode = new Node<E>(e);
	
	newNode.next = head.next;
	newNode.previous = head;
	head.next.previous = newNode;
	head.next = newNode;
	size++;
}

public void addLast(E e) {
	Node<E> newNode = new Node<E>(e);
	tail.previous.next = newNode;
	newNode.previous = tail.previous;
	newNode.next = tail;
	tail.previous = newNode;
	size++;
}

public void add(int index, E e) {
	if(index == 0) {
		addFirst(e);
	} else if (index >= size) {
		addLast(e);
} else {
	Node<E> current = head.next;
	for(int i =1; i < index; i++) {
		current = current.next;
	}
	Node<E> temp = current.next;
	Node<E> newNode = new Node<E>(e);
	current.next = newNode;
	newNode.previous = current;
	newNode.next = temp;
	temp.previous = newNode;
	size++;
}
}

public E removeFirst() {
	if(size == 0) {
		return null;
}else {
	Node<E> temp = head.next;
	head.next = head.next.next;
	head.next.previous = head;
	size--;
	return temp.element;
}
}
public E removeLast() {
	if(size == 0) {
		return null;
	} else {
		Node<E> temp = tail.previous;
		tail.previous = tail.previous.previous;
		tail.previous.next = tail;
		return temp.element;
	}
}

public E remove(int index) {
	if(index < 0 || index >= size) {
		return null;
	} else if (index == 0) {
		return removeFirst();
	} else if (index == size - 1) {
		return removeLast();
	} else {
		Node<E> previous = head.next;
		for(int i = 1;i < index; i++) {
			previous = previous.next;
		}
		Node<E> current = previous.next;
		previous.next = current.next;
		current.next.previous = previous;
		size--;
		return current.element;
	}
}

public boolean containsElement(E e) {
	Node<E> current = head.next;
	while(current != null) {
		if(current.element.equals(e))
			return true;
		current = current.next;
	}
	return false;
}
}

public E get(int index) {
	if(size <= index)
		return null;
	Node<E> current = head.next;
	for(int i=0; i<index; i++)
		current = current.next;
	return current.element;
}
public E set(int index, E e) {
	if(index >= size)
		return null;
	Node<E> current = head.next;
	for(int i =0; i<index; i++)
		current = current.next;
	E old = current.element;
	current.element = e;
	return old;
	}

public int indexOfElement(E e) {
	Node<E> current = head.next;
	int i = 0;
	while(current != null) {
		if (current.element.equals(e))
		return i;
	i++;
	current = current.next;
	}
return -1;
}

public int lastIndexOfElement(E e) {
	Node<E> current = head.next;
	int i = 0, lastIndex = -1;
	while(current != tail) {
		if(current.element.equals(e))
			lastIndex = i;
		i++;
		current = current.next;
}
	return lastIndex;
}
@Override
public String toString() {
	StringBuilder result = newStringBuilder("[");
	Node<E> current = head.next;
	for(int i = 0; i < size; i++) {
		result.append(current.element);
		current = current.next;
		if(current != tail) {
			result.append(", ");
		} else {
			result.append("]");
		}
	}
	return result.toString();
}

public void clear() {
	head.next = tail;
	tail.previous = head;
	size = 0;
}
public java.util.ListIterator<E> listIterator(){
	return new DoubleLinkedListIterator();
}
public java.util.ListIterator<E> listIterator(int index){
	return new DoubleLinkedListIterator(index);
}

private class DoubleLinkedList implements ListIterator<E>{
	private Node<E> current = head.next;
	private Node<E> lastAccessed = null;
	private int index = 0;
	
	public DoubleLinkedListIterator() {}
	public DoubleLinkedListIterator(int idx) {
		if(idx >= size)
			throw new NoSuchElementException();
		for(int i = 0; i < idx; i++) {
			current = current.next;
			index++;
	
		}
}
	public boolean hasNext() { return index < size;}
	public boolean hasPrevious() { return index > 0; }
	public int previousIndex() { return index - 1;}
	public int nextIndex() { return index;}
	
	public E next() {
		if(!hasNext()) throw new NoSuchElementException();
		lastAccessed = current;
		E element = current.element;
		current = current.next;
		index++;
		return element;
}
	public E previous() {
		if (!hasPrevious()) throw new NoSuchElementException();
		current = current.previous;
		index--;
		lastAccessed = current;
		return current.element;
}
	public void set(E element) {
		if(lastAccessed == null) throw new IllegalStateException();
		lastAccessed.element = element;
		}
	public void remove() {
	if (lastAccessed = null) throw new IllegalStateException();
	Node<E> x = lastAccessed.previous;
	Node<E> y = lastAccessed.next;
	x.next = y;
	y.previous = x;
	size--;
	if(current == lastAccessed)
		current = y;
	else
		index--;
	lastAccessed = null;
}
	public void add(E element) {
		Node<E> x = current.previous;
		Node<E> y = new Node<E>(element);
		Node<E> z = current;
		x.next = y;
		y.next = z;
		z.previous = y;
		y.previous = x;
		size++;
		index++;
		lastAccessed = null;
}
}

public static void main(String[] args) {
	String[] s1 = {"Tom", "George", "Peter", "Jean", "Jane", "Peter"};
	DoubleLinkedList<String> list1 = new DoubleLinkedList<String>(s1);
	System.out.println(list1.get(1));
	System.out.println(list1.containsElement("George"));
	System.out.println(list1.indexOfElement("Peter"));
	System.out.println(list1.lastIndexOfElement("Peter"));
	list1.set(1,  "Sam");
	System.out.println(list1);
	
	ListIterator<String> iterator = list1.listIterator();
	System.out.println("Forward order: ");
	while (iterator.hasNext()) {
		System.out.println(iterator.next() + ',');
}
	System.out.println("\n"+ "Reverse order: ");
	while(iterator.hasPrevious()) {
		System.out.println(iterator.previous() + ',');
	}
}

}
