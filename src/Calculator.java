import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JButton buttonNumberZero;
    JButton buttonNumberOne;
    JButton buttonNumberTwo;
    JButton buttonNumberThree;
    JButton buttonNumberFour;
    JButton buttonNumberFive;
    JButton buttonNumberSix;
    JButton buttonNumberSeven;
    JButton buttonNumberEight;
    JButton buttonNumberNine;
    JButton buttonDot;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonMultiply;
    JButton buttonEqual;
    JButton buttonAC;
    JButton buttonC;
    JButton buttonPlusMinus;
    JButton buttonPercentageOfDivision;

    int numberCount = 0;
    String tempNumber = "";
    double firstNumber;
    double secondNumber;
    double result;
    Operation operation;

    Calculator() {
        declarationButtons();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(425, 700);
        this.setVisible(true);
        addButtons();
    }

    void addButtons() {
        this.add(buttonNumberZero);
        this.add(buttonNumberOne);
        this.add(buttonNumberTwo);
        this.add(buttonNumberThree);
        this.add(buttonNumberFour);
        this.add(buttonNumberFive);
        this.add(buttonNumberSix);
        this.add(buttonNumberSeven);
        this.add(buttonNumberEight);
        this.add(buttonNumberNine);
        this.add(buttonDot);
        this.add(buttonPlus);
        this.add(buttonMinus);
        this.add(buttonDivide);
        this.add(buttonMultiply);
        this.add(buttonEqual);
        this.add(buttonAC);
        this.add(buttonC);
        this.add(buttonPlusMinus);
        this.add(buttonPercentageOfDivision);
    }

    void declarationButtons() {
        buttonNumberZero = initializationButton(numberCount++);
        buttonNumberOne = initializationButton(numberCount++);
        buttonNumberTwo = initializationButton(numberCount++);
        buttonNumberThree = initializationButton(numberCount++);
        buttonNumberFour = initializationButton(numberCount++);
        buttonNumberFive = initializationButton(numberCount++);
        buttonNumberSix = initializationButton(numberCount++);
        buttonNumberSeven = initializationButton(numberCount++);
        buttonNumberEight = initializationButton(numberCount++);
        buttonNumberNine = initializationButton(numberCount++);
        buttonDot = initializationButton(numberCount++);
        buttonPlus = initializationButton(numberCount++);
        buttonMinus = initializationButton(numberCount++);
        buttonDivide = initializationButton(numberCount++);
        buttonMultiply = initializationButton(numberCount++);
        buttonEqual = initializationButton(numberCount++);
        buttonAC = initializationButton(numberCount++);
        buttonC = initializationButton(numberCount++);
        buttonPlusMinus = initializationButton(numberCount++);
        buttonPercentageOfDivision = initializationButton(numberCount++);
    }

    JButton initializationButton(int number) {
        int x = chooseCoordinatesXForButton(number);
        int y = chooseCoordinatesYForButton(number);
        JButton button = new JButton();
        button.setBounds(x, y, 100, 100);
        button.addActionListener(this);
        if (number < 10) {
            button.setText(Integer.toString(number));
        } else {
            switch (number) {
                case 10 -> button.setText(".");
                case 11 -> button.setText("+");
                case 12 -> button.setText("-");
                case 13 -> button.setText("/");
                case 14 -> button.setText("*");
                case 15 -> button.setText("=");
                case 16 -> button.setText("AC");
                case 17 -> button.setText("C");
                case 18 -> button.setText("+/-");
                case 19 -> button.setText("%");
                default -> button.setText(" ");
            }
        }
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        return button;
    }

    int chooseCoordinatesXForButton(int number) {
        return switch (number) {
            case 0, 1, 4, 7, 16 -> 0;
            case 2, 5, 8, 10, 17 -> 100;
            case 3, 6, 9, 15, 18 -> 200;
            case 11, 12, 13, 14, 19 -> 300;
            default -> -1;
        };
    }

    int chooseCoordinatesYForButton(int number) {
        return switch (number) {
            case 0, 10, 15, 14 -> 550;
            case 1, 2, 3, 13 -> 450;
            case 4, 5, 6, 12 -> 350;
            case 7, 8, 9, 11 -> 250;
            case 16, 17, 18, 19 -> 150;
            default -> -1;
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNumberZero) {
            tempNumber += "0";
        } else if (e.getSource() == buttonNumberOne) {
            tempNumber += "1";
        } else if (e.getSource() == buttonNumberTwo) {
            tempNumber += "2";
        } else if (e.getSource() == buttonNumberThree) {
            tempNumber += "3";
        } else if (e.getSource() == buttonNumberFour) {
            tempNumber += "4";
        } else if (e.getSource() == buttonNumberFive) {
            tempNumber += "5";
        } else if (e.getSource() == buttonNumberSix) {
            tempNumber += "6";
        } else if (e.getSource() == buttonNumberSeven) {
            tempNumber += "7";
        } else if (e.getSource() == buttonNumberEight) {
            tempNumber += "8";
        } else if (e.getSource() == buttonNumberNine) {
            tempNumber += "9";
        } else if (e.getSource() == buttonDot) {
            tempNumber += ".";
        } else if (e.getSource() == buttonPlus) {
            firstNumber = Double.parseDouble(tempNumber);
            operation = Operation.PLUS;
            System.out.print(firstNumber + " + ");
            tempNumber = "";
        } else if (e.getSource() == buttonMinus) {
            firstNumber = Double.parseDouble(tempNumber);
            operation = Operation.MINUS;
            System.out.print(firstNumber + " - ");
            tempNumber = "";
        } else if (e.getSource() == buttonDivide) {
            firstNumber = Double.parseDouble(tempNumber);
            operation = Operation.DIVIDE;
            System.out.print(firstNumber + " / ");
            tempNumber = "";
        } else if (e.getSource() == buttonMultiply) {
            firstNumber = Double.parseDouble(tempNumber);
            operation = Operation.MULTIPLY;
            System.out.print(firstNumber + " * ");
            tempNumber = "";
        } else if (e.getSource() == buttonAC) {
            firstNumber = 0;
            secondNumber = 0;
            result = 0;
            tempNumber = "0";
        } else if (e.getSource() == buttonC) {
            secondNumber = 0;
            tempNumber = "";
        } else if (e.getSource() == buttonPercentageOfDivision) {
            firstNumber = Double.parseDouble(tempNumber);
            operation = Operation.PERCENTAGE;
            System.out.print(firstNumber + " % ");
            tempNumber = "";
        } else if (e.getSource() == buttonEqual) {
            secondNumber = Double.parseDouble(tempNumber);
            switch (operation) {
                case PLUS -> result = firstNumber + secondNumber;
                case MINUS -> result = firstNumber - secondNumber;
                case DIVIDE -> result = firstNumber / secondNumber;
                case MULTIPLY -> result = firstNumber * secondNumber;
                case PERCENTAGE -> result = firstNumber % secondNumber;
                case EQUAL -> result += secondNumber;
            }
            System.out.println(secondNumber + " = " + result);
            tempNumber = Double.toString(result);
            operation = Operation.EQUAL;
        }
    }

    enum Operation {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY,
        PERCENTAGE,
        EQUAL
    }
}