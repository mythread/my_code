package etp.note.vo ;

public class Note
{
	private int id ;
	private String title ;
	private String author ;
	private String content ;

	public void setId(int id)
	{
		this.id = id ;
	}
	public void setTitle(String title)
	{
		this.title = title ;
	}
	public void setAuthor(String author)
	{
		this.author = author ;
	}
	public void setContent(String content)
	{
		this.content = content ;
	}

	public int getId()
	{
		return this.id ;
	}
	public String getTitle()
	{
		return this.title ;
	}
	public String getAuthor()
	{
		return this.author ;
	}
	public String getContent()
	{
		return this.content ;
	}
};