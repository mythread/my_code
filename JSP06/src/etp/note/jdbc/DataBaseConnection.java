package etp.note.jdbc;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;

public class DataBaseConnection {
	private Connection conn = null;

	// 构造函数完成：加载DB配置信息、初始化连接
	public DataBaseConnection() {
		try{
			Context initCtx=new InitialContext();
			Context ctx=(Context)initCtx.lookup("java:comp/env");
			Object obj=(Object)ctx.lookup("jdbc/db");
			javax.sql.DataSource ds=(javax.sql.DataSource)obj;
			this.conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
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