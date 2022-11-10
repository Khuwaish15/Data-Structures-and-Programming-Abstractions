package CSE260;
import java.util.Arrays;

public class GenericMergeSort {
	if(list.length > 1) {
		E[] firstHalf = (E[]) new Comparable[list.length / 2];
		System.arraycopy(list, 0, firstHalf, 0, list.length/2);
		mergeSort(firstHalf);
		
		int secondHalfLength = list.length - list.length /2;
		E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
		System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
		mergeSort(secondHalf);
		
		merge(firstHalf, secondHalf, list);
	}
}

public static <E extends Comparable <E>> void merge(E[] list1, E[] list2, E[] temp) {
	int current1 = 0;
	int current2 = 0;
	int current3 = 0;
	
	while(current1 < list1.length && current2 < list2.length) {
		if(list1[current1].compareTo(list2[current2])<0)
			temp[current3++] = list1[current1++];
		else
			temp[current3++] = list2[current2++];
	}
	
	while (current1 < list1.length)
		temp[current3++] = list1[current1++];
	while(current2 < list2.length)
		temp[current3++] = list2[current2++];

}

public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
	if(list.length >1) {
		E[] firstHalf = Arrays.copyOf(list,list.length/2);
		mergeSort(firstHalf, comparator);
		
		E[] secondHalf = Arrays.copyOf(list,list.length/2, list.length);
		mergeSort(secondHalf, comparator);
		
		merge(firstHalf, secondHalf, list, comparator);
	}

}

}
