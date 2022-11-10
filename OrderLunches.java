package CSE260;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderLunches {
	 static int order_lunches(HashMap<String,Integer> mp, ArrayList<String> list)
	    {
	        int validItems = 0;
	        for(String item : list)
	        {
	            if(mp.containsKey(item) && mp.get(item) > 0)
	            {
	                mp.put(item, mp.get(item)-1);
	                validItems++;
	            }
	        }
	        return validItems++;
	    }
	    
	    public static void main(String[] args) {
	        
	        HashMap<String, Integer> mp = new HashMap<String, Integer>();
	        ArrayList<String> list = new ArrayList<String>();
	        
	        mp.put(key: "soda", value:0);
	        mp.put(key: "burger", value: 3);
	        mp.put(key: "chips", value: 5);
	        mp.put(key: "pizza", value: 7);
	        
	        list.add(e: "soda");
	        list.add(e: "sandwhich");
	        list.add(e: "burger");
	        list.add(e: "pizza");
	        list.add(e: "pizza");
	        list.add(e: "burger");
	        
	        int value = order_lunches(mp,list);
	        System.out.println("Total valid item purchase - " + value);
	    }

}
