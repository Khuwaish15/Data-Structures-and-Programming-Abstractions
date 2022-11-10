package CSE260;
import java.io.File;
import java.util.*;

public class ExpenseGrouping {
	public static void main(String[] args) throws Exception{
        compute_categories_percentage(fileName:"input.txt");
    }
    
    public static void compute_categories_percentage(String fileName) throws Exception{
        File file = new File(fileName);
        Scanner fileScan = new Scanner(file);
        ArrayList<Item> itemList = new ArrayList<Item>();
        
        double total = 0;
        
        while(fileScan.hasNextLine()) {
            String[] item = fileScan.nextLine().split("-");
            if(item[0].equals("Total"))
                total = Double.parseDouble(item[1]);
            else {
                String name = item[0];
                double price = Double.parseDouble(item[1]);
                String group = item[2];
                itemList.add(new Item(name, price, group));
            }
        }
        
        Map<String, Double> map = new HashMap<String, Double>();
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            double groupPrice = map.getOrDefault(item.group, 0.0);
            groupPrice = groupPrice/100 * total;
            groupPrice = (groupPrice + item.price)/total * 100;
            
            map.put(item.group, groupPrice);
        }
        
        System.out.println(map.toString());
    }

}

class Item{
    public String name;
    public double price;
    public String group;
    
    public Item(String name, double price, String group) {
        this.name = name;
        this.price = price;
        this.group = group;
    }

}
