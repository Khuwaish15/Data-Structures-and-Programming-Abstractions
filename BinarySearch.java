package CSE260;

public class BinarySearch {
	public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr,  3));
    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int left = 0;
        int right = list.length - 1;
        while(left < right) {
            int midPoint = (left + right) /2;
            if(key.compareTo(list[midPoint]) == 0) {
                return midPoint;
            }else if(key.compareTo(list[midPoint]) < 0) {
                left = midPoint + 1;
            }else {
                right = midPoint - 1;
            }
        }
        
        return -1;

    }

}
