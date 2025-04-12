import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class passwordGenerator extends JFrame
{
	JLabel L1,L2,L3;
	JTextField T1;
	JButton B1,B2,B3,B4,B5;

	boolean useUppercase = false;
    	boolean useLowercase = false;
    	boolean useNumbers = false;
    	boolean useSymbols = false;

	passwordGenerator(String s1)
	{
		super(s1);
	}
	void setComponents()
	{
		L1 = new JLabel("Password Generator");
		L2 = new JLabel();
		L3 = new JLabel("Password Length : ");
		
		T1 = new JTextField();

		B1 = new JButton("Uppercase");
		B2 = new JButton("Lowercase");
		B3 = new JButton("Numbers");
		B4 = new JButton("Symbols");
		B5 = new JButton("Generate");

		setLayout(null);
		
		add(L1);
		add(L2);
		add(L3);
		add(T1);
		add(B1);
		add(B2);
		add(B3);
		add(B4);
		add(B5);

		L1.setBounds(0, 10, 540, 39);
		L1.setHorizontalAlignment(SwingConstants.CENTER);
		L1.setFont(new Font("Dialog", Font.BOLD, 32));

		L2.setBounds(25, 97, 479, 70);
		L2.setFont(new Font("Dialog", Font.BOLD, 32));
		L2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		L3.setBounds(25, 215, 272, 39);
		L3.setFont(new Font("Dialog", Font.BOLD, 28));

		T1.setBounds(310, 215, 192, 39);
		T1.setFont(new Font("Dialog", Font.PLAIN, 32));
        	T1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		B1.setBounds(25, 302, 225, 56);
		B1.setFont(new Font("Dialog", Font.PLAIN, 26));
		B2.setBounds(282, 302, 225, 56);
		B2.setFont(new Font("Dialog", Font.PLAIN, 26));
		B3.setBounds(25, 373, 225, 56);
		B3.setFont(new Font("Dialog", Font.PLAIN, 26));
		B4.setBounds(282, 373, 225, 56);
		B4.setFont(new Font("Dialog", Font.PLAIN, 26));
		B5.setBounds(155, 477, 222, 41);
		B5.setFont(new Font("Dialog", Font.PLAIN, 26));
		
		B1.addActionListener(new MoveHandler("Uppercase"));
		B2.addActionListener(new MoveHandler("Lowercase"));
		B3.addActionListener(new MoveHandler("Numbers"));
		B4.addActionListener(new MoveHandler("Symbols"));
		B5.addActionListener(new MoveHandler("Generate"));
		
	}

	public static void main(String []args)
	{
		passwordGenerator P1 = new passwordGenerator("Password Generator");
		P1.setSize(540, 570);
		P1.setVisible(true);
		P1.setComponents();
		P1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MoveHandler implements ActionListener 
	{
        	String str;

        	MoveHandler(String s2) 
		{
            		str = s2;
        	}

       		public void actionPerformed(ActionEvent e) 
		{
            		switch (str) 
			{
                		case "Uppercase":
                    		useUppercase = true;
                    		B1.setBackground(useUppercase ? Color.WHITE : null);
                    		break;

                		case "Lowercase":
                    		useLowercase = true;
                    		B2.setBackground(useLowercase ? Color.WHITE : null);
                    		break;

                		case "Numbers":
                    		useNumbers = true;
                    		B3.setBackground(useNumbers ? Color.WHITE : null);
                    		break;

                		case "Symbols":
                    		useSymbols = true;
                    		B4.setBackground(useSymbols ? Color.WHITE : null);
                    		break;

                		case "Generate":
                    		generatePassword();
                    		break;
            		}
        	}
	}

        void generatePassword() 
	{
            	String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            	String lower = "abcdefghijklmnopqrstuvwxyz";
            	String numbers = "0123456789";
            	String symbols = "!@#$%^&*()-_=+[]{};:,.<>?/";

            	StringBuilder charSet = new StringBuilder();
            	if (useUppercase) 
			charSet.append(upper);
            	if (useLowercase) 
			charSet.append(lower);
            	if (useNumbers) 
			charSet.append(numbers);
            	if (useSymbols) 
			charSet.append(symbols);

            	if (charSet.length() == 0) 
		{
                	JOptionPane.showMessageDialog(null, "Please select at least one character type!");
                	return;
            	}

            	int length;
            	try 
		{
                	length = Integer.parseInt(T1.getText());
                	if (length <= 0) 
				throw new NumberFormatException();
            	} 
		catch (NumberFormatException ex) 
		{
                	JOptionPane.showMessageDialog(null, "Please enter a valid positive integer for password length!");
               		return;
            	}

            	Random rand = new Random();
            	StringBuilder password = new StringBuilder();

            	for (int i = 0; i < length; i++) 
		{
                	int index = rand.nextInt(charSet.length());
                	password.append(charSet.charAt(index));
            	}

            	L2.setText(password.toString());
        }
}



