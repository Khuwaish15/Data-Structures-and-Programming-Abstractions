package CSE260;
import java.util.*;

public class CheckOrder {
	public static boolean ordered(int[] list) {
		boolean isDescending = true;
		boolean isAscending = true;
		
		for (int i = 0; i < list.length - 1; i++) {
			isDescending = isDescending && (list[i] >= list[i+1]);
			isAscending = isAscending && (list[i]<=list[i+1]);
		}
		
		return isAscending || isDescending;
	}
	
	public static boolean ordered(int[] list, boolean ascending) {
		boolean isDescending = true;
		boolean isAscending = true;
		
		for(int i = 0; i < list.length - 1; i++) {
			isDescending = isDescending && (list[i] >= list[i+1]);
			isAscending = isAscending && (list[i]<=list[i+1]);
		}
		
		if (ascending == true) {
			return isAscending;
		}
		
		return isDescending;
	}
	
	public static boolean ordered(double[] list){
		boolean isDescending = true;
		boolean isAscending = true;
		
		for(int i = 0; i < list.length - 1; i++) {
			isDescending = isDescending && (list[i] >= list[i+1]);
			isAscending = isAscending && (list[i]<=list[i+1]);
		}
		
		return isAscending || isDescending;
	}
	
	public static boolean ordered(double[] list, boolean ascending) {
		boolean isDescending = true;
		boolean isAscending = true;
		
		for(int i = 0; i < list.length - 1; i++) {
			isDescending = isDescending && (list[i] >= list[i+1]);
			isAscending = isAscending && (list[i]<=list[i+1]);
		}
		
		if(ascending == true) {
			return isAscending;
		}
		
		return isDescending;
	}
	
	public static <E extends Comparable<E>> boolean ordered(E[] list) {
		boolean isDescending = true;
		boolean isAscending = true;
		
		for(int i = 0; i < list.length - 1; i++) {
			int c = list[i].compareTo(list[i+1]);
			isDescending = isDescending && (c>=0);
			isAscending = isAscending && (c<=0);
		}
		
		return isAscending || isDescending;
	}
	
	public static <E extends Comparable<E>> boolean ordered(E[] list, boolean ascending) {
		boolean isDescending = true;
		boolean isAscending = true;
		
		for(int i = 0; i < list.length - 1; i++) {
			int c = list[i].compareTo(list[i+1]);
			isDescending = isDescending && (c>=0);
			isAscending = isAscending && (c<=0);
		}
		
		if(ascending == true) {
			return isAscending;
		}
		return isDescending;
	}
	
	public static <E> boolean ordered(E[] list, Comparator<? super E> comparator) {
		boolean isDescending = true;
		boolean isAscending = true;
		
		for(int i = 0; i < list.length - 1; i++) {
			int c = comparator.compare(list[i+1], list[i+1]);
			isDescending = isDescending && (c>=0);
			isAscending = isAscending && (c<=0);
		}
		
		return isAscending || isDescending;
	}
	
	public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending) {
		boolean isDescending = true;
		boolean isAscending = true;
		
		for(int i = 0; i < list.length - 1; i++) {
			int c = comparator.compare(list[i+1], list[i+1]);
			isDescending = isDescending && (c>=0);
			isAscending = isAscending && (c<=0);
		}
		
		if(ascending == true) {
			return isAscending;
		}
		return isDescending;
	}
	
	public static void main(String args[]) {
		int unordered_arr[] = { 4, 6, 2, 1, 1, 2, 3 };
		int ascending_arr[] = { 1, 1, 3, 4, 5, 6, 10 };
		int descending_arr[] = { 9, 8, 8, 6, 3, 2, 1 };
		double d_unordered_arr[] = { 4, 6, 2, 1, 1, 2, 3 };
		double d_ascending_arr[] = { 1, 1, 3, 4, 5, 6, 10 };
		double d_descending_arr[] = {9, 8, 8, 6, 3, 2, 1};
		Integer i_unordered_arr[] = { 4, 6, 2, 1, 1, 2, 3};
		Integer i_ascending_arr[] = {1, 1, 3, 4, 5, 6, 10};
		Integer i_descending_arr[] = {9, 8, 8, 6, 3, 2, 1};
		
		System.out.print("Is ordered " + Arrays.toString(unordered_arr) + ordered(unordered_arr));
		System.out.print("Is ascending ordered " + Arrays.toString(ascending_arr) + ordered(ascending_arr,true));
		System.out.print("Is descending ordered " + Arrays.toString(descending_arr) + ordered(descending_arr,true));
		
		System.out.print("Is ordered " + Arrays.toString(d_unordered_arr) + ordered(d_unordered_arr));
		System.out.print("Is ascending ordered " + Arrays.toString(d_ascending_arr) + ordered(d_ascending_arr,true));
		System.out.print("Is descending ordered " + Arrays.toString(d_descending_arr) + ordered(d_descending_arr,true));
		
		System.out.print("Is ordered " + Arrays.toString(i_unordered_arr) + ordered(i_unordered_arr));
		System.out.print("Is ascending ordered " + Arrays.toString(i_ascending_arr) + ordered(i_ascending_arr,true));
		System.out.print("Is descending ordered " + Arrays.toString(i_descending_arr) + ordered(i_descending_arr,true));
		
		System.out.print("Is ordered " + Arrays.toString(i_unordered_arr) + ordered(i_unordered_arr, Comparator.<Integer>reverseOrder()));
		System.out.print("Is ascending ordered " + Arrays.toString(i_ascending_arr) + ordered(i_ascending_arr,Comparator.<Integer>reverseOrder()));
		System.out.print("Is descending ordered " + Arrays.toString(i_descending_arr) + ordered(i_descending_arr,Comparator.<Integer>reverseOrder()));
	}

}
