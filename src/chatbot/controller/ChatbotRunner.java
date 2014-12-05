package chatbot.controller;

public class ChatbotRunner
{
/**
 * runs the chatbot when this is started
 * @param args
 */
	public static void main(String [] args)
	{
		ChatbotAppController appController = new ChatbotAppController();
		appController.start();
	}

}
