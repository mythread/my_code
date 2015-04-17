package call.function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

/**
 * @author ZXC 2012
 */

public class CallGETSTRING {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String DBDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "123";
		Connection conn = null;
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT GETSTRING FROM dual");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
