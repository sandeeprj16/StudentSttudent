package com.tyss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fetch {

    public static void main(String[] args) {

        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/01-student-CRUD";
        String user = "postgres";
        String password = "root";

        String sql = "SELECT * FROM student";

        try {
            // 1. Load Driver
            Class.forName(driver);

            // 2. Create Connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection created");

            // 3. Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("PreparedStatement created");

            // 4. Execute Query
            ResultSet rs = ps.executeQuery();

            System.out.println("----------Students--------------");

            // 5. Process ResultSet
            while (rs.next()) {
                System.out.println("Id   : " + rs.getInt("id"));
                System.out.println("Name  : " + rs.getString("name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Phone : " + rs.getLong("phone"));
                System.out.println("====================");
            }

            // 6. Close Connection
            con.close();
            System.out.println("Record fetched and connection closed");

        }catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
