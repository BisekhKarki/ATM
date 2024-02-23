package BMS;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel apllicationNumber;
	private JTextField name;
	private JTextField fatherName;
	private JTextField dob;
	private JTextField email;
	private JTextField address;
	private JTextField city;
	private JTextField pinCode;
	private JTextField province;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 769);
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
		
		JLabel lblApplicationForm = new JLabel("Application Form No.");
		lblApplicationForm.setFont(new Font("Dialog", Font.BOLD, 28));
		lblApplicationForm.setBounds(178, 22, 378, 44);
		panel.add(lblApplicationForm);
		
		apllicationNumber = new JLabel("1234");
		apllicationNumber.setFont(new Font("Dialog", Font.BOLD, 28));
		apllicationNumber.setBounds(549, 22, 207, 44);
		panel.add(apllicationNumber);
		apllicationNumber.setText(Signup.randomValue());
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(22, 129, 971, 598);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPage = new JLabel("Page 1: Personal Details");
		lblPage.setBounds(263, 12, 334, 33);
		lblPage.setFont(new Font("Dialog", Font.BOLD, 18));
		panel_1.add(lblPage);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(38, 78, 99, 15);
		panel_1.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name :");
		lblFathersName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFathersName.setBounds(38, 117, 157, 15);
		panel_1.add(lblFathersName);
		
		JLabel lblName_2 = new JLabel("Date Of Birth :");
		lblName_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_2.setBounds(38, 165, 137, 15);
		panel_1.add(lblName_2);
		
		JLabel lblName_3 = new JLabel("Gender :");
		lblName_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_3.setBounds(38, 214, 99, 15);
		panel_1.add(lblName_3);
		
		JLabel lblName_4 = new JLabel("Email :");
		lblName_4.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_4.setBounds(38, 256, 99, 15);
		panel_1.add(lblName_4);
		
		JLabel lblName_5 = new JLabel("Marital Status :");
		lblName_5.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_5.setBounds(38, 310, 137, 15);
		panel_1.add(lblName_5);
		
		JLabel lblName_6 = new JLabel("Address :");
		lblName_6.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_6.setBounds(38, 357, 123, 15);
		panel_1.add(lblName_6);
		
		JLabel lblName_7 = new JLabel("City :");
		lblName_7.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_7.setBounds(38, 407, 99, 15);
		panel_1.add(lblName_7);
		
		JLabel pin = new JLabel("Pin Code:");
		pin.setFont(new Font("Dialog", Font.BOLD, 16));
		pin.setBounds(38, 449, 123, 15);
		panel_1.add(pin);
		
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Dialog", Font.BOLD, 16));
		state.setBounds(38, 501, 99, 15);
		panel_1.add(state);
		
		name = new JTextField();
		name.setBounds(209, 73, 334, 27);
		panel_1.add(name);
		name.setColumns(10);
		
		fatherName = new JTextField();
		fatherName.setColumns(10);
		fatherName.setBounds(209, 112, 334, 27);
		panel_1.add(fatherName);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(209, 164, 334, 27);
		panel_1.add(dob);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.setBounds(207, 211, 108, 23);
		panel_1.add(Male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(331, 211, 99, 23);
		panel_1.add(female);
		
		JRadioButton others = new JRadioButton("Others");
		others.setBounds(444, 211, 99, 23);
		panel_1.add(others);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(209, 255, 334, 27);
		panel_1.add(email);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(209, 352, 334, 27);
		panel_1.add(address);
		
		JRadioButton single = new JRadioButton("Single");
		single.setBounds(211, 307, 87, 23);
		panel_1.add(single);
		
		JRadioButton married = new JRadioButton("Married");
		married.setBounds(333, 307, 108, 23);
		panel_1.add(married);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(209, 402, 334, 27);
		panel_1.add(city);
		
		pinCode = new JTextField();
		pinCode.setColumns(10);
		pinCode.setBounds(209, 448, 334, 27);
		panel_1.add(pinCode);
		
		province = new JTextField();
		province.setColumns(10);
		province.setBounds(209, 496, 334, 27);
		panel_1.add(province);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageTwo pt = new PageTwo();
				pt.setVisible(true);
				dispose();
				
				String userName = name.getText();
				String father = fatherName.getText();
				String birth = dob.getText(); 
				String em= email.getText();
				String location = address.getText();
				String place = city.getText();
				String pin = pinCode.getText();
				String state = province.getText();
				String form = Signup.randomValue();
				if(single.isSelected()) {
					String status = "Single";
					if(Male.isSelected()) {
						String gender = "male";
						Database.pageOne(userName,father,birth,em,location,place,pin,state,status,gender,form);
					}else if(female.isSelected()) {
						String gender = "female";
						Database.pageOne(userName,father,birth,em,location,place,pin,state,status,gender,form);
					}else if(others.isSelected()) {
						String gender = "others";
						Database.pageOne(userName,father,birth,em,location,place,pin,state,status,gender,form);
					}
					
				} else if(married.isSelected()) {
					String status = "Married";
					if(Male.isSelected()) {
						String gender = "male";
						Database.pageOne(userName,father,birth,em,location,place,pin,state,status,gender,form);
					}else if(female.isSelected()) {
						String gender = "female";
						Database.pageOne(userName,father,birth,em,location,place,pin,state,status,gender,form);
					}else if(others.isSelected()) {
						String gender = "others";
						Database.pageOne(userName,father,birth,em,location,place,pin,state,status,gender,form);
					}
					
				}
			}
		});
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBackground(new Color(61, 56, 70));
		btnNext.setBounds(399, 544, 145, 35);
		panel_1.add(btnNext);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 111, 981, 13);
		contentPane.add(separator);
	}
}
