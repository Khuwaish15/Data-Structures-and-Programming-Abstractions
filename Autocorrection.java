package CSE260;
import java.util.*;

public class Autocorrection {
    public static String autocorrect(String msg, Map<String, List<String>> mappings) {
        String[] splitmsg = msg.split("\\s+");
        

        for(int i = 0; i < splitmsg.length; i++)
        {
            String currentword = splitmsg[i];

            //check if correction exists, if so, set word in splitmsg to key
            for (String word : mappings.keySet())
            {
                if(mappings.get(word).contains(currentword))
                {
                    splitmsg[i] = word;
                }
            }
        }

        String correctedmsg = String.join(" ", splitmsg);
        return correctedmsg;
    }


}
