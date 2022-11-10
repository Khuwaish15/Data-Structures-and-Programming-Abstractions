package CSE260;

import CSE260.GenericMyPriorityQueue.Heap;

public class Heap_clone_and_equals {
	public static void main(String[] args) throws CloneNotSupportedException{
		String[]strings= {"red", "green","purple","orange","yellow","cyan"};
		Heap heap_1= new Heap(strings);
		Heap heap_2= (Heap)(heap_1.clone());
		System.out.println("heap1:"+heap_1.getSize());
		System.out.println("heap2:"+heap_2.getSize());
		System.out.println("equals?"+ heap_1.equals(heap_2));

		heap_1.remove();
		
		System.out.println("heap1:"+heap_1.getSize());
		System.out.println("heap2:"+heap_2.getSize());
		System.out.println("equals?"+ heap_1.equals(heap_2));
	}
	
	public static class Heap implements Cloneable{
		String[] strs;
		int len;
		public Heap (String[] strings) {
			strs=new String[strings.length];
			for (int i=0; i<strings.length; i++) {
				strs[i]= strings[i];
			}
			len=strs.length;
		}
		public Heap clone() throws CloneNotSupportedException{
			Heap clones=(Heap)super.clone();
			return cloned;
		}
		public int getSize() {
			return len;
		}
		public boolean equals (Heap m) {
			if(len!=m.len) {
				return false;
			}
			for (String st: strs) {
				if(!strs.equals(m.strs)) {
					return false;
				}
			}
			return true;
		}
		public void remove() {
			if (len>0) {
				strs[len-1]=null;
			}
			len=len-1;
		}
	}
}
		
		
		


