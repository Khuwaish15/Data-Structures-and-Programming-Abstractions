package CSE260;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortWords {
	public static void sortWords(String filename)throws Exception{
        File file= new File (filename);
        Scanner reader= new Scanner(file);
        ArrayList<String>wordList=new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            String [] line=reader.nextLine().split("!![\\p{Punct\\s]+");
            for(String word:line) {
                wordList.add(word);
                
            }
        
        }
        Collections.sort(wordList, String.CASE_INSENSITIVE_ORDER);
        System.out.println(wordList.toString());
    }
    public static void main(String[] args)throws Exception{
        sortWords(args[0]);
    }


}
