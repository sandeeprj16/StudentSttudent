package com.tyss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	private static Connection con;

	public static void main(String[] args) {
		//=====User Value=====
		int id=11;
		String name="Vishal";
		String email="vishal@gmail.com";
		long phone=29753256L;
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Drivers are loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:postgresql://localhost:5432/01-student-CRUD";
		String user="postgres";
		String password="root";
		try {
			 con=DriverManager.getConnection(url,user,password);
			System.out.println("Connection is created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3) Create Statement
		try {
			Statement stm=con.createStatement();
			
			System.out.println("Statement is created");
			String insert="INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(insert);
			
			

			System.out.println("Execute Query");
			//int res = stm.executeUpdate(insert);
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setLong(4, phone);
			System.out.println(ps.executeUpdate() + " record/records inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
			System.out.println("Connection is now closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
