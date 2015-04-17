package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zxc
 */
public class Task3 {
	public static void main(String[] args) {

		// Connection 对象
		Connection connection = null;

		// PreparedStatement 对象
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;

		// ResultSet 对象
		ResultSet rs = null;
		ResultSet rs1 = null;

		// 查找驱动类，此操作会抛出异常，需要捕获
		try {
			// oracle的驱动类路径
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 获得与oracle数据库操作的statement，此操作会抛出异常
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "scott", "123");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// 控制台输入用户名字中的关键字
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name, id, sal;

		// 获得与oracle数据库操作的prepareStatement
		// 此操作会抛出异常
		try {
			System.out.println("请输入員工姓名：");
			name = br.readLine();
			System.out.println("请输入員工ID：");
			id = br.readLine();
			System.out.println("请输入員工工資：");
			sal = br.readLine();
			statement = connection
					.prepareStatement("insert into emp(empno,ename,sal) values("+ id + "," + name + "," + sal + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 使用statement对象执行sql查询语句，此操作会抛出异常
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		// 获得与oracle数据库操作的prepareStatement
		// 此操作会抛出异常
		try {
			statement1 = connection.prepareStatement("select * from emp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 使用statement对象执行sql查询语句，此操作会抛出异常
		try {
			rs1 = statement1.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		

		// 遍历结果集，此操作会抛出异常
		try {
			System.out.println("EMPNO" + "	 ENAME" + "	 JOB" + "		MGR"
					+ "	HIREDATE" + "		SAL" + "	COMM" + "	DEPTNO");
			while (rs1.next()) {
				System.out.print(rs1.getString(1));
				System.out.print("	 " + rs1.getString(2));
				System.out.print("	 " + rs1.getString(3));
				System.out.print("  	" + rs1.getInt(4));
				System.out.print("	" + rs1.getString(5));
				System.out.print("	" + rs1.getInt(6));
				System.out.print("	" + rs1.getInt(7));
				System.out.println("	" + rs1.getInt(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 关闭所有连接，此操作会抛出异常
		try {
			rs1.close();
			rs.close();
			statement.close();
			statement1.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 设置所有对象为null
		rs = null;
		statement = null;
		connection = null;

	}
}
