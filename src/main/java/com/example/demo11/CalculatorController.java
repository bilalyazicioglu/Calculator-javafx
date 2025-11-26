package com.example.demo11;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstOperand = 0;
    private String pendingOperation = "";
    private boolean startNewNumber = true;

    @FXML
    private void initialize() {
        if (display != null) {
            display.setText("0");
        }
    }

    @FXML
    private void handleDigit(javafx.event.ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        if (startNewNumber || "0".equals(display.getText())) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    @FXML
    private void handleDot() {
        if (startNewNumber) {
            display.setText("0.");
            startNewNumber = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    @FXML
    private void handleAllClear() {
        display.setText("0");
        firstOperand = 0;
        pendingOperation = "";
        startNewNumber = true;
    }

    @FXML
    private void handleBackspace() {
        if (startNewNumber) {
            return;
        }
        String text = display.getText();
        if (text.length() > 1) {
            display.setText(text.substring(0, text.length() - 1));
        } else {
            display.setText("0");
            startNewNumber = true;
        }
    }

    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        String op = ((Button) event.getSource()).getText();
        if ("x".equals(op)) {
            op = "*";
        } else if ("÷".equals(op)) {
            op = "/";
        }

        double currentValue = parseDisplay();
        if (pendingOperation.isEmpty()) {
            firstOperand = currentValue;
        } else if (!startNewNumber) {
            firstOperand = calculate(firstOperand, currentValue, pendingOperation);
            display.setText(formatNumber(firstOperand));
        }
        pendingOperation = op;
        startNewNumber = true;
    }

    @FXML
    private void handleEquals() {
        if (pendingOperation.isEmpty()) {
            return;
        }
        double secondOperand = parseDisplay();
        double result = calculate(firstOperand, secondOperand, pendingOperation);
        display.setText(formatNumber(result));
        pendingOperation = "";
        startNewNumber = true;
    }

    private double parseDisplay() {
        try {
            return Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private double calculate(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b == 0 ? 0 : a / b;
            default -> b;
        };
    }

    private String formatNumber(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            return String.valueOf(value);
        }
    }
}
