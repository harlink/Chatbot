package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and messing with strings
 * 
 * @author hpre8409
 * @version 1.2 10/10/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	private boolean stringLengthChecker;

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
		this.name = name;
		chatCount = 0;
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
	public String processText(String currentInput)
	{
		String result = "";

		int randomPosition = (int) (Math.random() * 3);
		if (currentInput != null)
		{

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

			} else if (randomPosition == 1)
			{
				if (memeChecker(currentInput))
				{
					result = "you know their secret³";
				} else
				{
					result = "i think thats one 2 l3ss than the secret";

				}
			} else
			{
				// i heared you like if loops so i nested a few ifs in another if
				if (memeChecker(currentInput))
				{
					result = "Wow! " + currentInput + " is like totally a meme! ";
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
					if(currentInput.equalsIgnoreCase("half life"))
					{
						result = "one day Gaben will count too 3 and we will all be happy ";
					}
					if(currentInput.equalsIgnoreCase("Valve"))
					{
						result ="I had a dream that one day that valve and valves children will be able to count to the 3 and everyone will be happy";
					}
					
				} else
				{
					result = "not a meme, try again";
				}
			}
		}
		else
		{
			result = "Waht did you just say about me mum m8? i'll jab you in the gabber m8";
		}

		return result;
	}

	private void updateChatCount()
	{
		chatCount++;
	}
	
	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;
		
		if(input.length() >= 25)
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
