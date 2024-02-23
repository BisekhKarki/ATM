package BMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PinChange extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange frame = new PinChange();
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
	public PinChange() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterThePin = new JLabel("Enter the pin");
		lblEnterThePin.setBounds(23, 33, 119, 25);
		contentPane.add(lblEnterThePin);
		
		pin = new JTextField();
		pin.setBounds(179, 29, 154, 33);
		contentPane.add(pin);
		pin.setColumns(10);
		
		JButton change = new JButton("Change pin");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = pin.getText();
				String ca = Signup.card();
				Database.changePin(num, ca);
				JOptionPane.showMessageDialog(null, "You pin has been changed");
			}
		});
		change.setBounds(60, 99, 131, 25);
		contentPane.add(change);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		back.setBounds(241, 99, 117, 25);
		contentPane.add(back);
	}
}
