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

	private void fillTheMemeList()
	{
		memeList.add("Yo Dawg");
		memeList.add("1v1");
		memeList.add("Half life");
		memeList.add("Sound of silence");
		memeList.add("Wombo Combo");
		memeList.add("Oh baby a Triple Kill");
		memeList.add("You don't say?");
		memeList.add("Wot you say m8");
		memeList.add("Ravenholm");
		memeList.add("valve");
	}

	/**
	 * Processes input from the user against the checker methods. returns next
	 * output for the view
	 * 
	 * @param currentInput
	 * @return The processed text based on the checker or other methods.
	 */
	public String processText(String currentinput)
	{
		String currentInput = currentinput;
		String result = "daves not here man";
		
		
		if(getChatCount() <  7)
		{
			if(getChatCount() == 0)
			{
				myUser.setUserName(currentinput);
				result = " cool name yo " + myUser.getUserName() + " how old are you?";
			}
			else if(getChatCount() == 1)
			{
				int userAge = Integer.parseInt(currentinput);
				myUser.setAge(userAge);
			}
			//continue for other user input fields
		}

		int randomPosition = (int) (Math.random() * 6);
		if (currentInput != null && currentInput.length() > 0)
		{

			if (randomPosition == 0)
			{
				if (stringLengthChecker(currentInput))
				{
					result = "too long";
				} else
				{
					result = "short words";
				}

			} else if (randomPosition == 1)
			{
				// i heared you like if loops so i nested a few if's in another if
				if (memeChecker(currentInput))
				{
					result = "you know their secret³";
				} else
				{
					result = "i think thats one 2 l3ss than the secret";

				}
				if (currentInput.equalsIgnoreCase("Sound of silence"))
				{
					result = "Can you hear the Sound of Silence..?";
				}

				if (currentInput.equalsIgnoreCase("Ravenholm"))
				{
					result = "Ravenholm...? we don't go.. to RavenHolm anymore";
				}
				if (currentInput.equalsIgnoreCase("Yo Dawg"))
				{
					result = "Yo Dawg I heard you like mei mei's so I put a meme in yo meme so you can read memes while you read memes";
				}
				if (currentInput.equalsIgnoreCase("Wombo combo"))
				{
					result = "WOMBO COMBO THATS NOT FALCO THATS NOT FALCO WOWZA WOW WOOOWZAAA WOW";
				}
				if (currentInput.equalsIgnoreCase("half life"))
				{
					result = "one day Gaben will count too 3 and we will all be happy ";
				}
				if (currentInput.equalsIgnoreCase("Valve"))
				{
					result = "I had a dream that one day that valve and valves children will be able to count to the 3 and everyone will be happy";
				}
			} else if (randomPosition == 2)
			{
				//if(contentChecker(currentInput))
				//{
					//talk about users and stuff
				//}
				//else
				//{
					//talk about the users
				//}
			}else if (randomPosition == 3)
			{
				
			}else if (randomPosition == 4)
			{
				//add to our list
				userInputList.add(currentinput);
				result = "Thanks for le comment m9";
			}else
			{
				if(userInputChecker(currentInput))
				{
					
				}
				else
				{
					
				}
			}
		} else
		{
			result = "Waht did you just say about me mum m8? i'll jab you in the gabber m8";
		}
		updateChatCount();
		return result;
	}
	
	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;
		for(int loopCount =0; loopCount < userInputList.size(); loopCount++)
		{
			if(userInput.equalsIgnoreCase(userInputList.get(loopCount)))
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

		if (input.length() >= 25)
		{
			isTooLong = true;
		}

		return isTooLong;
	}

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

		for (int LoopCounter = 0; LoopCounter < memeList.size(); LoopCounter++)
		{
			if (input.equalsIgnoreCase(memeList.get(LoopCounter)))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equalsIgnoreCase("go die"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}

	// remember Alt 0179 = exponent 3 ³
}
