package CSE260;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Letters {
	public static void countChars(String filename) throws Exception{
		File file=new File(filename);
		Scanner reader= new Scanner (file);
		HashMap<Character, Integer> mp= new HashMap<Character,Integer>();
		
		while (reader.hasNextLine()) {
			String line= reader.nextLine();
			char [] lineArray = line.toCharArray();
			
			for (char c: lineArray) {
				if(mp.containsKey(c))
					mp.put(c,mp.get(c)+1);
				else
					mp.put(c, 1);
			}
		}
		for (Map.Entry entry: mp.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
			
		}
	}
		
	public static void main (String[]args) throws Exception{
		
		Scanner in= new Scanner(System.in);
		String str= in.nextLine();
		countChars(str);
	}
}
