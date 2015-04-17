package etp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

import etp.pojo.UserInfo;


/**
 * @author helinxfy 2010
 */

public class UserInfoDao {
	private Properties p = new Properties();
	public UserInfoDao()
	{		
		try {
			p.load(DataBaseConnection.class.getResourceAsStream(Constants.UserInfoSqlPath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean findUserByUsername(UserInfo u)
	{
		boolean result;
		DataBaseConnection db=new DataBaseConnection();
		Connection conn=db.getConnection();
		PreparedStatement pst;
		String password=null;
		try {
			String sql1=p.getProperty("sql1");
			System.out.println(sql1);
			pst = conn.prepareStatement(p.getProperty("sql1"));
			pst.setString(1, u.getUsername());;
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				password=rs.getString(1);
			}
			if(u.getPassword().equals(password))
				result=true;
			else
				result=false;
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
