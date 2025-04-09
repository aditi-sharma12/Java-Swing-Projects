import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class RockPaperScissors extends JFrame
{
	JLabel L1,L2,L3;
	JButton B1,B2,B3;
	int computerScore = 0;	
	int playerScore = 0;
	public static final String[] choice = {"Rock", "Paper", "Scissor"};
	Random random = new Random();

	RockPaperScissors(String s1)
	{
		super(s1);
	}
	void setComponents()
	{
		L1 = new JLabel("Computer : "+ computerScore);
		L2 = new JLabel("?");
		L3 = new JLabel("Player : "+ playerScore);
		B1 = new JButton("Rock");
		B2 = new JButton("Paper");
		B3 = new JButton("Scissor");

		setLayout(null);
		add(L1);
		add(L2);
		add(L3);
		add(B1);
		add(B2);
		add(B3);

		L1.setBounds(145,70,450,30);
		L1.setFont(new Font("Dialog", Font.PLAIN, 26));
		L2.setBounds(165,150,98,81);
		L2.setFont(new Font("Dialog", Font.PLAIN, 26));
		L2.setHorizontalAlignment(SwingConstants.CENTER);
		L2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		L3.setBounds(155,300,450,30);
		L3.setFont(new Font("Dialog", Font.PLAIN, 26));
		B1.setBounds(40,387, 105,81);
		B1.setFont(new Font("Dialog", Font.PLAIN, 18));
		B2.setBounds(165,387,105,81);
		B2.setFont(new Font("Dialog", Font.PLAIN, 18));
		B3.setBounds(290,387,105,81);
		B3.setFont(new Font("Dialog", Font.PLAIN, 18));

		B1.addActionListener(new MoveHandler("Rock"));
		B2.addActionListener(new MoveHandler("Paper"));
		B3.addActionListener(new MoveHandler("Scissor"));
	}

	public static void main(String []args)
	{
		RockPaperScissors R1 = new RockPaperScissors("Rock-Paper-Scissors");
        	R1.setSize(450, 574);
		R1.setVisible(true);
		R1.setComponents();
        	R1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MoveHandler implements ActionListener
	{
		String playerMove;
		MoveHandler(String move)
		{
			this.playerMove = move;
		}

		public void actionPerformed(ActionEvent e)
		{
			String computerMove = choice[random.nextInt(choice.length)];
			L2.setText(computerMove);
			if(computerMove.equals(playerMove))
			{
				JOptionPane.showOptionDialog(null, "Draw", "Result", JOptionPane.DEFAULT_OPTION, 
                                     JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Try Again"}, "Try Again");
			}
			else if((playerMove.equals("Rock") && computerMove.equals("Scissor")) ||
				(playerMove.equals("Paper") && computerMove.equals("Rock")) ||
				(playerMove.equals("Scissor") && computerMove.equals("Paper")) )
			{	
				playerScore++;
				L3.setText("Player : " + playerScore);
				JOptionPane.showOptionDialog(null, "Player Wins", "Result", JOptionPane.DEFAULT_OPTION, 
                                     JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Try Again"}, "Try Again");
			}
			else
			{
				computerScore++;
				L1.setText("Computer : " + computerScore);
				JOptionPane.showOptionDialog(null, "Comupter Wins", "Result", JOptionPane.DEFAULT_OPTION, 
                                     JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Try Again"}, "Try Again");
			}
		}	
	}
}
