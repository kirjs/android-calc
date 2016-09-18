package com.kirjs.numbers.answers;

import java.util.ArrayList;

public class AnswerLog {
    private ArrayList<Answer> answers = new ArrayList<>();

    public void add(Answer answer){
        long total = 0;
        long times = 0;
        for(Answer a: answers){
            if (answer.sameQuestionAs(a)) {
                total += a.time;
                times++;
            }
        }
        long average = total / times;
        answer.setImprovement(answer.time - average);
        answers.add(answer);
    }
}