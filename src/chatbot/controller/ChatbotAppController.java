package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot myFreemanBot;
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		myFreemanBot = new Chatbot("Gordan Freeman");
	}
	
	public void start()
	{
		String result = applicationView.showChatbot("Harley");
		
		
		
		while (!myFreemanBot.quitChecker(result))
		{
			result = applicationView.showChatbot(result);
			
		}
			quit();
		
		
	}
	
	
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "-How could this happen to me plays in your head as you say- Goodbye cruel world");
		System.exit(0);
	}
}
