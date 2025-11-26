package com.example.demo11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private TextField display;

    private double firstOperand = 0;
    private String pendingOperation = ""; // "+", "-", "*", "/"
    private boolean startNewNumber = true;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");

        display = new TextField("0");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setPrefHeight(40);

        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setVgap(5);
        root.setHgap(5);

        root.add(display, 0, 0, 4, 1);

        Button backspaceBtn = createButton("←", e -> handleBackspace());
        Button acBtn = createButton("AC", e -> handleAllClear());
        Button divBtn = createButton("÷", e -> handleOperator("/"));
        Button mulBtn = createButton("x", e -> handleOperator("*"));

        root.add(backspaceBtn, 0, 1);
        root.add(acBtn, 1, 1);
        root.add(divBtn, 2, 1);
        root.add(mulBtn, 3, 1);

        Button sevenBtn = createDigitButton("7");
        Button eightBtn = createDigitButton("8");
        Button nineBtn = createDigitButton("9");
        Button minusBtn = createButton("-", e -> handleOperator("-"));

        root.add(sevenBtn, 0, 2);
        root.add(eightBtn, 1, 2);
        root.add(nineBtn, 2, 2);
        root.add(minusBtn, 3, 2);

        Button fourBtn = createDigitButton("4");
        Button fiveBtn = createDigitButton("5");
        Button sixBtn = createDigitButton("6");
        Button plusBtn = createButton("+", e -> handleOperator("+"));

        root.add(fourBtn, 0, 3);
        root.add(fiveBtn, 1, 3);
        root.add(sixBtn, 2, 3);
        root.add(plusBtn, 3, 3);

        Button oneBtn = createDigitButton("1");
        Button twoBtn = createDigitButton("2");
        Button threeBtn = createDigitButton("3");
        Button equalBtn = createButton("=", e -> handleEquals());

        root.add(oneBtn, 0, 4);
        root.add(twoBtn, 1, 4);
        root.add(threeBtn, 2, 4);
        root.add(equalBtn, 3, 4, 1, 2);

        Button zeroBtn = createDigitButton("0");
        Button dotBtn = createButton(".", e -> handleDot());

        root.add(zeroBtn, 0, 5, 2, 1);
        root.add(dotBtn, 2, 5);

        Scene scene = new Scene(root, 260, 320);

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            String text = event.getText();
            if (code.isDigitKey() && !text.isEmpty()) {
                handleDigit(text);
            } else if (code == KeyCode.BACK_SPACE) {
                handleBackspace();
            } else if (code == KeyCode.ENTER || code == KeyCode.EQUALS) {
                handleEquals();
            } else if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                handleOperator(text);
            } else if (".".equals(text) || ",".equals(text)) {
                handleDot();
            }
        });

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private Button createButton(String text, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button button = new Button(text);
        button.setPrefSize(60, 50);
        button.setOnAction(handler);
        return button;
    }

    private Button createDigitButton(String digit) {
        return createButton(digit, e -> handleDigit(digit));
    }

    private void handleDigit(String digit) {
        if (startNewNumber || display.getText().equals("0")) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    private void handleDot() {
        if (startNewNumber) {
            display.setText("0.");
            startNewNumber = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    private void handleAllClear() {
        display.setText("0");
        firstOperand = 0;
        pendingOperation = "";
        startNewNumber = true;
    }

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

    private void handleOperator(String op) {
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

    public static void main(String[] args) {
        launch(args);
    }
}
