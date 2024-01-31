package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMainPro {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//view the record
	Scanner in=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url,"root","123456");
	int choice;

	while(true) {
		intro();
	System.out.println("Enter your Choice:");
	choice=in.nextInt();
	switch(choice) {
	case 1: System.out.println("*****    *****     *****           ****");
			System.out.println("***      insert record           ***** ");
			System.out.println("*****    *****     *****           ****");;
			insert();
		break;
	case 2:System.out.println("*****    *****     *****           ****");
			System.out.println("****       edit record           ***** ");
			System.out.println("*****    *****     *****           ****");				edit();
		break;
	case 3:System.out.println("*****    *****     *****           ****");
				System.out.println("****      view record           ***** ");
				System.out.println("*****    *****     *****           ****");
						view();
		break;
	case 4:System.out.println("*****    *****     *****           ****");
					System.out.println("$$$$       delete record           $$$$$$$ ");
					System.out.println("*****    *****     *****           ****");
						delete();
		break;
	case 5:System.exit(0);	
	    
	}
}	
}
	public static void view() throws SQLException
			{String url1="jdbc:mysql://localhost:3306/sms_db";
			Connection con1=DriverManager.getConnection(url1,"root","123456");
			Statement st=con1.createStatement();
			ResultSet rs=st.executeQuery("select * from student_info");
			System.out.println("|ID| Name |STD |FAHER | Mpbile |");
			System.out.println("_____________________________________________________");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" |"+rs.getString(2)+"| "+rs.getString(3)+"| "+rs.getString(4)+"| "+rs.getString(5));
			
			}
		}
			
	public static void delete() throws SQLException {
		String url2="jdbc:mysql://localhost:3306/sms_db";

		Connection con2=DriverManager.getConnection(url2,"root","123456");
		
		String query="DELETE FROM student_info WHERE id=?";
		PreparedStatement ps=con2.prepareStatement(query);
		Scanner s=new Scanner(System.in);
		System.out.println("Select ID to DELET");
		int id=s.nextInt();
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Record data deleted susccessfuly");
		view();
		
		}
		
		public static void intro() {
			System.out.println("*****    *****     *****           ****");		
			System.out.println("*    STUDENTS MODULE     *");
			System.out.println("*****    *****     *****           ****");			
			System.out.println("\n 1. Insert");
			System.out.println("\n 2. Edit");
			System.out.println("\n 3. View");
			System.out.println("\n 4. Delete");
			System.out.println("\n 5. Stop");
			System.out.println("*****    *****     *****           ****");
			
		}
		public static void edit() throws SQLException {
			String url4="jdbc:mysql://localhost:3306/sms_db";
		
			Connection con4=DriverManager.getConnection(url4,"root","123456");
			view();
			String query="UPDATE student_info SET name=? ,std = ?,fname=?,mobile=? WHERE (id =?);";
			PreparedStatement ps=con4.prepareStatement(query);
			Scanner s=new Scanner(System.in);
			System.out.println("Enter id:");
			int i=s.nextInt();
			s.nextLine();
			System.out.println("Enter your Name");
			String n=s.nextLine();
			System.out.println("Enter your class");
			String c=s.nextLine();
			System.out.println("enter your father name");
			String f=s.nextLine();
			System.out.println("Enter your mobile no");
			String m=s.nextLine();
			
			ps.setString(1,n);
			ps.setString(2,c);
			ps.setString(3,f);
			ps.setString(4,m);
			ps.setInt(5,i);
			ps.executeUpdate();
			System.out.println("Data edited Suucessfully....");
}
    public static void insert() throws SQLException {
	Scanner s=new Scanner(System.in);

	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url,"root","123456");

	System.out.println("Enter your Name");
	String n=s.nextLine();
	System.out.println("Enter your class");
	String c=s.nextLine();
	System.out.println("enter your father name");
	String f=s.nextLine();
	System.out.println("Enter your mobile no");
	String m=s.nextLine();

	String query="insert into student_info(name,std,fname,mobile)"+"value(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,n);
	ps.setString(2,c);
	ps.setString(3,f);
	ps.setString(4,m);

	ps.executeUpdate();
	System.out.println("Data inserted Suucessfully....");
}
}
