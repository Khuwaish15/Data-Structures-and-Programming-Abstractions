package CSE260;
import java.util.HashMap;
import java.util.Map;

public class Banking {
	public static void main(String[] args) throws Exception {
        Map dict1 = new HashMap();
        dict1.put("Abe", 1000);
        dict1.put("Bob", 500);

        transaction(dict1, "Abe", "withdraw", 200);
        transaction(dict1, "Abe", "deposit", 300);
        transaction(dict1, "Abe", "withdraw", -500);
        transaction(dict1, "Cain", "deposit", 200);
        System.out.println(dict1.entrySet());

    }

    public static void transaction(Map dbs, String customer, String transaction_type, int transaction_amount) throws Exception {
        Object dbsval = dbs.get(customer);
        int cash_value =  dbsval != null ? (int)dbsval : 0;
        int change_value = transaction_amount;
        if(transaction_type == "withdraw")
        {
            change_value *= -1;
        }

        //account for exceptions
        if(transaction_amount <= 0)
        {
            throw new Exception("Exception");
        }
        if(transaction_type == "withdraw" && (cash_value + change_value < 0))
        {
            throw new Exception("Exception");
        }
        if(dbs.get(customer) == null && !(transaction_type == "deposit" && transaction_amount > 0))
        {
            throw new Exception("Exception");
        }

        dbs.put(customer, cash_value + change_value);


    }

}
