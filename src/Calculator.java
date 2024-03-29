import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {


    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton,
            decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.PLAIN, 24);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    //Constructor
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        //OUTPUT WINDOW
        textField = new JTextField();
        textField.setBounds(40,25,300,50); //size of output window
        textField.setFont(myFont);
        textField.setBackground(new Color(187, 187, 187));
        textField.setEditable(false); //disable user input into output window

        //FUNCTIONAL BUTTONS
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;


        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setBackground(new Color(91, 91, 91, 255));
            functionButtons[i].setFocusable(false);//Disables outline on button
        }

        //NUMBER BUTTONS
        for (int i = 0; i < 10; i++) {
         numberButtons[i] = new JButton(String.valueOf(i));
         numberButtons[i].addActionListener(this);
         numberButtons[i].setForeground(Color.WHITE);
         numberButtons[i].setFont(myFont);
         numberButtons[i].setBackground(new Color(52, 52, 52));
         numberButtons[i].setFocusable(false);//Disables outline on button
        }

        delButton.setBounds(145,120, 90,50);
        clrButton.setBounds(250,120, 90,50);
        negButton.setBounds(40,120, 90, 50);

        //GRID PANEL FOR BUTTONS
        panel = new JPanel();
        panel.setBounds(40, 180,300, 300);
        panel.setLayout(new GridLayout(4,4, 10, 10)); //row, col, hgap, vgap

        //ADD BUTTONS - in order by row
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        //ADD TO FRAME

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Override ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        //OUTPUT of number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //OUTPUT of functional buttons
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1+num2; break;
                case '-': result = num1-num2; break;
                case '*': result = num1*num2; break;
                case '/': result = num1/num2; break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
           textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
           double temp = Double.parseDouble(textField.getText());
           temp*=-1;
           textField.setText(String.valueOf(temp));
        }
    }
}
