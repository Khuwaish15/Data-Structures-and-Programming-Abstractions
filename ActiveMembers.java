package CSE260;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
 
public class ActiveMembers {

    public static List<String> find_active_members(String fileName) throws IOException {
        Path pathtofile = Path.of(System.getProperty("user.dir") + "/" + fileName);
        String file = Files.readString(pathtofile);

        String lines[] = file.split("\\r?\\n");
        Map<String, Integer> memberattendmap = new HashMap<>();
        for(int i = 0; i < lines.length; i++)
        {
            String current_person = "";
            String current_line = lines[i];
            int attend_num = 0;
            Boolean finished_name = false;
         
            for(int j = 0; j < current_line.length(); j++)
            {
                if(current_line.charAt(j) == '1')
                {
                    attend_num++;
                }
                else if(current_line.charAt(j) == ',')
                {
                    finished_name = true;
                }
                else if(!finished_name)
                {
                    current_person += (current_line.charAt(j));
                }
            }
            memberattendmap.put(current_person, attend_num);
        }
        List<String> active_members = new LinkedList<String>();

        for (String member : memberattendmap.keySet())
        {
            if(memberattendmap.get(member) >= 3)
            {
                active_members.add(member);
            }
        }
        return active_members;
    }

}
