package CSE260;
import java.util.Comparator;

public class GenericBubbleSort {
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		for(int k = 1; k < list.length; k++) {
			for(int i = 0; i < list.length - k; i++)
			if(list[i].compareTo(list[i + 1]) > 0) {
				E temp = list[i];
				list[i] = list[i +1];
				list[i + 1] = temp;
			}
		}
	}
	
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		for (int k = 1; k < list.length; k++) {
			for(int i = 0; i < list.length - k; i++) {
				if(comparator.compare(list[i], list[i+1] > 0)) {
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] input = {3, 4, 2, 1, 9, 8, 65, 34};
		
		bubbleSort(input);
		
		for(int i = 0; i < input.length; i++)
			System.out.print(input[i] + " ");
		System.out.println();
		
		bubbleSort(input, Comparator.<Integer>reverseOrder());
		
		for(int i =0; i < input.length; i++)
			System.out.print(input[i] + " ");
		System.out.println();
	}

}
