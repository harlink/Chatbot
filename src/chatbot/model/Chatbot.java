package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and messing with strings
 * 
 * @author Harley Prelip
 * @version 1.4 11/11/14 Updated ProcessText and added a checker.
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	private boolean stringLengthChecker;
	private ChatbotUser myUser;
	private ArrayList<String> userInputList;

	/**
	 * Creates a Chatbot object with the supplied name and initializes the
	 * current number of chats
	 * 
	 * @param name
	 *            The name for Chatbot
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		myUser = new ChatbotUser();
		
		fillTheMemeList();
	}

	/**
	 * Returns the name of the Chatbot object.
	 * 
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

	public ChatbotUser getMyUser()
	{
		return myUser;
	}

	public void setMyUser(ChatbotUser myUser)
	{
		this.myUser = myUser;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * fills the meme list with some basic memes
	 */
	private void fillTheMemeList()
	{
		
		memeList.add("1v1");
		memeList.add("Half life");
		memeList.add("Sound of silence");
		memeList.add("Oh baby a Triple Kill");
		memeList.add("You don't say?");
		memeList.add("Wot you say m8");
		
	}

	/**
	 * Processes input from the user against the checker methods.
	 *  returns next output for the view
	 * 
	 * @param currentInput
	 * @return The processed text based on the checker or other methods.
	 */
	public String processText(String currentInput)
	{
		String result = "";
		if (getChatCount() < 5)
		{
			
			if (getChatCount() == 0)
			{
				myUser.setUserName(currentInput);
				result = "Good name " + myUser.getUserName() + " how old are you?";
			}
			else if (getChatCount() == 1)
			{
				int userAge = Integer.parseInt(currentInput);
				myUser.setAge(userAge);
			}
			// do the same for other user info fields
		}
		else if (currentInput != null && currentInput.length() > 0)
		{
			int randomPosition = (int) (Math.random() * 6);
			if (randomPosition == 0)
			{
				if (stringLengthChecker(currentInput))
				{
					result = "too long";
				}
				else
				{
					result = "short words";
				}
			}
			else if (randomPosition == 1)
			{
				if (contentChecker(currentInput))
				{
					result = "you know thier secret³";
				}
				else
				{
					result = "i think thats one 2 l3ss than the secret";
				}
			}
			else if (randomPosition == 2)
			{
				// i heared you like if loops so i nested a "few" ifs in another if
				
				if (memeChecker(currentInput))
				{
					result = "Wow, " + currentInput + " is a meme. Wahoo!";
				}
				/**
				 * extra if statements that i put in for specific responses to certain memes
				 */
				if (currentInput.equalsIgnoreCase("Sound of silence"))
				{
					result = "Can you hear the Sound of Silence..?";
				}
				
				if(currentInput.equalsIgnoreCase("Ravenholm"))
				{
					result = "Ravenholm...? we don't go.. to RavenHolm anymore";
				}
				if(currentInput.equalsIgnoreCase("Yo Dawg"))
				{
					result = "Yo Dawg I heard you like mei mei's so I put a meme in yo meme so you can read memes while you read memes";
				}
				if(currentInput.equalsIgnoreCase("Wombo combo"))
				{ 
					result = "WOMBO COMBO THATS NOT FALCO THATS NOT FALCO WOWZA WOW WOOOWZAAA WOW";
				}
				if(currentInput.equalsIgnoreCase("Half life"))
				{
					result = "36 devided by 3 is 12, 12 devided by 4 is 3, a triangle has three sides, iluminati is triangle, valve has 3 continuations being awaited that means half life 3 confirmed ";
				}
				if(currentInput.equalsIgnoreCase("Valve"))
				{
					result ="I had a dream that one day that valve and valves children will be able to count to the 3 and make Half life 3 causing world peace";
				}
				else
				{
					result = "not a meme, try again scrub";
				}
			}
			else if (randomPosition == 3)
			{
				// Talk about the user here
			}
			else if (randomPosition == 4)
			{
				// add to our list
				userInputList.add(currentInput);
				result = "thank you fine citizen thank you for the comment -ps not a cop";
			}
			else
			{
				if (userInputChecker(currentInput))
				{
				}
				else
				{
				}
			}
		}
		else
		{
			result = "use words!!!!";
		}
		updateChatCount();
		return result;
	}// checks what the user input to see if it is relevant
	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;
		for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if (userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}
		return matchesInput;
	}

	private void updateChatCount()
	{
		chatCount++;
	}

	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;
		if (input.length() >= 20)
		{
			isTooLong = true;
		}
		return isTooLong;
	}

	private boolean contentChecker(String input)
	{
		boolean hasContent = false;
		return hasContent;

	}
	// checks to see if users message a meme from meme list
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;
		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}
		for (int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if (input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}
		return isAMeme;
	}

	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equalsIgnoreCase("Go die"))
		{
			okToQuit = true;
		}
		return okToQuit;
	}
}
	// remember Alt 0179 = exponent 3 ³

