import java.net.*;
import java.io.*;

public class Client
{

    private Socket socket = null;
    public static DataInputStream  input = null;
    private static DataOutputStream out = null;
    public static String line = "";
    public int counter = 0;
    public Client(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input  = new DataInputStream(System.in);

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input


        // keep reading until "Over" is input
        /*
        while (!line.equals("terminate"))
        {

            try
            {
                line = input.readLine();
                out.writeUTF(line);
                //out.writeUTF("121 L09 PHYS nafisanjoom@gmail.com");
            }
            catch(IOException i)
            {
                System.out.println(i);
            }



        }
 */
        // close the connection
        if(counter == 10)
        {
            try
            {
                input.close();
                out.close();
                socket.close();
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }



    }

    public static void takeInput(String str)
    {
        try
        {
            line = str;
            //line = input.readLine();
            out.writeUTF(line);
            //out.writeUTF("121 L09 PHYS nafisanjoom@gmail.com");
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    /*
    public static void main(String args[])
    {
        Client client = new Client("192.168.176.132", 5000);
    }

     */
}