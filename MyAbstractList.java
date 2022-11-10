package CSE260;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size=0;
	protected MyAbstractList() {
	}	
	protected MyAbsractList(E[]objects) {
		for (int i=0;i<objects.length;i++)
			add (objects[i]);
	}
	public void add(E e) {
		add(size,e);
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean remove(E e) {
		int i=indexOd(e);
		if(i>=0) {
			remove (i);
			return true;
		}else 
			return false;
	}
	
	public boolean addAll(MyList<E> otherList) {
		boolean changeFlag= false;
		Iterator<E> it= otherList.iterator();
		while(it.hasNext()) {
			E curr= it.next();
			if (!contains(curr)) {
				changeFlag=true;
				add(curr);
			}
		}
		return changeFlag;
	}
	
	public boolean removeAll(MyList<E>otherList) {
		boolean changeFlag=false;
		Iterator<E> it= otherList.iterator();
		while(it.hasNext()) {
			E curr= it.next();
			if (!contains(curr)) {
				changeFlag=true;
				remove(curr);
			}
		}
		return changeFlag;
	}
	public boolean retainAll(MyList<E>otherList) {
		boolean changeFlag=false;
		Iterator<E> it= this.iterator();
		Set<E> elementToRemove=newHashset<E>();
		while(it.hasNext()) {
			E curr= it.next();
			if (!otherlist.contains(curr)) {
				changeFlag=true;
				elementToRemove.add(curr);
			}
		}
		
		for (E elem:elementToRemove) {
			remove(elem);
		}
		return changeFlag;
	}
}
		
		
		
