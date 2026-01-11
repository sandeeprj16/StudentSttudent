package com.tyss;

//package com.tyss.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/01-student-CRUD";
		String user = "postgres";
		String password = "root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, password);

			Statement stm = con.createStatement();

			String delete = "DELETE FROM student WHERE id=2";

			stm.execute(delete);

			con.close();

			System.out.println("record deleted and con closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
