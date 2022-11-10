package CSE260;
import java.util.*;

public class MaximumIncreasinglyOrderedSubsequence {
	static void method(String string)
	{
	        int n = string.length();
	        int[] dp = new int[n];
	        int[] lastIndex = new int[n];
	        Arrays.fill(dp, 1);
	        Arrays.fill(lastIndex, -1);
	        int maxValue = 0;
	        int maxIndex = -1;

	for (int i = 1; i < n; i++) {


	    for (int j = 0; j < i; j++) {
	        if (string.charAt(i) > string.charAt(j)) {
	            if(dp[j]+1 > dp[i])
	            {
	                dp[i] = dp[j]+1;
	                lastIndex[i] = j;
	            }
	        }
	    }

	    if(maxValue < dp[i])
	    {
	        maxValue = dp[i];
	        maxIndex = i;
	    }
	}

	int index = maxIndex;
	String ans = "";

	while(index != -1)
	{
	    ans = string.charAt(index) + ans;
	    index = lastIndex[index];
	}
	    System.out.println(ans);

	    }

}
