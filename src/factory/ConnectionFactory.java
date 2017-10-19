package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost:3306/patientsapp";
	static final String USER = "root";
    static final String PASS = "123";
    private static Connection con;
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
    	if(con!=null)
    		return con;
      try {
    	  Class.forName(JDBC_DRIVER);
          con = DriverManager.getConnection(DB_URL, USER, PASS);
          return con;
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }catch(Exception ex){
    	  throw new RuntimeException("Error connecting to the database", ex);
      }
    }
}
