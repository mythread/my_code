package etp.note.factory ;

import etp.note.dao.* ;
import etp.note.dao.impl.* ;

public class DAOFactory
{
	public static PersonDAO getPersonDAOInstance()
	{
		return new PersonDAOImpl() ;
	}

	public static NoteDAO getNoteDAOInstance()
	{
		return new NoteDAOImpl() ;
	}
};