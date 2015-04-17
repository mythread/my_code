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

		// Connection ����
		Connection connection = null;

		// PreparedStatement ����
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;

		// ResultSet ����
		ResultSet rs = null;
		ResultSet rs1 = null;

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
		String name, id, sal;

		// �����oracle���ݿ������prepareStatement
		// �˲������׳��쳣
		try {
			System.out.println("������T��������");
			name = br.readLine();
			System.out.println("������T��ID��");
			id = br.readLine();
			System.out.println("������T�����Y��");
			sal = br.readLine();
			statement = connection
					.prepareStatement("insert into emp(empno,ename,sal) values("+ id + "," + name + "," + sal + ")");
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
		
		
		
		
		
		// �����oracle���ݿ������prepareStatement
		// �˲������׳��쳣
		try {
			statement1 = connection.prepareStatement("select * from emp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ʹ��statement����ִ��sql��ѯ��䣬�˲������׳��쳣
		try {
			rs1 = statement1.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		

		// ������������˲������׳��쳣
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

		// �ر��������ӣ��˲������׳��쳣
		try {
			rs1.close();
			rs.close();
			statement.close();
			statement1.close();
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
