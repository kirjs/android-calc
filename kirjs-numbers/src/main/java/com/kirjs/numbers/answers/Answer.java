package com.kirjs.numbers.answers;

public class Answer {
    public final long time;
    public final int n1;
    public final int n2;
    private long improvement;

    public Answer(int n1, int n2, long time){
        if(n2>n1){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        this.n1 = n1;
        this.n2 = n2;
        this.time = time;
    }

    public boolean sameQuestionAs(Answer a) {
        return a.n1 == this.n1 && a.n2 == this.n2;
    }

    public void setImprovement(long improvement) {
        this.improvement = improvement;
    }

    public long getImprovement() {
        return improvement;
    }
}