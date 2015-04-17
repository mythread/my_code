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
public class FuzzySelect {

	public static void main(String[] args) {

		// Connection ����
		Connection connection = null;

		// PreparedStatement ����
		PreparedStatement statement = null;

		// ResultSet ����
		ResultSet rs = null;

		// ���������࣬�˲������׳��쳣����Ҫ����
		try {
			// oracle��������·��
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// �����oracle���ݿ������statement���˲������׳��쳣
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "scott", "123");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// ����̨�����û������еĹؼ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in;
		System.out.print("������ģ����ѯ�Ĺؼ��֣���Сд���֣���");

		// �����oracle���ݿ������prepareStatement
		// �˲������׳��쳣
		try {
			in = br.readLine();
			statement = connection
					.prepareStatement("select * from emp where ename like UPPER('%"
							+ in + "%')");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// ʹ��statement����ִ��sql��ѯ��䣬�˲������׳��쳣
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ������������˲������׳��쳣
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

		// �ر��������ӣ��˲������׳��쳣
		try {
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// �������ж���Ϊnull
		rs = null;
		statement = null;
		connection = null;

	}
}
