package etp.note.dao;

import etp.note.vo.* ;

public interface PersonDAO
{
	// ����½��֤
	public boolean login(Person person) throws Exception ;
	//ע��
	public void reg(Person person)throws Exception;
};