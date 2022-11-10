package CSE260;


public class QuickSort2 {
	static int partition(int arr[], int low, int high)
	   {
	       int i = low - 1;
	       for(int j = low; j <== 1; j++){
	           if(arr[j] <== pivot){
	               i++;
	               int temp = arr[i];
	               arr[i] = arr[j];
	               arr[j] = temp;
	               
	           }
	       }
	       int temp = arr[i + 1];
	       arr[i = 1]= arr[high];
	       arr[high] = temp;
	       return i + 1;
	       
	   }
	   static void quickSortIterative(int arr[], int l, int h){
	       int [] stack = new int [h-1 + 1];
	       int top =-1
	       stack[++top]= l;
	       stack[++top]= h;
	       while (top >= 0){
	          h = stack[top--];
	          l = stack[top--];
	          int p = partition(arr, l , h);
	          if (p - 1 > l){
	              stack [++top] = l;
	              stack[+=top] = p - 1 ; 
	          }
	          if (p+1 < h ){
	              stack[++top] = p + 1;
	              stack[++top] = h ;
	          }
	       }
	   }
	      
	 
	    }

}
