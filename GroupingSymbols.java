package CSE260;
import java.io.*;
import java.util.*;

public class GroupingSymbols {
	public static void main(String[] args) {

		if (args.length != 1)
		{
		System.out.println("Usage: filename");
		System.exit(0);
		}

		File inFile = new File(args[0]);
		// Check if file exists
		if (!inFile.exists()) {
		System.out.println("File does not exist!");
		System.exit(1);
		}

		
		Stack<String> cstack = new Stack<>();
		
		ArrayList<String> symbolarray = new ArrayList<>();

		
		Collections.addAll(symbolarray, "(", ")", "{", "}", "[", "]");

		try(BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(inFile))))
		{
		String str;
		while ((str = bf.readLine()) != null)
		{

		for (char character : str.toCharArray())
		{
		String s = character + "";
		int sI = symbolarray.indexOf(s);

		if (sI == -1)
		continue;

		if (cstack.size() == 0)
		{
		cstack.push(s);
		}
		else
		{
		int lIndex = symbolarray.indexOf(cstack.peek());
		if (sI - 1 == lIndex)
		{
		cstack.pop();
		}

		else
		{
		if ((lIndex & 1) == 1)
		{
		System.out.println("ERROR at:" + str);
		}
		cstack.push(s);
		}
		}

		}

		}
		}
		catch (FileNotFoundException exception)
		{
		System.out.println("File not found.");
		exception.printStackTrace();
		}
		catch (IOException exception)
		{
		System.out.println("IO error.");
		exception.printStackTrace();
		}

		}

}
