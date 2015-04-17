package com.etp.stu.commom.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2012, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2012-03-28	WXIBM			zxc						create
 */
public class DBConnection {
	private final static String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final static String USERID = "usermngr";
	private final static String PWD = "123";
	private Connection conn;
	private PreparedStatement prepstmt;
	private Statement stmt;

	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>构造方法，默认创建一个数据库连接<br>
	 * 并在内部生成一个Statement对象</dd>
	 * </dl>
	 */
	public DBConnection() {
		getConn();
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>构造方法，默认创建一个数据库连接<br>
	 * 并使用参数传入的SQL语句，创建一个PreparedStatement对象
	 * </dd>
	 * </dl>
	 * @param sql
	 */
	public DBConnection(String sql) {
		getConn();
		try {
			prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>私有方法，创建一个数据库连接
	 * 并设置回滚点</dd>
	 * </dl>
	 */
	private void getConn() {
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(URL, USERID, PWD);
			// 禁止自动提交
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>得到Connection对象</dd>
	 * </dl>
	 * @return Connection
	 */
	public Connection getConnection() {
		return conn;
	}
	
	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>向数据库提交所有改变</dd>
	 * </dl>
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		conn.commit();
	}
	
	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>回滚到初始状态</dd>
	 * </dl>
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		conn.rollback();
	}

	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>使用PreparedStatement对象处理传入的SQL语句</dd>
	 * </dl>
	 * @param sql
	 * @throws SQLException
	 */
	public void prepareStatement(String sql) throws SQLException {
		prepstmt = conn.prepareStatement(sql);
	}

	public void setString(int index, String value) throws SQLException {
		prepstmt.setString(index, value);
	}

	public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}

	public void setBoolean(int index, boolean value) throws SQLException {
		prepstmt.setBoolean(index, value);
	}

	public void setDate(int index, Date value) throws SQLException {
		prepstmt.setDate(index, value);
	}

	public void setLong(int index, long value) throws SQLException {
		prepstmt.setLong(index, value);
	}

	public void setFloat(int index, float value) throws SQLException {
		prepstmt.setFloat(index, value);
	}

	public void setBinaryStream(int index, InputStream in, int length)
			throws SQLException {
		prepstmt.setBinaryStream(index, in, length);
	}

	public void clearParameters() throws SQLException {
		prepstmt.clearParameters();
	}

	public PreparedStatement getPreparedStatement() {
		return prepstmt;
	}

	public Statement getStatement() {
		return stmt;
	}

	/**
	 * 执行Statement查询语句
	 * 
	 * @param sql
	 * @return ArrayList
	 * @throws Exception
	 */
	public ArrayList<HashMap<Object, Object>> executeQuery(String sql) throws Exception {
		if (stmt != null) {
			return this.convertResultSetToArrayList(stmt.executeQuery(sql));
		} else {
			return null;
		}
	}

	/**
	 * 执行PreparedStatement查询语句
	 * 
	 * @return ArrayList
	 * @throws Exception
	 */
	public ArrayList<HashMap<Object, Object>> executeQuery() throws Exception {
		if (prepstmt != null) {
			return this.convertResultSetToArrayList(prepstmt.executeQuery());
		} else {
			return null;
		}
	}
	
	/**
	 * 执行PreparedStatement查询语句
	 * 返回一个ResultSet对象
	 * 
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet executeQueryResultSet() {
		ResultSet resultSet = null;
		return resultSet;
	}

	/**
	 * 执行Statement更改语句
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public void executeUpdate(String sql) throws SQLException {
		if (stmt != null)
			stmt.executeUpdate(sql);
	}

	/**
	 * 执行PreparedStatement更改语句
	 * 
	 * @throws SQLException
	 */
	public void executeUpdate() throws SQLException {
		if (prepstmt != null)
			prepstmt.executeUpdate();
	}

	/**
	 * 转换记录集对象为数组列表对象
	 * 
	 * @param rs
	 * @return ArrayList
	 * @throws Exception
	 */
	private ArrayList<HashMap<Object, Object>> convertResultSetToArrayList(
			ResultSet rs) throws Exception {
		// 获取rs 集合信息对象
		ResultSetMetaData rsmd = rs.getMetaData();
		// 创建数组列表集合对象
		ArrayList<HashMap<Object, Object>> tempList = new ArrayList<HashMap<Object, Object>>();
		HashMap<Object, Object> tempHash = null;
		// 填充数组列表集合
		while (rs.next()) {
			// 创建键值对集合对象
			tempHash = new HashMap<Object, Object>();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				// 遍历每列数据，以键值形式存在对象tempHash中
				tempHash.put(rsmd.getColumnName(i + 1).toUpperCase(), rs
						.getString(rsmd.getColumnName(i + 1)));
			}
			// 第一个键值对，存储在tempList列表集合对象中
			tempList.add(tempHash);
		}
		return tempList;// 返回填充完毕的数组列表集合对象
	}

	/**
	 * 关闭连接
	 */
	public void close() {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (prepstmt != null) {
				prepstmt.close();
				prepstmt = null;
			}
			conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}