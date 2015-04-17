package etp.note.dao.impl;

import java.sql.* ;
import java.util.Properties;

import etp.note.jdbc.Constants;
import etp.note.jdbc.DataBaseConnection;
import etp.note.vo.* ;
import etp.note.dao.* ;

public class PersonDAOImpl implements PersonDAO
{
	private Properties p = new Properties();
	public PersonDAOImpl()
	{
		try {
			p.load(DataBaseConnection.class.getResourceAsStream(Constants.SqlPath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
		功能：
			· 判断是否是正确的用户名或密码
			· 从数据库中取出用户的真实姓名
	*/
	public boolean login(Person person) throws Exception
	{
		boolean flag = false ;
		String sql =p.getProperty("sql1") ;
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,person.getId()) ;
			pstmt.setString(2,person.getPassword()) ;
			ResultSet rs = pstmt.executeQuery() ;
			if(rs.next())
			{
				flag = true ;
				person.setName(rs.getString(1)) ;
			}
			rs.close() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			throw new Exception("操作出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
		
		return flag ;
	}
	/*
	 * @see etp.note.dao.PersonDAO#reg(etp.note.vo.Person)
	 */
	public void reg(Person person) throws Exception {
		//sql8=INSERT INTO PERSON VALUES(?,?,?)
		String sql =p.getProperty("sql8") ;
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,person.getId()) ;
			pstmt.setString(2,person.getName()) ;
			pstmt.setString(3,person.getPassword()) ;
			pstmt.executeUpdate();
			pstmt.close() ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbc.close() ;
		}
	}
};