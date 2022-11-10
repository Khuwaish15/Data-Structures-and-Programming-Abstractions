package CSE260;

public class LargestSubMatrix {
	static void printMaxSubSquaZe(int N[][]) {
		int i,j;
		int Z = N.length;
		int Y = N[0].length;
		
		int S[][] = new int[Z][Y];
		
		int max_of_s, max_i, max_j;
		
		for(i = 0; i < Z; i++)
			S[i][0] = N[i][0];
		
		for(j = 0; j < Y; j++)
			S[0][j] = N[0][j];
		
		for(i = 1; i < Z; i++) {
			
			for(j = 1; j < Y; j++) {
				if(N[i][j] == 1)
					S[i][j] = Math.min(S[i][j-1], Math.min(S[i-1][j],S[i-1][j-1])) +1;
				
				else
					S[i][j] = 0;
			}
		}
		
		max_of_s = S[0][0]; max_i = 0; max_j = 0;
		for(i = 0; i < Z; i++) {
			for(j = 0; j < Y; j++) {
				if(max_of_s < S[i][j]) {
					max_of_s = S[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		
		System.out.println("Maximum size sub-matrix beginning row and column is: ");
		System.out.print("Row" + (max_i - max_of_s +1) + " col " + (max_j - max_of_s + 1));
		
	}
	
	public static void main(String[] args) {
		int [][]N = new int[10][10];
		for (int i=0; i <10; i++) {
			for(int j=0; j<10; j++) {
				N[i][j] = (int)(Math.round( Math.random()));
				System.out.print(N[i][j]+ " ");
			}
			System.out.println();
		}
		
		printMaxSubSquaZe(N);
	}

}
