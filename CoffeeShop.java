package CSE260;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CoffeeShop {
	public static String is_valid_order(String fileName, List<String> orderList) throws IOException {
        Path pathtofile = Path.of(System.getProperty("user.dir") + "/" + fileName);
        String file = Files.readString(pathtofile);
        String lines[] = file.split("\\r?\\n");

        Map<String, Float> price_map = new HashMap<>();

        for(int i = 0; i < lines.length; i++)
        {
            String thisline = lines[i];
            String[] splitline = thisline.split(",");
            String coffee = splitline[0];
            Float cost = Float.parseFloat(splitline[1]);
            price_map.put(coffee, cost);
        }

        Float final_price = 0f;
        for(int i = 0; i < orderList.size(); i++)
        {
            final_price += (float)price_map.get(orderList.get(i));
        }

        return "Your order costs $" + (Math.round(final_price * 100.0) / 100.0);
    }

}
