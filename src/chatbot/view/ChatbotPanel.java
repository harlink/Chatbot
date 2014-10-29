package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;

	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	Color orange = new Color(255, 89, 0);
	private JLabel label;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		firstButton = new JButton("click this if you dare");
		firstTextField = new JTextField(25);
		firstTextField.setEnabled(true);
		baseLayout = new SpringLayout();
		chatPane = new JScrollPane(chatArea);
		chatArea = new JTextArea(5, 20);

		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}

	private void setupPanel()
	{

		this.setBackground(orange);
		this.setSize(600, 600);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		
		label = new JLabel("yo dawg");
		add(label);
		this.add(chatPane);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -6, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, -1, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -13, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 562, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 112, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, label, 80, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, label, -80, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		firstTextField.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				label.setText(firstTextField.getText());
				firstTextField.setText("");
			}
		});
		
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				label.setText(firstTextField.getText());
				firstTextField.setText("");
			}
		});
	}
}