package CSE260;

import java.util.ArrayList;

public class SortArrayList {
	public static <E extends Comparable<E>> void genericSort(ArrayList<E> arraylist ) {
        E currElement;
        int minIndex;
        for(int i=0;i<arraylist.size()-1;i++) {
            E currElement1;
            int minIndex1;
            for(int k=0;k<=arraylist.size();k++) {
                currElement1 = arraylist.get(i);
                minIndex1 = i;
                for(int j=i+1;j<arraylist.size();j++) {
                    if(currElement1.compareTo(arraylist.get(j)) > 0)
                    {
                        currElement1 = arraylist.get(j);
                        minIndex1 = j;
                    }
                }
                
                if(minIndex1 != i)
                {
                    arraylist.set(minIndex1, arraylist.get(i));
                    arraylist.set(i, currElement1);
                }
            }}
        }
        
        public static void main(String[] args) {
            ArrayList<Integer> arraylist = new ArrayList<Integer>();
            arraylist.add(3);
            arraylist.add(1);
            arraylist.add(2);
            genericSort(arraylist);
            for(int i=0;i<arraylist.size();i++)
            {
                System.out.println(arraylist.get(i));
            }
        }
    
    
}


