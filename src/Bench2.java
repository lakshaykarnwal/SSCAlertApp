import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Bench2
{
    public static void main(String[] args)
    {
        String str = "";
        try
        {
            str = Files.readString(Paths.get("C:\\Users\\nafis\\IdeaProjects\\BCHacks2020\\sample.html"));
        }
        catch(IOException e)
        {

        }
        System.out.println(str);
    }
}
