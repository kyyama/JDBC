package com.dayone;
import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.db.MyConnection;

public class JdbcDemo5 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;

		DataInputStream ds = new DataInputStream(System.in);

		try {
			con = MyConnection.getConnection();
			st = con.createStatement();

			System.out.print("Enter persons ID:");
			String personID = ds.readLine();

			String query = "Select * from persons where personID='" + personID +"' ";

			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + " " + rs.getString(3) + "  "
						+ rs.getString(4) + "  " + rs.getString(5));
			} else {
				System.out.println("record not found");
			}

		} catch (Exception e) {
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
