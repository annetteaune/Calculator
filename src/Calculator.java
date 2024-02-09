import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {


    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
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
        frame.setBackground(new Color(245, 113, 40, 255));

        //OUTPUT WINDOW
        textField = new JTextField();
        textField.setBounds(40,25,300,50); //size of output window
        textField.setFont(myFont);
        textField.setEditable(false); //disable user input into output window
        textField.setBackground(Color.WHITE);

        //FUNCTIONAL BUTTONS
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DELETE");
        clrButton = new JButton("CLEAR");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setBackground(new Color(255, 255, 255, 255));
            functionButtons[i].setFocusable(false);//Disables outline on button
        }

        //NUMBER BUTTONS
        for (int i = 0; i < 10; i++) {
         numberButtons[i] = new JButton(String.valueOf(i));
         numberButtons[i].addActionListener(this);
         numberButtons[i].setFont(myFont);
         numberButtons[i].setFocusable(false);//Disables outline on button
        }

        delButton.setBounds(30,430, 145,50);
        clrButton.setBounds(205,430, 145,50);

        //GRID PANEL FOR BUTTONS
        panel = new JPanel();
        panel.setBounds(40, 100,300, 300);
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
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();


    }
    //Override ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
}
