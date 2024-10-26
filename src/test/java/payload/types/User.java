package payload.types;

public class User 
{
	private int id;
	private int subjectId;
	private String firstName;
	private String lastName;
	private String language;
	
	public User() {};
	
	public User(int id, int subjectId, String firstName, String lastName, String language )
	{ 
		this.id=id;
		this.subjectId=subjectId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.language=language;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getSubjectId()
	{
		return subjectId;
	}
	public void setSubjectId(int subjectId)
	{
		this.subjectId=subjectId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	public String getLanguage()
	{
		return language;
	}
	public void setLanguage(String language)
	{
		this.language=language;
	}
	
	public String toString()
	{
		return "User {id=" +id+ ",subjectId=" +subjectId+ ",firstName=" +firstName+
				",lastName=" +lastName+ ",language=" +language+ "}";
	}

}
