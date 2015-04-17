package homework;

/**
 * @author zxc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEMP {

	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>主方法</dd>
	 * </dl>
	 */
	public static void main(String[] args) {
		// Connection 对象
		Connection connection = null;

		// PreparedStatement 对象
		PreparedStatement statement = null;

		// 结果集对象
		ResultSet rs = null;

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

		// 获得与oracle数据库操作的prepareStatement
		// 此操作会抛出异常
		try {
			statement = connection.prepareStatement("SELECT * FROM EMP");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 使用statement对象执行sql查询语句，此操作会抛出异常
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 遍历结果集，此操作会抛出异常
		try {
			System.out.println("EMPNO" + "	 ENAME" + "	 JOB" + "		MGR"
					+ "	HIREDATE" + "		SAL" + "	COMM" + "	DEPTNO");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print("	 " + rs.getString(2));
				System.out.print("	 " + rs.getString(3));
				System.out.print("  	" + rs.getInt(4));
				System.out.print("	" + rs.getString(5));
				System.out.print("	" + rs.getInt(6));
				System.out.print("	" + rs.getInt(7));
				System.out.println("	" + rs.getInt(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 关闭所有连接，此操作会抛出异常
		try {
			rs.close();
			statement.close();
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