package com.kirjs.numbers.questions;

import com.kirjs.numbers.answers.Answer;
import com.kirjs.numbers.answers.AnswerLog;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiplyQuestion implements Question {
    private final AnswerLog answerLog;
    private int number1;
    private int number2;
    long startTime;

    public MultiplyQuestion() {
        this.answerLog = new AnswerLog();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        startTime = System.currentTimeMillis();
        number1 = 5 + (int) Math.ceil(Math.random() * 20);
        number2 = 5 + (int) Math.ceil(Math.random() * 20);
        return String.valueOf(number1) + " xx " + String.valueOf(number2);
    }

    @Override
    public boolean validate(String question) {
        boolean isValid = !question.isEmpty() && Integer.valueOf(question) == number1 * number2;
        if(isValid){
            answerLog.add(new Answer(number1, number2, System.currentTimeMillis() - startTime));
        }
        return isValid;
    }
}
