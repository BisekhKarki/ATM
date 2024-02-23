package BMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MiniStatement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel balance;
	private static JLabel date;
	private static JLabel type;
	private static JLabel amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniStatement frame = new MiniStatement();
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
	public MiniStatement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMiniStatement = new JLabel("Mini Statement");
		lblMiniStatement.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiniStatement.setBounds(161, 12, 211, 24);
		contentPane.add(lblMiniStatement);
		
		JLabel lblYourCurrentBalance = new JLabel("Your current balance is: ");
		lblYourCurrentBalance.setBounds(24, 85, 173, 24);
		contentPane.add(lblYourCurrentBalance);
		
		JLabel balance = new JLabel("0");
		balance.setBounds(219, 90, 165, 15);
		contentPane.add(balance);
		
		JLabel lblLastTransactionOn = new JLabel("Last Transaction on: ");
		lblLastTransactionOn.setBounds(24, 134, 165, 24);
		contentPane.add(lblLastTransactionOn);
		
		JLabel lblYou = new JLabel("You");
		lblYou.setBounds(24, 185, 33, 24);
		contentPane.add(lblYou);
		
		JLabel type = new JLabel("type");
		type.setBounds(76, 185, 107, 24);
		contentPane.add(type);
		
		JLabel lblATotalAmount = new JLabel("a total amount of Rs:");
		lblATotalAmount.setBounds(195, 185, 165, 24);
		contentPane.add(lblATotalAmount);
		
		JLabel amount = new JLabel("0");
		amount.setBounds(372, 185, 133, 24);
		contentPane.add(amount);
		
		JLabel date = new JLabel("2024-02-23");
		date.setBounds(220, 134, 84, 24);
		contentPane.add(date);
		
		String ca = Signup.card();
		String base = "jdbc:mysql://localhost:3307";
		String user = "root";
		String pass = "";
		
		try {
			Connection c = DriverManager.getConnection(base,user,pass);
			Statement s = c.createStatement();
			String value = "Select * from BankManagementSystem.Transaction WHERE Card_Number='"+ca +"'";
			ResultSet rs = s.executeQuery(value);
			if(rs.next()) {
				String a = rs.getString("Amount");
				String d = rs.getString("Date");
				String last = rs.getString("Last_Transaction");
				balance.setText(a);
				date.setText(d);
				String plus = "+";
				String minus = "-";
				if(last.contains("-")) {
					type.setText("Withdrawn");
					String result = last.replace(minus, "");
					amount.setText(result);
				} else if (last.contains("+")) {
					type.setText("Deposited");
					String result = last.replace(plus, "");
					amount.setText(result);
				}
				
				
				c.close();
				s.close();
			}
		}catch(SQLException ea) {
			System.out.println(ea);
		}
		
		
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(182, 259, 117, 25);
		contentPane.add(btnBack);
	}
}
