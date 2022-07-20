package businessClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * @author HamizahYusni
 */
public class DbController {
		
	private String databaseName = "kioskappdb_dev";
	private String username = "root";
	
	private String connectionPath = "jdbc:mysql://localhost/" + databaseName + "?" +
            "user=" + username;
	
	/**
	 * This method establish connection to RDBMS
	 * @return connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		// Load database driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Get connection object from the database
		Connection connection = DriverManager.getConnection(connectionPath);
		
		return connection;
		
	}
		
}