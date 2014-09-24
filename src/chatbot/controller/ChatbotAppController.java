package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView applicationView;
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
	
	}
	
	public void start()
	{
		String result = applicationView.showChatbot("idk");
		
		if (result.equalsIgnoreCase("exit"))
		{
			quit();
		}
	}
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "-How could this happen to me plays in your head as you say- Goodbye cruel world");
		System.exit(0);
	}
}
