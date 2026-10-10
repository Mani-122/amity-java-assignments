import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise7 extends JFrame implements ActionListener {
    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;
    private JButton addBtn;
    private JButton subBtn;
    private JButton mulBtn;
    private JButton divBtn;

    public Exercise7() {
        setTitle("Simple Calculator");
        setLayout(new FlowLayout());
        setSize(320, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("First Number: "));
        num1Field = new JTextField(15);
        add(num1Field);

        add(new JLabel("Second Number:"));
        num2Field = new JTextField(15);
        add(num2Field);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        add(new JLabel("Result:        "));
        resultField = new JTextField(15);
        resultField.setEditable(false);
        add(resultField);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(num1Field.getText().trim());
            double n2 = Double.parseDouble(num2Field.getText().trim());
            double res = 0;

            if (e.getSource() == addBtn) {
                res = n1 + n2;
            } else if (e.getSource() == subBtn) {
                res = n1 - n2;
            } else if (e.getSource() == mulBtn) {
                res = n1 * n2;
            } else if (e.getSource() == divBtn) {
                if (n2 == 0) {
                    resultField.setText("Cannot divide by 0");
                    return;
                }
                res = n1 / n2;
            }

            resultField.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Exercise7();
    }
}
