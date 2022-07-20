//Nur Aisya Fatihah
package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author NurAisyaFatihah
*/
public class KitchenFrame extends JFrame {

	JTextArea textArea = new JTextArea();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KitchenFrame frame = new KitchenFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KitchenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Kitchen");
		setBounds(100, 100, 657, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kitchen");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(274, 10, 96, 33);
		contentPane.add(lblNewLabel);
		
		
		textArea.setBounds(33, 67, 584, 324);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Received");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(256, 403, 114, 21);
		contentPane.add(btnNewButton);
	}
public void updateMenu (String menu) {
		
		// Get current status displayed on the window
		String currentText = textArea.getText();
		//txtRequestStatus.setEditable(true);
		
		// Display the latest status on top
		//status += "\n > " + currentText;
		this.textArea.setText(menu);
		textArea.setEditable(false);
	}
}
