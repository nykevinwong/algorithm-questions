package test;

import javax.xml.datatype.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LatestStudent {

    private static int DifferenceBetween(Date one, Date two) {
        int day = one.getDay() - two.getDay();
        int hour = one.getHours() - two.getHours();
        int minute = one.getMinutes() - two.getMinutes();
        int result = day * 24 * 60 + hour * 60 + minute;
        return result;
    }


    public static void main(String[] args) {
        String[][] lateInfo = new String[][]{
                {"01/02/2018", "john", "11:00:00", "11:20:00"},
                {"01/02/2018", "lee", "15:00:00", "15:30:00"},
                {"01/02/2018", "alice", "10:00:00", "09:55:00"},
                {"01/02/2018", "kevin", "13:00:00", "13:00:00"},
                {"01/02/2018", "mario", "15:00:00", "15:10:00"},
                {"01/02/2018", "maria", "10:00:00", "10:15:00"},
                {"01/02/2018", "steve", "11:00:00", "11:30:00"},
                {"01/02/2018", "hanks", "15:00:00", "15:20:00"},
                {"01/02/2018", "hooks", "10:00:00", "10:05:00"},
                {"01/02/2018", "kong", "10:00:00", "11:40:00"},
        };

        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        HashMap<String, Integer> lateDiffMap = new HashMap<String, Integer>();
        int totalLateMinutes = 0;
        int lateCount = 0;

        // assume all entry are from the same days
        for(int i=0;i<lateInfo.length;i++)
        {
            String name =lateInfo[i][1];
            String classTimeString = lateInfo[i][0] + " " + lateInfo[i][2];
            String arriveTimeString =lateInfo[i][0] + " " + lateInfo[i][3];
            try {
                Date classTime = dateParser.parse(classTimeString);
                Date arriveTime = dateParser.parse(arriveTimeString);

                int diffMinute = DifferenceBetween(arriveTime, classTime);
                lateDiffMap.put(name, diffMinute);

                if(diffMinute > 0) {
                    System.out.printf("| %s is late", name);
                    lateCount++;
                    totalLateMinutes+= diffMinute;
                }
                else System.out.printf("| %s arrived on time", name);

                System.out.printf("\n classTime =" + classTime + "\n");
                System.out.printf("arriveTime =" + arriveTime + "\n");
                System.out.printf("diffTime in minutes =" + diffMinute + "\n");
            } catch(Exception e)
            {
                System.out.println("Error parsing: " + name);
            }

        }

        if(lateCount>0) {
            int aveLateMinute = totalLateMinutes / lateCount;
            System.out.println("\nAverage late minutes: " + aveLateMinute);
            String maxName = "";
            int maxMinute = Integer.MIN_VALUE;
            for(int i=0;i<lateDiffMap.size();i++)
            {
                String name = lateInfo[i][1];
                int diffMinute = lateDiffMap.get(name);
                int relativeLateMinute =  diffMinute - aveLateMinute;

                if(relativeLateMinute > 0 )
                {
                    if(relativeLateMinute > maxMinute)
                    {
                        maxMinute = relativeLateMinute;
                        maxName = name;
                    }
                }
            }
            System.out.printf("\n%s is the latest student. he is late for %d minutes from average late time (%d)", maxName, maxMinute, aveLateMinute );
        }
        else
        {
            System.out.println("No one is late");
        }

    }

}