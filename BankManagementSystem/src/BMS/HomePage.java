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
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
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
		
		JLabel lblNewLabel = new JLabel("Please Select Your Transaction");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(12, 5, 335, 25);
		panel_2.add(lblNewLabel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 0, 0));
		panel_2_1.setBounds(12, 59, 359, 184);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JButton depositBtn = new JButton("Deposit");
		depositBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountDeposit ad = new amountDeposit();
				ad.setVisible(true);
				dispose();
				
			}
		});
		depositBtn.setBounds(12, 52, 146, 25);
		panel_2_1.add(depositBtn);
		
		JButton fast = new JButton("Fast Cash");
		fast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FastCash fc = new FastCash();
				fc.setVisible(true);
				dispose();
				
			}
		});
		fast.setBounds(12, 88, 146, 25);
		panel_2_1.add(fast);
		
		JButton PinChange = new JButton("Pin Change");
		PinChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PinChange pc = new PinChange();
				pc.setVisible(true);
				dispose();
				
			}
		});
		PinChange.setBounds(12, 125, 146, 25);
		panel_2_1.add(PinChange);
		
		JButton withdrawl = new JButton("Cash Withdrawl");
		withdrawl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawAmount wa = new withdrawAmount();
				wa.setVisible(true);
				dispose();
			}
		});
		withdrawl.setBounds(188, 41, 159, 25);
		panel_2_1.add(withdrawl);
		
		JButton statement = new JButton("Mini Statement");
		statement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiniStatement ms = new MiniStatement();
				ms.setVisible(true);
				dispose();
			}
		});
		statement.setBounds(188, 78, 159, 25);
		panel_2_1.add(statement);
		
		JButton enquiry = new JButton("Balance Enquiry");
		enquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ca = Signup.card();
				String base = "jdbc:mysql://localhost:3307";
				String user = "root";
				String pass = "";
				
				try {
					Connection c = DriverManager.getConnection(base,user,pass);
					Statement s = c.createStatement();
					String dataBase = "Create Table IF NOT EXISTS BankManagementSystem.Transaction (Card_Number varchar(100), Amount varchar(300), Date varchar(200), Last_Transaction varchar(500) )";
					s.execute(dataBase);
					String value = "Select Amount from BankManagementSystem.Transaction WHERE Card_Number='"+ca +"'";
//					s.execute(value);
					ResultSet rs = s.executeQuery(value);
					if(rs.next()) {
						String a = rs.getString("Amount");
						JOptionPane.showMessageDialog(null, "You current balance is Rs.'"+a+"' ");
						c.close();
						s.close();
					}
				}catch(SQLException ea) {
					System.out.println(ea);
				}
			}
		});
		enquiry.setBounds(188, 115, 159, 25);
		panel_2_1.add(enquiry);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup sg = new Signup();
				sg.setVisible(true);	
				dispose();
			}
		});
		exit.setBounds(188, 152, 159, 25);
		panel_2_1.add(exit);
		
		btnNewButton.setForeground(new Color(51, 51, 51));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setIcon(new ImageIcon("/home/bisekh/Desktop/JavaEclipse/BMS/BankManagementSystem/icons/atmBooth.jpg"));
		btnNewButton.setBounds(12, 0, 1006, 738);
		panel.add(btnNewButton);
	}
}
