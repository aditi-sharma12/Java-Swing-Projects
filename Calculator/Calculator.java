import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculator extends JFrame
{
	JLabel L1;
	JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16;
	double[] currentInput = new double[2];	
	int i = 0;
	String operator;
	boolean isOperatorClicked = false;
	boolean equalClicked = false;
	Calculator(String s2)
	{
		super(s2);
	}
	void setComponents()
	{

		L1 = new JLabel();
		L1.setFont(new Font("Arial", Font.BOLD, 18));

		B1 = new JButton("7");
		B2 = new JButton("8");
		B3 = new JButton("9");
		B4 = new JButton("/");
		B5 = new JButton("4");
		B6 = new JButton("5");
		B7 = new JButton("6");
		B8 = new JButton("x");
		B9 = new JButton("1");
		B10 = new JButton("2");
		B11 = new JButton("3");
		B12 = new JButton("-");
		B13 = new JButton("0");
		B14 = new JButton(".");
		B15 = new JButton("+");
		B16 = new JButton("=");


		setLayout(null);

		add(L1);
		add(B1);
		add(B2);
		add(B3);
		add(B4);
		add(B5);
		add(B6);
		add(B7);
		add(B8);
		add(B9);
		add(B10);
		add(B11);
		add(B12);
		add(B13);
		add(B14);
		add(B15);
		add(B16);
		

		L1.setBounds(15,20,200,50);
		L1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		L1.setHorizontalAlignment(JTextField.RIGHT);

		B1.setBounds(15,90,41,40);
		B2.setBounds(68,90,41,40);
		B3.setBounds(121,90,41,40);
		B4.setBounds(174,90,41,40);

		B5.setBounds(15,144,41,40);
		B6.setBounds(68,144,41,40);
		B7.setBounds(121,144,41,40);
		B8.setBounds(174,144,41,40);

		B9.setBounds(15,198,41,40);
		B10.setBounds(68,198,41,40);
		B11.setBounds(121,198,41,40);
		B12.setBounds(174,198,41,40);

		B13.setBounds(15,252,41,40);
		B14.setBounds(68,252,41,40);
		B15.setBounds(121,252,41,40);
		B16.setBounds(174,252,41,40);

		B1.addActionListener(new MoveHandler("7")); B2.addActionListener(new MoveHandler("8"));
		B3.addActionListener(new MoveHandler("9")); B4.addActionListener(new MoveHandler("/"));
		B5.addActionListener(new MoveHandler("4")); B6.addActionListener(new MoveHandler("5"));
		B7.addActionListener(new MoveHandler("6")); B8.addActionListener(new MoveHandler("x"));
		B9.addActionListener(new MoveHandler("1")); B10.addActionListener(new MoveHandler("2"));
		B11.addActionListener(new MoveHandler("3")); B12.addActionListener(new MoveHandler("-"));
		B13.addActionListener(new MoveHandler("0")); B14.addActionListener(new MoveHandler("."));
		B15.addActionListener(new MoveHandler("+")); B16.addActionListener(new MoveHandler("="));
	}
	public static void main(String []args)
	{
		Calculator C1 = new Calculator("Calculator");
		C1.setSize(240,350);
		C1.setVisible(true);
		C1.setComponents();
		C1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MoveHandler implements ActionListener
	{
		String str;
		MoveHandler(String s1)
		{
			this.str = s1;
		}
		public void actionPerformed(ActionEvent e) 
		{
           		if (str.equals("=")) 
			{
                		if (i < 1) 
				{
					return; 
                		}
				currentInput[1] = Double.parseDouble(L1.getText());
                		double result = 0;

                		switch (operator) 
				{
                    			case "+":
                        		result = currentInput[0] + currentInput[1];
                        		break;
                    		
					case "-":
                        		result = currentInput[0] - currentInput[1];
                        		break;
			
                    			case "x":
                        		result = currentInput[0] * currentInput[1];
                        		break;
                    			
					case "/":
                        		if (currentInput[1] != 0)
                            			result = currentInput[0] / currentInput[1];
                        		else 
					{
                            			L1.setText("Error");
						equalClicked = true;
                            			return;
                        		}
                        		break;
                		}

                		L1.setText(String.valueOf(result));
                		i = 0; // reset input index
				equalClicked = true;
            		}
            		else if (str.equals("+") || str.equals("-") || str.equals("x") || str.equals("/")) 
			{
                		operator = str;
               			currentInput[0] = Double.parseDouble(L1.getText());
				isOperatorClicked = true;
                		L1.setText(str);
                		i = 1; 
            		}
            		else 
			{
                		if(isOperatorClicked || equalClicked) 
				{
    					L1.setText(""); 
    					isOperatorClicked = false;
    					equalClicked = false;
				}

				L1.setText(L1.getText() + str);
            		}
        	}
	}

}
