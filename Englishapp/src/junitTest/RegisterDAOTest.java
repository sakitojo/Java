package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.IDatabaseConnection;
import org.junit.jupiter.api.Test;

import com.sun.corba.se.pept.transport.Connection;

import dao.RegisterDAO;
import model.Account;

class RegisterDAOTest {

	IDatabaseConnection connection = null;

	@Test
	void testCreate(Account account) {

		RegisterDAO dao = new RegisterDAO();

		try {
			final String JDBC_URL = "jdbc:mysql://localhost/english?serverTimezone=JST&useSSL=false";
			final String DB_USER = "root";
			final String DB_PASS = "root";
			final String drv = "com.mysql.cj.jdbc.Driver";

			Class.forName(drv);
			java.sql.Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
	}

}
