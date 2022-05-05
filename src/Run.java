import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

public class Run
{
    private String link;
    public static Run[] data = new Run[10];

    public Run(String... str) throws IOException
    {
        this(str[0],str[1], str[2], str[3]);
    }


    public  Run(String course, String section, String dept, String email) throws IOException
    {
        //https://courses.students.ubc.ca/cs/courseschedule?campuscd=UBCO&pname=subjarea&tname=subj-section&course=121&section=L09&dept=PHYS
        link = "https://courses.students.ubc.ca/cs/courseschedule?campuscd=UBCO&pname=subjarea&tname=subj-section&course=" + course + "&section=" + section + "&dept=" + dept;
        Timer timer = new Timer();
        SendEmail mail = new SendEmail();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                Document doc = null;
                try
                {
                    doc = Jsoup.connect(link).get();
                }
                catch (IOException a)
                {

                }

                Element table = doc.getElementsByClass("'table").first();
                List<String> seatSummary = table.getElementsByTag("td").eachText();
                System.out.println(seatSummary.get(1));
                if(Integer.parseInt(seatSummary.get(1)) > 0)
                {
                    timer.cancel();
                    timer.purge();
                    System.out.println("The class has freed up.");
                    String courseId = dept + " " + course + " Section " + section;
                    mail.sendFromGmail("sscalertsystem@gmail.com", "bchacks2020", new String[]{email}, courseId, courseId + " course has freed up.");
                }
            }
        };

        long delay = 0;
        long interval = 1 * 1000;

        timer.scheduleAtFixedRate(task, delay, interval);
    }


}
