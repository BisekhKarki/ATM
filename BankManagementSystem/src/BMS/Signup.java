package BMS;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField cardNumber;
	private static String randomValue;
	private static JPasswordField pinNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String randomValue(){
		Random r = new Random();
		if(randomValue==null) {
			int rm = r.nextInt(9000) + 1000;
			randomValue = Integer.toString(rm);
		}
		
		
		return randomValue;
	}
	
	
	public static String card() {
		String numberC = cardNumber.getText();
		return numberC;
	}

	/**
	 * Create the frame.
	 */
	public Signup() {
		setTitle("Automated Teller Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(17, 12, 613, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/bisekh/Desktop/JavaEclipse/BMS/BankManagementSystem/icons/icons8-bank-80.png"));
		lblNewLabel.setBounds(25, 12, 123, 72);
		panel.add(lblNewLabel);
		
		JLabel lblWelcomeToAtm = new JLabel("WELCOME TO ATM");
		lblWelcomeToAtm.setFont(new Font("Dialog", Font.BOLD, 28));
		lblWelcomeToAtm.setBounds(171, 27, 418, 44);
		panel.add(lblWelcomeToAtm);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCardNumber.setBounds(71, 156, 142, 25);
		contentPane.add(lblCardNumber);
		
		JLabel lblPin = new JLabel("Pin:");
		lblPin.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPin.setBounds(71, 219, 142, 25);
		contentPane.add(lblPin);
		
		cardNumber = new JTextField();
		cardNumber.setBounds(285, 145, 169, 34);
		contentPane.add(cardNumber);
		cardNumber.setColumns(10);
		
		JButton signIn = new JButton("Login");
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.connection();
				String base = "jdbc:mysql://localhost:3307";
				String user = "root";
				String pass = "";
				String card = cardNumber.getText() ;
				char[] number = pinNumber.getPassword();
				String pin = new String(number);
				try {
					Connection c = DriverManager.getConnection(base,user,pass);
					Statement s = c.createStatement();
					String val = "Select Card_Number, Pin from BankManagementSystem.Account_Details WHERE Card_Number='"+card +"'";
					s.execute(val);
					ResultSet rs = s.executeQuery(val);
					
					if(rs.next()) {
							String ca = rs.getString("Card_Number");
							String pn = rs.getString("Pin");
							if(ca.equals(card) &&  pn.equals(pin)) {
								JOptionPane.showMessageDialog(null, "Login Successful", "Alert", JOptionPane.INFORMATION_MESSAGE);
								HomePage hp = new HomePage();
								hp.setVisible(true);
								dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin \n Re-enter the pin and card number", "Alert", JOptionPane.INFORMATION_MESSAGE);
							}
		             }else {
		            	 JOptionPane.showMessageDialog(null, "User not found");
		             }
				}catch(SQLException c) {
					System.out.println(c);
				}
			}
		});
		signIn.setBackground(new Color(0, 0, 0));
		signIn.setForeground(new Color(255, 255, 255));
		signIn.setBounds(224, 283, 125, 34);
		contentPane.add(signIn);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardNumber.setText(" ");
				pinNumber.setText(" ");
			}
		});
		clear.setForeground(Color.WHITE);
		clear.setBackground(Color.BLACK);
		clear.setBounds(402, 283, 133, 34);
		contentPane.add(clear);
		
		
		
		JButton register = new JButton("Sign up");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration rg = new Registration();
				rg.setVisible(true);
				dispose();
			}
		});
		register.setForeground(Color.WHITE);
		register.setBackground(Color.BLACK);
		register.setBounds(321, 337, 133, 34);
		contentPane.add(register);
		
		JLabel lblNewUserregister = new JLabel("New user?Register");
		lblNewUserregister.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewUserregister.setBounds(104, 341, 199, 25);
		contentPane.add(lblNewUserregister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 120, 603, 11);
		contentPane.add(separator);
		
		pinNumber = new JPasswordField();
		pinNumber.setBounds(285, 214, 169, 38);
		contentPane.add(pinNumber);
	}
	
	
	
}
