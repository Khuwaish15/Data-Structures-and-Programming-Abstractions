package CSE260;
import java.util.Comparator;

public class GenericHeapUsingComparator {
	 static class IntegerComparator implements Comparator<Integer> {
		  @Override
		  public int compare(Integer o1, Integer o2) {
		   return o1.intValue() - o2.intValue();
		  }  
		 }

		 
		 public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
		  // Create a Heap of integers
		  Heap<E> heap1 = new Heap<E>(comparator);

		  
		  for (int i = 0; i < list.length; i++)
		   heap1.add(list[i]);

		  
		  for (int i = list.length - 1; i >= 0; i--)
		   list[i] = heap1.remove();
		 }

		
		 public static void main(String[] args) {
		  Integer[] list = { -44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53 };
		  heapSort(list, new IntegerComparator());
		  for (int i = 0; i < list.length; i++)
		   System.out.print(list[i] + " ");
		 }
		 
		 
		 static class Heap  <E>  {
		  private Comparator<? super E> comparator;
		  
		  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

		  
		  public Heap(Comparator<? super E> comparator) {
		   this.comparator = comparator;
		  }

		  
		  public Heap(E[] objects) {
		   for (int i = 0; i < objects.length; i++)
		    add(objects[i]);
		  }

		 
		  public void add(E newObject) {
		   list.add(newObject); 
		   int currentIndex = list.size() - 1; 
		   while (currentIndex > 0) {
		    int parentIndex = (currentIndex - 1) / 2;
		    
		    if (comparator.compare(list.get(currentIndex), (list.get(parentIndex))) > 0) {
		     E temp = list.get(currentIndex);
		     list.set(currentIndex, list.get(parentIndex));
		     list.set(parentIndex, temp);
		    } else
		     break;

		    currentIndex = parentIndex;
		   }
		  }

		 
		  public E remove() {
		   if (list.size() == 0)
		    return null;

		   E removedObject = list.get(0);
		   list.set(0, list.get(list.size() - 1));
		   list.remove(list.size() - 1);

		   int currentIndex = 0;
		   while (currentIndex < list.size()) {
		    int leftChildIndex = 2 * currentIndex + 1;
		    int rightChildIndex = 2 * currentIndex + 2;

		    // Find the maximum between two children
		    if (leftChildIndex >= list.size())
		     break; // The tree is a heap
		    int maxIndex = leftChildIndex;
		    if (rightChildIndex < list.size()) {
		     if (comparator.compare(list.get(maxIndex), (list.get(rightChildIndex))) < 0) {
		      maxIndex = rightChildIndex;
		     }
		    }

		   
		    if (comparator.compare(list.get(currentIndex), (list.get(maxIndex))) < 0) {
		     E temp = list.get(maxIndex);
		     list.set(maxIndex, list.get(currentIndex));
		     list.set(currentIndex, temp);
		     currentIndex = maxIndex;
		    } else
		     break; 
		   }

		   return removedObject;
		  }

		  
		  public int getSize() {
		   return list.size();
		  }
		 }
}


