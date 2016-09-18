package com.kirjs.numbers.questions;

public interface Question {
    public boolean hasNext();
    public String next();
    public boolean validate(String question);
}
