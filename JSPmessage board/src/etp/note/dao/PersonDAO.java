package etp.note.dao;

import etp.note.vo.* ;

public interface PersonDAO
{
	// ×öµÇÂ½ÑéÖ¤
	public boolean login(Person person) throws Exception ;
	//×¢²á
	public void reg(Person person)throws Exception;
};