package com.dayone;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.MyConnection;

import java.sql.Connection;

public class JdbcDemo2 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = MyConnection.getConnection();
			st = con.createStatement();

			rs = st.executeQuery("select * from persons");

			while (rs.next()) {
				System.out.println("id:   " + "  " + rs.getInt(1));
				System.out.println("firstname:" + "  " + rs.getString(2));
				System.out.println("lastname:" + " " + rs.getString(3));
				System.out.println("address:" + " " + rs.getString(4));
				System.out.println("city:" + "  " + rs.getString(5));

			}

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
