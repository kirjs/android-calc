package com.kirjs.numbers.questions;

import com.kirjs.numbers.answers.Answer;
import com.kirjs.numbers.answers.AnswerLog;

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
        return String.valueOf(number1) + " x " + String.valueOf(number2);
    }

    @Override
    public Answer validate(String question) {
        boolean isValid = !question.isEmpty() && Integer.valueOf(question) == number1 * number2;
        return new Answer(isValid, number1, number2);
    }

}
