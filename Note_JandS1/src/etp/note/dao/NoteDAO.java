package etp.note.dao ;

import java.util.* ;
import etp.note.vo.* ;

public interface NoteDAO
{
	// ���Ӳ���
	public void insert(Note note) throws Exception ;
	// �޸Ĳ���
	public void update(Note note) throws Exception ;
	// ɾ������
	public void delete(int id) throws Exception ;
	// ��ID��ѯ����ҪΪ����ʹ��
	public Note queryById(int id) throws Exception ;
	// ��ѯȫ��
	public List queryAll() throws Exception ;
	// ģ����ѯ
	public List queryByLike(String cond) throws Exception ;
};