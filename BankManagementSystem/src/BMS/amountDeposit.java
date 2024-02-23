package BMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


public class amountDeposit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField DepositAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					amountDeposit frame = new amountDeposit();
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
	public amountDeposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 0, 1030, 721);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(246, 206, 383, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(12, 5, 359, 42);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Amount For Deposit ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(12, 5, 335, 25);
		panel_2.add(lblNewLabel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 0, 0));
		panel_2_1.setBounds(12, 59, 359, 184);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JButton deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String amount = DepositAmount.getText();
				String c= Signup.card();
				Database.Deposit(amount, c);
				JOptionPane.showMessageDialog(null, "Amount Deposited");
			}
		});
		deposit.setBounds(188, 78, 159, 25);
		panel_2_1.add(deposit);
		
		DepositAmount = new JTextField();
		DepositAmount.setBounds(12, 12, 335, 42);
		panel_2_1.add(DepositAmount);
		DepositAmount.setColumns(10);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		back.setBounds(188, 115, 159, 25);
		panel_2_1.add(back);
		
		btnNewButton.setForeground(new Color(51, 51, 51));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setIcon(new ImageIcon("/home/bisekh/Desktop/JavaEclipse/BMS/BankManagementSystem/icons/atmBooth.jpg"));
		btnNewButton.setBounds(12, 0, 1006, 738);
		panel.add(btnNewButton);
		
	}
}
