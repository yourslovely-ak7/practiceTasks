package query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDataBase {
	
	private static final String URL = "jdbc:mysql://localhost:3306/netBanking";
    private static final String USER = "athi-pt7617";
    private static final String PASSWORD = "root";

    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
