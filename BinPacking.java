package CSE260;
import java.util.*;

public class BinPacking {
	private int best;
ArrayList<ArrayList<Integer>>contents_best= new ArrayList<ArrayList<Integer>>();
	
	public void bestFit(Integer [] bins, int used, Integer[] items, int index, int capacity, ArrayList<ArrayList<Integer>> contents) {
		if(used>= best) return;
		if(index<0) {
			best=used;
			contents_best= new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<contents.size(); i++) {
				contents_best.add(new ArrayList<Integer>(contents.get(i)));
			}
			return;
		}
		for(int i=0; i<used; i++) {
			if(bins[i]+items[index]<=capacity) {
				bins[i]+=items[index];
				contents.get(i).add(items[index]);
				bestFit(bins, used, items, index-1, capacity, contents);
				bins[i]-=items[index];
				contents.get(i).remove(contents.get(i).size()-1);
			}
		}
		bins[used]= items[index];
		contents.add(new ArrayList<Integer>());
		contents.get(used).add(items[index]);
		bestFit(bins,used+1,items,index-1,capacity,contents);
		bins[used]=0;
		contents.remove(contents.size()-1);
		return;
		
	}
	public static void main(String [] args) {
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter number of objects: ");
		int n=scan.nextInt();
		System.out.print("Enter weight of objects: ");
		Integer [] weights= new Integer [n];
		for(int i=0; i<n; i++)
		weights[i]=scan.nextInt();
		scan.close();
		
		ArrayList<ArrayList<Integer>>contents= new ArrayList<ArrayList<Integer>>();
		Integer[] bins_prospective= new Integer [weights.length];
		Arrays.fill(bins_prospective, 0);
		BinPacking obj= new BinPacking();
		obj.best=weights.length;
		obj.bestFit(bins_prospective, 0, weights, weights.length-1, 10, contents);
		for(int i=0; i<obj.contents_best.size(); i++) {
			ArrayList<Integer>bin= obj.contents_best.get(i);
			System.out.print("\n Contents of bin "+ (i+1) + ":");
			for(int j=0; j<bin.size(); j++) {
				System.out.print(" " +bin.get(j));
			}
			
		}
		
	}

}
