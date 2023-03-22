package com.dayone;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.db.MyConnection;

import java.sql.Connection;

public class JdbcDemo4 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;// it can be used to perform multiple different quaries
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String choice;

		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement("insert into persons  values (?,?,?,?,?)");

			do {
				System.out.println("Enter id:");
				int personsid = sc.nextInt();
				pst.setInt(1, personsid);

				System.out.println("Enter firstname:");
				String FirstName = sc.next();
				pst.setString(2, FirstName);

				System.out.println("Enter lastName:");
				String LastName = sc.next();
				pst.setString(3, LastName);

				System.out.println("Enter address:");
				String address = sc.next();
				pst.setString(4, address);

				System.out.println("Enter city:");
				String city = sc.next();
				pst.setString(5, city);

				int x = pst.executeUpdate();
				if (x > 0)
					System.out.println(x + "rows are updated");
				System.out.println("do you want more (y/n)?");
				choice = sc.next();

			} while (choice.equalsIgnoreCase("Y"));

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
