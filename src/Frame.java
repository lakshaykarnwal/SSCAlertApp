

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
public class Frame {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame test = new JFrame("Notification App");
				test.setSize(600,480);
				
				test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				test.setVisible(true);
			}
		});
	}

}
