package CSE260;
import java.util.*;

public class SameNumberSubsequence {
	public static void get_same_num_sequence(ArrayList<Integer>list) {
        int max_count = 1, max_index = 0, max_value=list.get(0);
        int curr_count = 1, curr_index = 0, curr_value=list.get(0);
        for (int i = 1; i<list.size(); i++) {
            if(list.get(i) == list.get(i-1)) {
                curr_count++;
                if (curr_count > max_count) {
                    max_count = curr_count;
                    max_value = curr_value;
                    max_index = curr_index;
                }
            }
            else {
                curr_count = 1;
                curr_index =1;
                curr_value = list.get(i);
                
            }
        }
        System.out.println("Count;" +max_count+ "index:" + max_index + " value: " +max_value);
    }
        
        public static void main(String[]args) {
            Scanner scan = new Scanner(System.in);
            ArrayList<Integer>list = new ArrayList<Integer>();
            System.out.print("Enter integers please ");
            System.out.println("(0 to terminate): ");
            
            while(scan.hasNextInt()) {
                int input = scan.nextInt();
                list.add(input);
                if (input == 0) {
                    scan.close();
                    break;
                }
            }
            get_same_num_sequence(list);
    }

}
