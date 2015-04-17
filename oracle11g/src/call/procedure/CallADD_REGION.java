package call.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * @author ZXC 2012
 */

public class CallADD_REGION {

	public static void main(String[] args) {
		String DBDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "123";
		Connection conn = null;
		
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(url, user, pwd);
			CallableStatement cstmt=conn.prepareCall( "{call ADD_REGION(?)} "); 
			cstmt.setString(1,"111111111 "); 
			cstmt.registerOutParameter(1,Types.VARCHAR);
			cstmt.execute(); 
			System.out.println("获得存储过程的结果为："+cstmt.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
