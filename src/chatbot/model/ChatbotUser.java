package chatbot.model;

public class ChatbotUser
{
	private String userName;
	private int age;
	private boolean hasTakis;
	private boolean	hasArizonaAddiction;
	private int weight;

	public ChatbotUser()
	{
		this.userName = "";
		this.age = -999;
		this.hasTakis = false;
		this.hasArizonaAddiction = false;
		this.weight = 45;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	// wonderful wording, is... has..
	public boolean isHasTakis()
	{
		return hasTakis;
	}

	public void setHasTakis(boolean hasTakis)
	{
		this.hasTakis = hasTakis;
	}

	public boolean ishasArizonaAddiction()
	{
		return hasArizonaAddiction;
	}

	public void sethasArizonaAddiction(boolean hasArizonaAddiction)
	{
		this.hasArizonaAddiction = hasArizonaAddiction;
	}
	public int getWeight()
	{
		return weight;
	}
}
