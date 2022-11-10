package CSE260;
import java.util.*;

public class SecretShopper {
	public static double grocery_shopping(Map<String, Integer> shopping_list,
	Map<String, Integer> child_sneaking, Map<String, Double>prices) {
		double total_cost = 0;
		for (Map.Entry<String, Integer>entry : shopping_list.entrySet()) {
			String product = entry.getKey();
			int count = entry.getValue();
			double price=prices.get(product)*count;
			total_cost += price;
			System.out.println("Product: "+ product + "Count: " + count + "Cost " + price);
		}
		System.out.println("-------------------------------------------");
		for (Map.Entry<String, Integer> entry : child_sneaking.entrySet()) {
			String product = entry.getKey();
			int count = entry. getValue();
			double price =prices.get(product)*count;
			total_cost += price;
			System.out.println("Product: "+ product + "Count: " + count + "Cost " + price);
		}
			System.out.println("Total Cost:" + total_cost);
			return total_cost;
	}

			public static void main(String[] args) {
				Map<String, Integer> shopping_list1 = Map.ofEntries(
						Map.entry("apples",5),
						Map.entry("bananas",10),
						Map.entry("oatmeal",1),
						Map.entry("granola bars",3),
						Map.entry("cheerios",2)
			);

			Map<String, Integer> child_sneaking1 = Map.ofEntries(
					Map.entry("flip flops",1), Map.entry("skittles",15), Map.entry("captain crunch",1)
			);

			Map<String, Double> prices1 = Map.ofEntries(
					Map.entry("apples",0.25),
					Map.entry("bananas",1.25),
					Map.entry("oatmeal",10.49),
					Map.entry("granola bars",9.68),
					Map.entry("cheerios",2.40),
					Map.entry("flip flops",14.99),
					Map.entry("skittles",1.49),
					Map.entry("captain crunch",3.50),
					Map.entry("Twinkies",1.30)

			);

			grocery_shopping(shopping_list1, child_sneaking1, prices1);

	}
}

