package chatbot.model;

import java.util.ArrayList;


/**
 * The chatbot model class. Used for checking and messing with strings
 * @author hpre8409
 * @version 1.1 9/30/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	
	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats
	 * @param name The name for Chatbot
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
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
	
	private void fillTheMemeList()
	{
		memeList.add("Yo Dawg");
		memeList.add("come @ mi");
		memeList.add("Half life³ confirmed");
		memeList.add("can you hear the sound of silence");
		memeList.add("Wombo Combo");
		memeList.add("Oh baby a Triple Kill");
		memeList.add("You don't say?");
	}
	
	/**
	 * Processes input from the user against the checker methods. returns next output for the view
	 * @param currentInput
	 * @return The processed text based on the checker or other methods.
	 */
	public String processText(String currentInput)
	{
		String result = "";
		
		if(memeChecker(currentInput))
		{
			result = "wow, " + currentInput + " is a meme. wahoo!";
		}
		else
		{
			result = "not a meme, try again";
		}
		return result;
	}
	
	
	
	
	
	private void updateChatCount()
	{
		chatCount++;
	}
	
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;
		
		for (String currentMeme : memeList)
		{
			if(input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}
		
		for(int LoopCounter = 0; LoopCounter < memeList.size(); LoopCounter++)
		{
			if(input.equalsIgnoreCase(memeList.get(LoopCounter)))
			{
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("go die"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
	
	//remember Alt 0179 = exponent 3 ³
}
