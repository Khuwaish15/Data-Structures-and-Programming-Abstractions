package CSE260;
import java.util.*;

public class BinPackingFirstFit {
	public static ArrayList<ArrayList<Integer>>firstFit(Integer [] items, int capacity){
		int [] bins= new int[items.length];
		int used=0;
		ArrayList<ArrayList<Integer>>contents= new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<items.length; i++) {
			boolean assigned= false;
			for(int j=0; j<used; j++) {
				if(bins[j]+items[i]<=capacity) {
					bins[j]+=items[i];
					contents.get(j).add(items[i]);
					assigned=true;
					break;
				}
			}
			if(assigned==false) {
				bins[used]+=items[i];
				contents.add(new ArrayList<Integer>());
				contents.get(used).add(items[i]);
				used++;
				
			}
		}
		return contents;
	}
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter number of objects: ");
		int n=scan.nextInt();
		System.out.print("Enter weights of objects");
		Integer[] weights= new Integer [n];
		for(int i=0; i<n; i++) 
			weights[i]=scan.nextInt();
		scan.close();
		
		ArrayList<ArrayList<Integer>>bins=firstFit(weights,10);
		for(int i=0; i<bins.size(); i++) {
			ArrayList<Integer>bin=bins.get(i);
			System.out.print("\n Contents of bin "+i+":");
			for(int j=0; j<bin.size(); j++) {
				System.out.print(" "+bin.get(j));
			}
		}
	}

}
