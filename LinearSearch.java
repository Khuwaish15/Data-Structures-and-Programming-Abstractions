package CSE260;

public class LinearSearch {
public static <E> int linearSearch(E[] list, E key) {
        
        for (int i = 0; i < list.length; i++) {
            if(key.compareTo(list[i]) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Integer[] list = {1,2,3,4,4};
        int ans;
        if((ans = linearSearch(list,  7)) != -1) {
            System.out.println(ans);
        }else {
            System.out.println("The value is not found");
        }

    }

}
