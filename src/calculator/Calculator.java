package calculator;

import java.awt.*;
import javax.swing.*;

class Calculator extends JFrame {
    JTextField number1Field = new JTextField(10);
    JTextField number2Field = new JTextField(10);
    JButton addButton = new JButton("сложить");
    JButton subtractButton = new JButton("вычесть");
    JButton multiplyButton = new JButton("умножить");
    JButton divideButton = new JButton("разделить");

    Calculator() {
        super("Калькулятор");
        setLayout(new FlowLayout());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("первое число:"));
        add(number1Field);
        add(new JLabel("второе число:"));
        add(number2Field);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        addButton.addActionListener(e -> performOperation("сложить"));
        subtractButton.addActionListener(e -> performOperation("вычесть"));
        multiplyButton.addActionListener(e -> performOperation("умножить"));
        divideButton.addActionListener(e -> performOperation("разделить"));

        setVisible(true);
    }

    private void performOperation(String operation) {
        try {
            double num1 = Double.parseDouble(number1Field.getText().trim());
            double num2 = Double.parseDouble(number2Field.getText().trim());
            double result = 0;

            switch (operation) {
                case "сложить":
                    result = num1 + num2;
                    break;
                case "вычесть":
                    result = num1 - num2;
                    break;
                case "умножить":
                    result = num1 * num2;
                    break;
                case "разделить":
                    if (num2 == 0) {
                        throw new ArithmeticException("на ноль не делят.");
                    }
                    result = num1 / num2;
                    break;
            }

            JOptionPane.showMessageDialog(null, "Результат = " + result, "Ответ", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "я только с цифрами работаю", "ошибка", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}