import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;


public class Testbench
{

    public static void main(String[] args) throws IOException
    {

        Timer timer = new Timer();
        SendEmail mail = new SendEmail();
        TimerTask task = new TimerTask()

        {
            @Override
            public void run()
            {

                //Demo Purposes

                Document doc = null;
                String file = "";
                try
                {
                    file = Files.readString(Paths.get("C:\\Users\\nafis\\IdeaProjects\\BCHacks2020\\sample.html"));
                }
                catch(IOException e)
                {

                }




                doc = Jsoup.parse(file);
                //System.out.println(doc.toString());
                //doc = Jsoup.connect("https://courses.students.ubc.ca/cs/courseschedule?campuscd=UBCO&pname=subjarea&tname=subj-section&course=121&section=L09&dept=PHYS").get();


                Element table = doc.getElementsByClass("'table").first();
                List<String> seatSummary = table.getElementsByTag("td").eachText();
                System.out.println(seatSummary.get(1));
                if(Integer.parseInt(seatSummary.get(1)) > 0)
                {
                    timer.cancel();
                    timer.purge();
                    System.out.println("The class has freed up.");
                    mail.sendFromGmail("sscalertsystem@gmail.com", "bchacks2020", new String[]{"lakshaykarnwal@gmail.com", "nafisanjoom@gmail.com", "zack.hamza2001@gmail.com"}, "PHYS 101 L09", "This Class has freed up.");
                }
            }
        };

        long delay = 0;
        long interval = 1 * 1000;

        timer.scheduleAtFixedRate(task, delay, interval);
    }


}
