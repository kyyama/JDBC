package com.dayone;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JdbcDemo1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			st=con.createStatement();
			int x=st.executeUpdate("insert into persons values (6, 'var', 'dobdapati', '10358 conser street', 'vijayawada')");
			if(x>0) {
				System.out.println(x+"rows effected");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
