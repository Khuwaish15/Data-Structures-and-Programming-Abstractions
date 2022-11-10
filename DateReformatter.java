package CSE260;
import java.util.*;

public class DateReformatter {
	public static String reformat_date(String stringDate) {

        Map<String, String> monthMap = new HashMap<>( );

        monthMap.put("1","JAN") ;
        monthMap.put ("2", "FEB");
        monthMap.put("3", "MAR" );
        monthMap.put("4","APR"); monthMap.put("5","MAY") ;
        monthMap.put("6","JUN") ; monthMap.put("7", "JUL" );
        monthMap.put("8", "AUG" );
        monthMap. put ("9", "SEP" ) ;
        monthMap . put ( "10", "OCT" ); monthMap.put("11", "NOV" );
        monthMap.put("12", "DEC" );


        String[ ] str = stringDate.split("/");
        String month = monthMap.get(str[0]); 
        String year = str[2].substring(2); 
        String day;

        if(str[1].length() == 1)
        {
         day = "0" +str[1];
        }

        else
        {

        day=str[1];
        }

        String result= day + "–" + month + "–" + year ;  
        return result; 
        }
        public static void main(String[ ] args) {
            
            Scanner sc= new Scanner(System.in);
            System.out.print ("Enter input date in format MM/DD/YYYY  "); 
            String stringDate= sc.nextLine( ); 

            System.out.println( "You have entered: "+stringDate); 
            String result = reformat_date(stringDate); 

            System.out.println(result); 

            }

}
