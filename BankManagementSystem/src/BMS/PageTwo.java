package BMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageTwo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField religion;
	private JTextField income;
	private JTextField panNumber;
	private static JComboBox category;
	private static JComboBox education;
	private static JComboBox occupation;
	private static JRadioButton no;
	private static JRadioButton yes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageTwo frame = new PageTwo();
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
	public PageTwo() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 699);
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
		
		JLabel lblPage = new JLabel("Page 2: Additional Details");
		lblPage.setBounds(202, 32, 461, 33);
		panel.add(lblPage);
		lblPage.setFont(new Font("Dialog", Font.BOLD, 28));
		
		JLabel lblFormNo = new JLabel("Form No: ");
		lblFormNo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFormNo.setBounds(730, 12, 122, 22);
		panel.add(lblFormNo);
		
		
		JLabel formNo = new JLabel("");
		formNo.setFont(new Font("Dialog", Font.BOLD, 18));
		formNo.setBounds(860, 12, 109, 22);
		panel.add(formNo);
		formNo.setText(Signup.randomValue());
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(22, 129, 971, 525);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Religion:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(38, 42, 99, 15);
		panel_1.add(lblName);
		
		JLabel lblFathersName = new JLabel("Category :");
		lblFathersName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFathersName.setBounds(38, 100, 157, 15);
		panel_1.add(lblFathersName);
		
		JLabel lblName_2 = new JLabel("Income :");
		lblName_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_2.setBounds(38, 158, 137, 15);
		panel_1.add(lblName_2);
		
		JLabel lblName_3 = new JLabel("Education "
				+ "Quallification :");
		lblName_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_3.setBounds(38, 206, 236, 30);
		panel_1.add(lblName_3);
		
		JLabel lblName_4 = new JLabel("Occupation :");
		lblName_4.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_4.setBounds(38, 266, 137, 15);
		panel_1.add(lblName_4);
		
		JLabel lblName_5 = new JLabel("Pan Number :");
		lblName_5.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_5.setBounds(38, 310, 137, 15);
		panel_1.add(lblName_5);
		
		JLabel lblName_7 = new JLabel("Senior Citizen :");
		lblName_7.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName_7.setBounds(38, 376, 137, 15);
		panel_1.add(lblName_7);
		
		religion = new JTextField();
		religion.setBounds(209, 37, 334, 27);
		panel_1.add(religion);
		religion.setColumns(10);
		
		income = new JTextField();
		income.setColumns(10);
		income.setBounds(209, 153, 334, 27);
		panel_1.add(income);
		
		panNumber = new JTextField();
		panNumber.setColumns(10);
		panNumber.setBounds(209, 310, 334, 27);
		panel_1.add(panNumber);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageThree pt = new PageThree();
				pt.setVisible(true);
				dispose();
				
				String r = religion.getText();
				String i = income.getText();
				String pn = panNumber.getText();
				String c = (String)category.getSelectedItem();
				String edu = (String)education.getSelectedItem();
				String ocu = (String)occupation.getSelectedItem();
				String form = Signup.randomValue();
				
				if(yes.isSelected()) {
					String y = "Yes";
					Database.pageTwo(r,i,pn,c,edu,ocu,form,y);
				} else if(no.isSelected()) {
					String n = "No";
					Database.pageTwo(r,i,pn,c,edu,ocu,form,n);
				}
				
				
			}
		});
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBackground(new Color(61, 56, 70));
		btnNext.setBounds(398, 438, 145, 35);
		panel_1.add(btnNext);
		
		category = new JComboBox();
		category.setModel(new DefaultComboBoxModel(new String[] {"General", "OBC", "SC", "ST", "Other"}));
		category.setBounds(213, 96, 330, 24);
		panel_1.add(category);
		
		education = new JComboBox();
		education.setModel(new DefaultComboBoxModel(new String[] {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"}));
		education.setBounds(282, 210, 261, 24);
		panel_1.add(education);
		
		occupation = new JComboBox();
		occupation.setModel(new DefaultComboBoxModel(new String[] {"Salaried", "Sel-Employed", "Business", "Student", "Retired", "Others"}));
		occupation.setBounds(209, 262, 334, 24);
		panel_1.add(occupation);
		
		yes = new JRadioButton("Yes");
		yes.setBounds(219, 373, 88, 23);
		panel_1.add(yes);
		
		no = new JRadioButton("No");
		no.setBounds(362, 373, 88, 23);
		panel_1.add(no);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 111, 981, 13);
		contentPane.add(separator);
	}
}
