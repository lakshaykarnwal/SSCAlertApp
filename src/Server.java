import java.io.*;
import java.net.*;

class Server {

    private static int counter = 0;

    public static void main(String args[])
            throws Exception
    {

        // Create server Socket
        ServerSocket ss = new ServerSocket(5000);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        // to send data to the client
        PrintStream ps = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // to read data from the keyboard
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        // server executes continuously
        while (true) {

            String str, str1;

            // repeat as long as the client
            // does not send a null string

            // read from client
            while ((str = br.readLine()) != "terminate") {
                try
                {
                    try
                    {
                        str = br.readLine();
                    } catch (IndexOutOfBoundsException a)
                    {

                    }

                    Run.data[counter] = new Run(str.split(" "));
                    System.out.println(str);
                    counter++;
                    if (counter == 10)
                    {
                        ps.print("Maximum number of request reached");
                        str = "terminate";
                        break;
                    }
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }

            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }
}