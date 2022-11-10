package CSE260;
import java.util.HashMap;
import java.util.Scanner;

public class PatternMatching {
	static int isSubstring(String s1, String s2)
    {
        int M = s1.length();
        int N = s2.length();
        for(int i=0; i<= M-N; i++) {
            int j;
            for(j=0; j<N; j++)
                if (s1.charAt(i+j) != s2.charAt(j))
                    break;
            if (j==N)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);
        String s1= in.nextLine();
        String s2= in.nextLine();
        for(int i=0;i<s1.length();i++)
        {
            String temp = "";
            for(int j=i;j<s1.length();j++)
            {
                temp+=s1.charAt(j);
                mp.put(temp, i);
            
            }
        }
        while(true) {
        if(mp.containsKey(s1))
        {
            System.out.println("Contains at -" +mp.get(s2));
        }
        else {
            System.out.println(x: "No substring");
        }
        
    }
    }

}
