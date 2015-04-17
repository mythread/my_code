package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleOCIConnectionPool;

/**
 * @author ZXC 2012
 */

public class JDBC {
	/*
	 * jdbc:表示采用jdbc方式连接数据库
	 * oracle:表示连接的是oracle数据库
	 * oracle中有两种模式
	 * 1 thin:默认连接池
	 * 2 oci:自定义连接池
	 */
	public static void main(String[] args) {
		String DBDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "123";
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		//thin模式
		
	/*	try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			System.out.println(e);
		}
		*/
		
		//oci 模式
	
		try {
			Class.forName(DBDriver);
			OracleOCIConnectionPool ods = new OracleOCIConnectionPool();
			 String tns = "(DESCRIPTION=(ADDRESS_LIST=(ADDRESS="
	                + "(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))"
	                + "(CONNECT_DATA=(SERVICE_NAME=ORCL)))";
	        ods.setURL("jdbc:oracle:oci:@" + tns);
	        ods.setUser(user);
	        ods.setPassword(pwd);
	        java.util.Properties jup = new java.util.Properties();	
	        jup.setProperty(OracleOCIConnectionPool.CONNPOOL_MIN_LIMIT, "2");       
	        jup.setProperty(OracleOCIConnectionPool.CONNPOOL_MAX_LIMIT, "2");
	        jup.setProperty(OracleOCIConnectionPool.CONNPOOL_INCREMENT, "0");
	        ods.setPoolConfig(jup);
	        conn = ods.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();
			//stmt.execute("create table b(aaa int)");
			//stmt.executeUpdate("insert into b values(1)");
			rs = stmt.executeQuery("select * from emp");
			System.out.println("员工号\t姓名");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t"+rs.getString("ename"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
