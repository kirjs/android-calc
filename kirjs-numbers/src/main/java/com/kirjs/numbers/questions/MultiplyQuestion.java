package com.kirjs.numbers.questions;

public class MultiplyQuestion implements Question {
    private int number1;
    private int number2;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        number1 = 5 + (int) Math.ceil(Math.random() * 20);
        number2 = 5 + (int) Math.ceil(Math.random() * 20);
        return String.valueOf(number1) + " * " + String.valueOf(number2);
    }

    @Override
    public boolean validate(String question) {
        return !question.isEmpty() && Integer.valueOf(question) == number1 * number2;
    }
}
