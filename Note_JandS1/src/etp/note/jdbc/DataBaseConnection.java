package etp.note.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

public class DataBaseConnection {
	private Connection conn = null;

	// 用于加载DB.properties中的信息，保存在HashMap中并返回
	public static HashMap<String, String> propertiesLoad() {
		Properties p = new Properties();
		try {
			HashMap<String, String> con = new HashMap<String, String>();
			p.load(DataBaseConnection.class.getResourceAsStream(Constants.DBConfigPath));
			con.put(Constants.DBDRIVER, p.getProperty(Constants.DBDRIVER));
			con.put(Constants.DBURL, p.getProperty(Constants.DBURL));
			con.put(Constants.USERNAME, p.getProperty(Constants.USERNAME));
			con.put(Constants.PASSWORD, p.getProperty(Constants.PASSWORD));
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读入异常！");
			return null;
		}
	}

	// 构造函数完成：加载DB配置信息、初始化连接
	public DataBaseConnection() {
		HashMap<String, String> dbconfig = propertiesLoad();
		if(dbconfig!=null)
		{
		try {
			Class.forName(dbconfig.get(Constants.DBDRIVER));
			conn = DriverManager.getConnection(dbconfig.get(Constants.DBURL), dbconfig
					.get(Constants.USERNAME), dbconfig.get(Constants.PASSWORD));
			//System.out.println("初始化成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else
		{
			//System.out.println("初始化异常！");
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}