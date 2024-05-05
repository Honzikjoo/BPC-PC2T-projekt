package projekt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconn {



	  private static volatile Connection conn;

	  private sqlconn() {}

	  public static Connection getConn() {
	    if (conn == null) {
	      synchronized (sqlconn.class) {
	        if (conn == null) {
	          try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unisoft","root","root");
	          } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	          }
	        }
	      }
	    }
	    return conn;
	  }

	  public static void disConn() {
	    try {
	      conn.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }



}
