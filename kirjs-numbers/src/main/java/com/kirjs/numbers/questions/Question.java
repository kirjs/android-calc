package com.kirjs.numbers.questions;

import com.kirjs.numbers.answers.Answer;

public interface Question {
    public boolean hasNext();
    public String next();
    public Answer validate(String question);
}
