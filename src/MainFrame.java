import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	JPanel panel;
	JLabel course_code, section_code, dept_code, email_prompt, message;
	JTextField course_text, section_text, dept_text, email_text;
	JButton submitbutton;
	public static Client client = null;
	public MainFrame(String title) {
		super(title);
		

	}
	
	MainFrame(){
		// Course Label
		course_code = new JLabel();
		course_code.setText("Course Number");
		course_text = new JTextField();
		
		// Section Label
		section_code = new JLabel();
		section_code.setText("Your Section Number");
		section_text = new JTextField();
		
		// Lecture Number Label
		dept_code = new JLabel();
		dept_code.setText("4-Letter Course Code :");
		dept_text = new JTextField();
		
		// Email Collection Label
		email_prompt = new JLabel();
		email_prompt.setText("Whats your email?!!!");
		email_text = new JTextField();
		
		// Submit Button
		
		submitbutton = new JButton("Confirm");
		
		// Adding stuff to Container
		panel = new JPanel(new GridLayout(5, 1));
		panel.add(dept_code);
		panel.add(dept_text);
		panel.add(course_code);
		panel.add(course_text);
		panel.add(section_code);
		panel.add(section_text);
		panel.add(email_prompt);
		panel.add(email_text);
		
		//Message on corner
		message = new JLabel();
		panel.add(message);
		
		//Adding submit button to container
		panel.add(submitbutton);
		
		//Adding the stuff that act like scanners
		submitbutton.addActionListener(this);
		add(panel, BorderLayout.CENTER);
		setTitle("We'll email you if your course freed up");
		//setSize(900,700);
		setSize(500,300);
		//Making it visible
		setVisible(true);



		
	}
	public static void main(String[] args)
	{
		new MainFrame();
		client = new Client("192.168.176.132", 5000);

	}
	@Override
	public void actionPerformed(ActionEvent somethinghappens) {
		String course = course_text.getText();
		String section = section_text.getText();
		String dept = dept_text.getText();
		String email = email_text.getText();
		
		message.setText("Input received we will send you an email when your course has freed up");
		System.out.println(course + section + dept + email);
		client.takeInput(course + " " + section + " " + dept + " " + email);
		//client.takeInput("121 L09 PHYS nafisanjoom@gmail.com");
	}

}
