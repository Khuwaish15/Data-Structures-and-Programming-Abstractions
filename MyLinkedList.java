public boolean contains(E e) {
	Node<E> current= head;
	while (current!=null) {
		if (current.element.equals(e))
			return true;
		current=current.next ;
	}
	return false;
	}

public E get(int index) {
	if(size<= indec)
		return null;
	Node <E> current= head;
	for (int i=0; i<index; i++)
		current=current.next;
	return curremt.element;
	}
public E set( int index, E e) {
	if( index>=size)
		return null;
	Node<E> current=head;
	for (int i=0; i<index; i++)
		current= current.next;
	E old= current.element;
	current.element= e
			return old;
	}
public int indexOf(E e) {
	Node<E> current= head;
	int i=0;
	while current !=null){
		if (current.element.equals(e))
			return i;
		i++;
		current= current.next;
		}
	return -1;
}
	public int lastIndexofE(E e) {
		Node<E> current=head;
		int i=0, lastIndex=-1;
		while(current !=null) {
			if (current.element.equals(e))
				lastIndex= i;
			i++;
			current=current.next;
			}
		return lastIndex;
		}
	
	public String toString() {
		StringBuilder result=new StringBuilder("[");
		Node<E> current= head;
		for (int i=0; i< size; i++) {
			result.append(current.element);
			current= current.next;
			if(current!=null) {
				result.append(",");
			} else {
				result.append("]")
			}
			}
		return result. toString();
		}
		public void clear() {
			head=tall=null;
		}
		@Override
		public Iterator <E> iterator(){
			return new LinkedListIterator();
		}
		private class LinkedListIterator implements java.util.Iterator<E>{
			Node<E> current= head;
			int index= 0;
			@Override
			public boolean hasNext() {
				return (current != null);
			}
			@Override
			public E next() {
				Node<E> node= current;
				current= current.next;
				index++;
				return node.element;
			}
			@Override
			public void remove() {
			MyLinkedList. this. remove(index);
			}
			}
		public static void main(String[] args) {
			String[] s1= {"Tom", "George", "Peter", "Jean", "Jane", "Peter"
			MyLinkedList<String> list1= new MyLinkedinList<String>(s1);
			System.out.println(list1.get(1)));
			System.out.printly(list1. indexof("Peter"));
			System.out.println(list1.lastIndexOf("Peter"));
			list1.set(1,"Sum");
			System.out.println(list1);
			}
		}

	




		
		
