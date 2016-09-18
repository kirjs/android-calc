package com.kirjs.numbers.answers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AnswerLog {
    private ArrayList<Answer> answers = new ArrayList<>();

    public void add(Answer answer) {
        long total = 0;
        long times = 0;
        for (Answer a : answers) {
            if (answer.sameQuestionAs(a)) {
                total += a.time;
                times++;
            }
        }
        if (times > 0) {
            answer.setImprovement(answer.time - total / times);
        }


        answers.add(answer);
    }

    public List<String> last(int number) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = Math.max(0, answers.size() - number); i < answers.size(); i++) {
            Answer a = answers.get(i);
            long improvement = a.getImprovement();
            result.add(a.n1 + "x" + a.n2 + " - " + a.getTime() + (improvement > 0 ? " (" + improvement + ")" : ""));
        }
        Collections.reverse(result);
        return result;
    }
}