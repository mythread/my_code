package etp.note.dao ;

import java.util.* ;
import etp.note.vo.* ;

public interface NoteDAO
{
	// 增加操作
	public void insert(Note note) throws Exception ;
	// 修改操作
	public void update(Note note) throws Exception ;
	// 删除操作
	public void delete(int id) throws Exception ;
	// 按ID查询，主要为更新使用
	public Note queryById(int id) throws Exception ;
	// 查询全部
	public List queryAll() throws Exception ;
	// 模糊查询
	public List queryByLike(String cond) throws Exception ;
};