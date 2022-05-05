
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {

    /*
    public static void main(String[] args) {
        String from = "sscalertsystem@gmail.com";
        String pass = "bchacks2020";
        String[] to = {"nafisanjoom@gmail.com"};
        String subject = "Sending mail using Java for BCHacks! Testing #2";
        String body = "Hi this is Zack!";

        sendFromGmail(from, pass, to, subject, body);

    }

     */
    public static void sendFromGmail(String from, String pass, String[] to, String subject, String body ) {

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
        System.out.println("Program terminated.");
    }


}


