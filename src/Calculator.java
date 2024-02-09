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
