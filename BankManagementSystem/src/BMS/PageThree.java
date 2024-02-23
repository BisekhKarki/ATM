package BMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
//import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.Random;


public class PageThree extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String cardRandom;
	private static String pinRandom;
	private static JRadioButton savings;
	private static JRadioButton current;
	private static JRadioButton fixed;
	private static JRadioButton recurringDepositAccount;
	private static JCheckBox checkBox;
	
	
	
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageThree frame = new PageThree();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
//	When clicked canceled delete all the datas saved
	public static void delete() {
		String base = "jdbc:mysql://localhost:3307";
		String user = "root";
		String pass = "";
		try {
			Connection c = DriverManager.getConnection(base,user,pass);
			Statement s = c.createStatement();
			String dataBase = "Create Database If not exists BankManagementSystem";
			s.execute(dataBase);
			String delOne = "Delete from BankManagementSystem.Personal_Details WHERE Form_Number = '"+Signup.randomValue()+"'";
			s.execute(delOne);
			String delTwo = "Delete from BankManagementSystem.Additional_Details WHERE Form_Number = '"+Signup.randomValue()+"'";
			s.execute(delTwo);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	
//	For generating random card number of 16 digits
	public static String cardNumber() {
		Random rn = new Random();
		
		if (cardRandom==null) {
			long card = rn.nextInt(90000000) + 10000000; // Generate first 9 digits
			long card2 = rn.nextInt(90000000) + 10000000;
	        String cardOne = String.valueOf(card);
	        String cardTwo = String.valueOf(card2);
	        cardRandom = cardOne + cardTwo;
		}
		return cardRandom;
	}
	
//	For generating the pin number
	public static String pinNumber() {
		Random pr = new Random();
		
		if (pinRandom==null) {
			int pn = pr.nextInt(9000) + 1000; // Generate first 9 digits
	        pinRandom = Integer.toString(pn);
		}
		return pinRandom;
	}
	
	/**
	 * Create the frame.
	 */
	public PageThree() {
		
	
		
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 774);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 0, 981, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/bisekh/Desktop/JavaEclipse/BMS/BankManagementSystem/icons/icons8-bank-80.png"));
		lblNewLabel.setBounds(38, 12, 109, 77);
		panel.add(lblNewLabel);
		
		JLabel lblPage = new JLabel("Page 3: Account Details");
		lblPage.setBounds(202, 32, 461, 33);
		panel.add(lblPage);
		lblPage.setFont(new Font("Dialog", Font.BOLD, 28));
		
		JLabel lblFormNo = new JLabel("Form No: ");
		lblFormNo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFormNo.setBounds(726, 12, 122, 22);
		panel.add(lblFormNo);
		
		
		JLabel formNo = new JLabel("");
		formNo.setFont(new Font("Dialog", Font.BOLD, 18));
		formNo.setBounds(860, 12, 109, 22);
		panel.add(formNo);
		formNo.setText(Signup.randomValue());
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(22, 129, 971, 596);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Account Type:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(38, 12, 157, 15);
		panel_1.add(lblName);
		
		JLabel lblName_2 = new JLabel("Card Number :");
		lblName_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_2.setBounds(38, 158, 137, 15);
		panel_1.add(lblName_2);
		
		JLabel lblName_3 = new JLabel("Pin :");
		lblName_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_3.setBounds(38, 213, 110, 30);
		panel_1.add(lblName_3);
		
		JLabel lblName_4 = new JLabel("Occupation :");
		lblName_4.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_4.setBounds(38, 266, 137, 15);
		panel_1.add(lblName_4);
		
		JLabel lblName_5 = new JLabel("Service Required :");
		lblName_5.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_5.setBounds(38, 310, 215, 15);
		panel_1.add(lblName_5);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					String numberCard = "Your card Number is: " + cardNumber();
					String numberPin = "Pin : "+ pinNumber();
					if(savings.isSelected()) {
						String account = "Savings";
						String number = cardNumber();
						String pin = pinNumber();
						String form = Signup.randomValue();
						Database.pageThird(number,pin,form,account);
					} else if (current.isSelected()) {
						String account = "Current";
						String number = cardNumber();
						String pin = pinNumber();
						String form = Signup.randomValue();
						Database.pageThird(number,pin,form,account);
					} else if (fixed.isSelected()) {
						String account = "Fixed";
						String number = cardNumber();
						String pin = pinNumber();
						String form = Signup.randomValue();
						Database.pageThird(number,pin,form,account);
					} else if(recurringDepositAccount.isSelected()) {
						String account = "Recurring Deposit Account";
						String number = cardNumber();
						String pin = pinNumber();
						String form = Signup.randomValue();
						Database.pageThird(number,pin,form,account);
					}
					String message =numberCard +"\n" + numberPin;
					JOptionPane.showMessageDialog(null, message, "Alert", JOptionPane.INFORMATION_MESSAGE);
					Signup sg = new Signup();
					sg.setVisible(true);
					dispose();
				} else {
					String m = "Please agree the terms and conditions";
					JOptionPane.showMessageDialog(null, m, "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		submitBtn.setForeground(new Color(255, 255, 255));
		submitBtn.setBackground(new Color(61, 56, 70));
		submitBtn.setBounds(260, 554, 145, 30);
		panel_1.add(submitBtn);
		
		 savings = new JRadioButton("Saving  Account");
		savings.setBounds(46, 53, 149, 23);
		panel_1.add(savings);
		
		current = new JRadioButton("Current Account");
		current.setBounds(46, 97, 149, 23);
		panel_1.add(current);
		
		fixed = new JRadioButton("Fixed Deposit account");
		fixed.setBounds(275, 53, 215, 23);
		panel_1.add(fixed);
		
		recurringDepositAccount = new JRadioButton("Recurring Deposit account");
		recurringDepositAccount.setBounds(275, 97, 215, 23);
		panel_1.add(recurringDepositAccount);
		
		JLabel lblName_2_1 = new JLabel("XXXX-XXXX-XXXX-XXXX");
		lblName_2_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblName_2_1.setBounds(281, 159, 264, 15);
		panel_1.add(lblName_2_1);
		
		JLabel lblName_2_2 = new JLabel("(Your 16 digit Card Number)");
		lblName_2_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblName_2_2.setBounds(38, 179, 179, 15);
		panel_1.add(lblName_2_2);
		
		JLabel lblName_2_2_1 = new JLabel("(4 digit password)");
		lblName_2_2_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblName_2_2_1.setBounds(38, 242, 179, 15);
		panel_1.add(lblName_2_2_1);
		
		JLabel bankPin = new JLabel("XXXX");
		bankPin.setFont(new Font("Dialog", Font.BOLD, 18));
		bankPin.setBounds(281, 222, 129, 15);
		panel_1.add(bankPin);
		
		JCheckBox chckbxAtm = new JCheckBox("ATM Card");
		chckbxAtm.setBounds(46, 349, 149, 23);
		panel_1.add(chckbxAtm);
		
		JCheckBox chckbxMobileBanking = new JCheckBox("Mobile Banking");
		chckbxMobileBanking.setBounds(46, 399, 149, 23);
		panel_1.add(chckbxMobileBanking);
		
		JCheckBox chckbxChequeBook = new JCheckBox("Cheque Book");
		chckbxChequeBook.setBounds(46, 445, 149, 23);
		panel_1.add(chckbxChequeBook);
		
		JCheckBox chckbxInternetBanking = new JCheckBox("Internet Banking");
		chckbxInternetBanking.setBounds(281, 349, 168, 23);
		panel_1.add(chckbxInternetBanking);
		
		JCheckBox chckbxEmailAlerts = new JCheckBox("Email Alerts");
		chckbxEmailAlerts.setBounds(281, 399, 168, 23);
		panel_1.add(chckbxEmailAlerts);
		
		JCheckBox chckbxEstatements = new JCheckBox("E-statements");
		chckbxEstatements.setBounds(281, 445, 168, 23);
		panel_1.add(chckbxEstatements);
		
		JLabel lblIHearbyRead = new JLabel("I hearby declares that above entered details correct to the best of my knowledge");
		lblIHearbyRead.setBounds(81, 517, 611, 15);
		panel_1.add(lblIHearbyRead);
		
		checkBox = new JCheckBox("");
		checkBox.setBackground(new Color(255, 255, 255));
		checkBox.setBounds(46, 517, 21, 15);
		panel_1.add(checkBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				Signup s = new Signup();
				s.setVisible(true);
				dispose();
				
				
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(61, 56, 70));
		btnCancel.setBounds(455, 554, 145, 30);
		panel_1.add(btnCancel);
		
		JLabel lblName_2_2_2 = new JLabel("(It will appear in the ATM Card, Cheque book and statements)");
		lblName_2_2_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblName_2_2_2.setBounds(275, 186, 396, 15);
		panel_1.add(lblName_2_2_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 111, 981, 13);
		contentPane.add(separator);
	}
}
