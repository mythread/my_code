package etp.note.dao.impl ;

import java.sql.* ;
import java.util.* ;

import etp.note.jdbc.Constants;
import etp.note.jdbc.DataBaseConnection;
import etp.note.vo.* ;
import etp.note.dao.* ;
import etp.note.jdbc.* ;

public class NoteDAOImpl implements NoteDAO
{
	private Properties p=new Properties();
	public NoteDAOImpl()
	{
		try {
			p.load(DataBaseConnection.class.getResourceAsStream(Constants.SqlPath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 增加操作
	public void insert(Note note) throws Exception
	{
		//sql2=INSERT INTO note(id,title,author,content) VALUES(note_sequ.nextVal,?,?,?)
		String sql = p.getProperty("sql2") ;
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,note.getTitle()) ;
			pstmt.setString(2,note.getAuthor()) ;
			pstmt.setString(3,note.getContent()) ;
			pstmt.executeUpdate() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			// System.out.println(e) ;
			throw new Exception("操作中出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
	}
	// 修改操作
	public void update(Note note) throws Exception
	{
		//sql3=UPDATE note SET title=?,author=?,content=? WHERE id=?
		String sql =p.getProperty("sql3");
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,note.getTitle()) ;
			pstmt.setString(2,note.getAuthor()) ;
			pstmt.setString(3,note.getContent()) ;
			pstmt.setInt(4,note.getId()) ;
			pstmt.executeUpdate() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("操作中出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
	}
	// 删除操作
	public void delete(int id) throws Exception
	{
		//sql4=DELETE FROM note WHERE id=?
		String sql =p.getProperty("sql4") ;
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setInt(1,id) ;
			pstmt.executeUpdate() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			throw new Exception("操作中出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
	}
	// 按ID查询，主要为更新使用
	public Note queryById(int id) throws Exception
	{
		Note note = null ;
		//sql5=SELECT id,title,author,content FROM note WHERE id=?
		String sql = p.getProperty("sql5");
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setInt(1,id) ;
			ResultSet rs = pstmt.executeQuery() ;
			if(rs.next())
			{
				note = new Note() ;
				note.setId(rs.getInt(1)) ;
				note.setTitle(rs.getString(2)) ;
				note.setAuthor(rs.getString(3)) ;
				note.setContent(rs.getString(4)) ;
			}
			rs.close() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			throw new Exception("操作中出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
		return note ;
	}
	// 查询全部
	public List queryAll() throws Exception
	{
		List all = new ArrayList() ;
		//sql6=SELECT id,title,author,content FROM note
		String sql = p.getProperty("sql6");
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			ResultSet rs = pstmt.executeQuery() ;
			while(rs.next())
			{
				Note note = new Note() ;
				note.setId(rs.getInt(1)) ;
				note.setTitle(rs.getString(2)) ;
				note.setAuthor(rs.getString(3)) ;
				note.setContent(rs.getString(4)) ;
				all.add(note) ;
			}
			rs.close() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			System.out.println(e) ;
			throw new Exception("操作中出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
		return all ;
	}
	// 模糊查询
	public List queryByLike(String cond) throws Exception
	{
		List all = new ArrayList() ;
		//sql7=SELECT id,title,author,content FROM note WHERE title LIKE ? or AUTHOR LIKE ? or CONTENT LIKE ?
		String sql =p.getProperty("sql7") ;
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,"%"+cond+"%") ;
			pstmt.setString(2,"%"+cond+"%") ;
			pstmt.setString(3,"%"+cond+"%") ;
			ResultSet rs = pstmt.executeQuery() ;
			while(rs.next())
			{
				Note note = new Note() ;
				note.setId(rs.getInt(1)) ;
				note.setTitle(rs.getString(2)) ;
				note.setAuthor(rs.getString(3)) ;
				note.setContent(rs.getString(4)) ;
				all.add(note) ;
			}
			rs.close() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			System.out.println(e) ;
			throw new Exception("操作中出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
		return all ;
	}
};