package CSE260;

public class Max {
	public static void main(String[] args) {
        Integer[] arr = {34, 1, 2, 34, 3, 4, 6, 8};
        System.out.println(max(arr));
    }
    
    public static <E extends Comparable<E>> E max(E[] list){
        E max = list[0];
        for(int i = 1; i < list.length; i++) {
            if(max.compareTo(list[i]) < 0) {
                max = list[i];
            }
        }
        
        return max;
    }

}
