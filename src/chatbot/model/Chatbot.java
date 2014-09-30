package chatbot.model;


/**
 * The chatbot model class. Used for checking and messing with strings
 * @author hpre8409
 * @version 1.1 9/30/14
 */
public class Chatbot
{
	//private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	
	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats
	 * @param name The name for Chatbot
	 */
	public Chatbot(String name)
	{
		this.name = name;
		chatCount = 0;
		
	}
	
	/**
	 * Returns the name of the Chatbot object.
	 * @return The current name of the Chatbot
	 */
	
	public String getName()
	{
		return name;
	}
	
	public int getChatCount()
	{
		return chatCount;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	private void updateChatCount()
	{
		chatCount++;
	}
	
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("Go die"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
	
	//remember Alt 0179 = exponent 3 ³
}
