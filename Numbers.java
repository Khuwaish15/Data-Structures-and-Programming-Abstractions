package CSE260;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Numbers{
    
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        try(Scanner in = new Scanner(System.in)){
            int n = in.nextInt();
            while(n-- > 0) {
                int bal = in.nextInt();
                if(!ll.contains(val)) {
                    ll.add(val);
                }
            }
        }
        
        LinkedList<Integer> ll_duplicate = new LinkedList<Integer>();
        ll_duplicate = (LinkedList<Integer>)ll.clone();
        Collections.sort(ll_duplicate);
        System.out.println(ll_duplicate);
        Collections.shuffle(ll_duplicate);
        System.out.println(ll_duplicate);
        int i = 0;
        int j = ll.size()-1;
        while(i<j) {
            int temp = ll.get(i);
            ll.set(i, ll.get(j));
            ll.set(j, temp);
            i++;j--;
        }
        System.out.print(ll);
    }

}
