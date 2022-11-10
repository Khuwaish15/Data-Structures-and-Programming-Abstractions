package CSE260;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.*;  
import java.util.Date;  

public class AverageScreenTime {
	public static float avg_screentime(String fileName, String startDateStr, String endDateStr) throws IOException, ParseException {
        DateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = dateformatter.parse(startDateStr);
        Date endDate = dateformatter.parse(endDateStr);

        Path pathtofile = Path.of(System.getProperty("user.dir") + "/" + fileName);
        String file = Files.readString(pathtofile);
        String lines[] = file.split("\\r?\\n");

        Map<Date, Float> time_map = new HashMap<>();

        for(int i = 0; i < lines.length; i++)
        {
            String this_line = lines[i];
            String[] split_line = this_line.split(":");
            Date Date = dateformatter.parse(split_line[0]);
            Float Time = Float.parseFloat(split_line[1].split("\\s+")[0]);

            time_map.put(Date, Time);
        }
        float Total_Hours = 0;
        float Day_Hours = 0;
        for (Date thisdate : time_map.keySet())
        {
            if((thisdate == startDate || thisdate.after(startDate)) && (thisdate.before(endDate) || thisdate == endDate))
            {
                Day_Hours++;
                Total_Hours += time_map.get(thisdate);
            }
        }
        return Total_Hours/Day_Hours;
    }

}
