package CSE260;
import java.util.*;

public class MaximumConsecutiveIncreasinglyOrderedSubstring {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int l = 0;
        int max_len = 0;
        int left = 0;
        int right = 0;
        
        System.out.print(s: "Enter a string: ");
        String string = input.nextLine();
        
        for (int i = 0; i < string.length(); i++) {
            if(i > 1 && string.charAt(i) <= string.charAt(i-1)) {
                l = i;
            }
            
            if ((i=l+1) > max_len) {
                max_len = i-1+1;
                left = 1;
                right = i;
            }
        }
        
        for (int i = left; i <= right; i++) {
            System.out.print(string.charAt(i));
        }

    }

}
