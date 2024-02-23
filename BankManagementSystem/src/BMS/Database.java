package BMS;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
public static void connection() {
	String base = "jdbc:mysql://localhost:3307";
	String user = "root";
	String pass = "";
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		if(c != null) {
			System.out.print("Connected");
		} 
		String dataBase = "Create Database If not exists BankManagementSystem";
		s.execute(dataBase);
	}catch(SQLException e) {
		System.out.println(e);
	}

}

public static void pageOne(String userName,String father, String  birth,String  em, String location,String  place,String  pin,String  province,String status, String gender, String form) {
	String base = "jdbc:mysql://localhost:3307/BankManagementSystem";
	String user = "root";
	String pass = "";
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		String dataBase = "Create Database If not exists BankManagementSystem";
		s.execute(dataBase);
		String name = userName;
		String f = father;
		String dob = birth;
		String email = em;
		String address = location;
		String city = place;
		String pi = pin;
		int p = Integer.parseInt(pi);
		String state = province;
		String marriage = status;
		String g = gender;
		String application = form;
		String table = "CREATE TABLE IF NOT EXISTS BankManagementSystem.Personal_Details ("
                + "ID INT AUTO_INCREMENT PRIMARY KEY, "
                + "Name VARCHAR(150), "
                + "Father_Name VARCHAR(150), "
                + "Date_Of_Birth VARCHAR(500), "
                + "Gender VARCHAR(100), "
                + "Email VARCHAR(200), "
                + "Maritial_Status VARCHAR(150), "
                + "Address VARCHAR(150), "
                + "City VARCHAR(150), "
                + "Pin_Code INT, "
                + "State VARCHAR(200), "
                + "Form_Number varchar(100))";
        s.executeUpdate(table);

        String inserting = "INSERT INTO BankManagementSystem.Personal_Details "
                + "(Name, Father_Name, Date_Of_Birth, Gender, Email, Maritial_Status, Address, City, Pin_Code, State,Form_Number) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
       
		PreparedStatement ps = c.prepareStatement(inserting);
		ps.setString(1,name);
		ps.setString(2,f);
		ps.setString(3,dob);
		ps.setString(4,g);
		ps.setString(5,email);
		ps.setString(6,marriage);
		ps.setString(7,address);
		ps.setString(8,city);
		ps.setInt(9,p);
		ps.setString(10, state);
		ps.setString(11, application);	
		ps.executeUpdate();
		c.close();
		s.close();
		ps.close();		
	}catch(SQLException f) {
		System.out.println(f);
	}
	
	
}

public static void pageTwo(String r,String  i,String  pn,String  ct,String  edu,String  ocu,String form,String sc) {
	String base = "jdbc:mysql://localhost:3307/BankManagementSystem";
	String user = "root";
	String pass = "";
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		String dataBase = "Create Database If not exists BankManagementSystem";
		s.execute(dataBase);
		String religion = r;
		String income = i;
		String  panNumber= pn;
		String category = ct;
		String education = edu;
		String occupation = ocu;
		String senior = sc;
		String application = form;
		String table = "CREATE TABLE IF NOT EXISTS BankManagementSystem.Additional_Details ("
                + "ID INT AUTO_INCREMENT PRIMARY KEY, "
                + "Religion VARCHAR(150), "
                + "Category VARCHAR(150), "
                + "Income VARCHAR(500), "
                + "Education VARCHAR(100), "
                + "Occupation VARCHAR(200), "
                + "Pan_Number INT(50), "
                + "Senior_Citizen VARCHAR(150),"
                + "Form_Number varchar(100))";
        s.executeUpdate(table);
        String inserting = "INSERT INTO BankManagementSystem.Additional_Details "
                + "(Religion, Category, Income, Education, Occupation, Pan_Number, Senior_Citizen, Form_Number) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(inserting);
		ps.setString(1,religion);
		ps.setString(2,category);
		ps.setString(3,income);
		ps.setString(4,education);
		ps.setString(5,occupation);
		ps.setString(6,panNumber);
		ps.setString(7,senior);
		ps.setString(8,application);
		ps.executeUpdate();
		c.close();
		s.close();
		ps.close();
	}catch(SQLException f) {
		System.out.println(f);
	}
}

public static void pageThird(String number,String pin,String form,String account) {
	String base = "jdbc:mysql://localhost:3307/BankManagementSystem";
	String user = "root";
	String pass = "";
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		String dataBase = "Create Database If not exists BankManagementSystem";
		s.execute(dataBase);
		String cardNumber = number;
		String pinNumber = pin;
		String  application= form;
		String type = account;
		String table = "CREATE TABLE IF NOT EXISTS BankManagementSystem.Account_Details ("
                + "ID INT AUTO_INCREMENT PRIMARY KEY, "
                + "Account_Type varchar(150), "
                + "Card_Number varchar(20), "
                + "Pin varchar(5), "
                + "Form_Number VARCHAR(100) )";
        s.executeUpdate(table);
        String inserting = "INSERT INTO BankManagementSystem.Account_Details "
                + "(Account_type, Card_Number, Pin, Form_Number) "
                + "VALUES (?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(inserting);
		ps.setString(1,type);
		ps.setString(2,cardNumber);
		ps.setString(3,pinNumber);
		ps.setString(4,application);
		ps.executeUpdate();
		c.close();
		s.close();
		ps.close();
	}catch(SQLException f) {
		System.out.println(f);
	}
}

public static void Deposit(String amount,String ca) {
	String base = "jdbc:mysql://localhost:3307";
	String user = "root";
	String pass = "";
	 LocalDate currentDate = LocalDate.now();
	 String date = currentDate.toString();
     System.out.println("Current Date: " + date);
     String val = amount;
     String num = ca;
     String last = "+"+amount;
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		String dataBase = "Create Table IF NOT EXISTS BankManagementSystem.Transaction (ID INT AUTO_INCREMENT PRIMARY KEY,Card_Number varchar(100), Amount varchar(300), Date varchar(200), Last_Transaction varchar(500) )";
		s.execute(dataBase);
		String value = "Select * from BankManagementSystem.Transaction WHERE Card_Number='"+num +"'";
		ResultSet rs = s.executeQuery(value);
		if(rs.next()) {
			String a = rs.getString("Card_Number");
			String am = rs.getString("Amount");
			if(a.equals("")) {
				String insert = "Insert into BankManagementSystem.Transaction (Card_Number, Amount, Date, Last_Transaction) VALUES (?,?,?,?)";
				PreparedStatement ps = c.prepareStatement(insert);
				ps.setString(1,num);
				ps.setString(2,val);
				ps.setString(3,date);
				ps.setString(4,last);
				ps.executeUpdate();
				c.close();
				s.close();
				ps.close();
			} else {
				int newVal = Integer.parseInt(val);
				int newA = Integer.parseInt(am);
				int total = newVal + newA;
				String newAmount = Integer.toString(total);
				String insert = "UPDATE BankManagementSystem.Transaction SET Amount = '"+newAmount+"', Last_Transaction= '"+last+"', Date='"+date+"' WHERE Card_Number = '"+num+"'";
				s.executeUpdate(insert);
			}
			
			c.close();
			s.close();
		}
		
		
		
	}catch(SQLException e) {
		System.out.println(e);
	}
}
public static void Withdraw(int amount,String ca) {
	String base = "jdbc:mysql://localhost:3307";
	String user = "root";
	String pass = "";
	 LocalDate currentDate = LocalDate.now();
	 String date = currentDate.toString();
     System.out.println("Current Date: " + date);
     int val = amount;
     String num = ca;
     String last = "-"+amount;
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		String dataBase = "Create Table IF NOT EXISTS BankManagementSystem.Transaction (Card_Number varchar(100), Amount varchar(300), Date varchar(200), Last_Transaction varchar(500) )";
		s.execute(dataBase);
		String value = "Select Amount from BankManagementSystem.Transaction WHERE Card_Number='"+num +"'";
		ResultSet rs = s.executeQuery(value);
		if(rs.next()) {
			String a = rs.getString("Amount");
			int caa = Integer.parseInt(a);
			int total = caa - val;
			String newAmount = Integer.toString(total);
			String insert = "UPDATE BankManagementSystem.Transaction SET Amount = '"+newAmount+"', Last_Transaction= '"+last+"', Date='"+date+"' WHERE Card_Number = '"+num+"'";
			s.executeUpdate(insert);
			c.close();
			s.close();
		}
	}catch(SQLException e) {
		System.out.println(e);
	}
}

public static void cashWithdraw(int amount,String ca) {
	String base = "jdbc:mysql://localhost:3307";
	String user = "root";
	String pass = "";
	 LocalDate currentDate = LocalDate.now();
	 String date = currentDate.toString();
     System.out.println("Current Date: " + date);
     int val = amount;
     String num = ca;
     String last = "-"+amount;
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		String dataBase = "Create Table IF NOT EXISTS BankManagementSystem.Transaction (Card_Number varchar(100), Amount varchar(300), Date varchar(200), Last_Transaction varchar(500) )";
		s.execute(dataBase);
		String value = "Select Amount from BankManagementSystem.Transaction WHERE Card_Number='"+num +"'";
//		s.execute(value);
		ResultSet rs = s.executeQuery(value);
		if(rs.next()) {
			String a = rs.getString("Amount");
			int caa = Integer.parseInt(a);
			int total = caa - val;
			String newAmount = Integer.toString(total);
			String insert = "UPDATE BankManagementSystem.Transaction SET Amount = '"+newAmount+"', Last_Transaction= '"+last+"', Date='"+date+"' WHERE Card_Number = '"+num+"'";
			s.executeUpdate(insert);
			c.close();
			s.close();
		}
	}catch(SQLException e) {
		System.out.println(e);
	}
}
public static void changePin(String pin, String card) {
	String base = "jdbc:mysql://localhost:3307";
	String user = "root";
	String pass = "";
	String p = pin;
	String num = card;
	try {
		Connection c = DriverManager.getConnection(base,user,pass);
		Statement s = c.createStatement();
		String insert = "UPDATE BankManagementSystem.Account_Details SET Pin = '"+p+"' WHERE Card_Number = '"+num+"'";
		s.executeUpdate(insert);
		c.close();
		s.close();
	}catch(SQLException e) {
		System.out.println(e);
	}
	
}


}
