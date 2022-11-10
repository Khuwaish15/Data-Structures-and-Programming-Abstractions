package CSE260;
import java.util.*;

public class BinPackingSmallest {
	public static ArrayList<ArrayList<Integer>> smallestFirstFit(Integer[] items, int capacity){
		Arrays.sort(items);
		ArrayList<ArrayList<Integer>> contents= new ArrayList<ArrayList<Integer>>();
		contents= BinPackingFirstFit.firstFit(items,capacity);
		
		return contents;
	}
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
				System.out.print("Enter number of objects:");
				int n= scan.nextInt();
				System.out.print("Enter weights of objects:");;
				Integer[]weights= new Integer[n];
				for (int i=0; i<n;i++)
				weights[i]=scan.nextInt();
				scan.close();
				
				ArrayList<ArrayList<Integer>>bins=smallestFirstFit(weights,10);
				for (int i=0; i<bins.size();i++) {
					ArrayList<Integer> bin=bins.get(i);
					System.out.print("\n Contentspf bin"+(i+1)+":");
					for (int j=0;j<bin.size();j++) {
						System.out.print(" "+bin.get(j));
					}
				}
		
	}

}
