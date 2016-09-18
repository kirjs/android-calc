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
        if(times > 0 ){
            answer.setImprovement(answer.time - total / times);
        }


        answers.add(answer);
    }
}