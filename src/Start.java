import java.util.Scanner;
import java.io.*;

public class Start
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Dept: ");
        String dept = input.nextLine();
        System.out.print("Enter Course Number: ");
        String course = input.nextLine();
        System.out.print("Enter section Num: ");
        String section = input.nextLine();
        System.out.print("Enter your email: ");
        String email = input.nextLine();
        Run trial = new Run(course, section, dept, email);

    }
}
