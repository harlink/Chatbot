package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;


/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * @author hpre8409
 * @version 1.2 10/2/14
 */
public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot myFreemanBot;
	private String startMessage;
	private String quitMessage;
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		myFreemanBot = new Chatbot("Gordan Freeman");
		startMessage = "Welcome to the " + myFreemanBot.getName() + " chatbot. What is your name?";
		quitMessage = "-How could this happen to me plays in your head as you say- Goodbye cruel world";
	}
	
	public Chatbot getMyFreemanBot()
	{
		return myFreemanBot;
	}
	
	public void start()
	{
		String result = applicationView.showChatbotDialog(startMessage);
		
		while (!myFreemanBot.quitChecker(result))
		{
			result = myFreemanBot.processText(result);
			result = applicationView.showChatbotDialog(result);
			
		}
		quit();
		
	}
	
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
}
