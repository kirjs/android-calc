package com.kirjs.numbers.answers;

public class Answer {
    public long time;
    public final int n1;
    public final int n2;
    public final boolean isValid;
    private long improvement;

    public Answer(boolean isValid, int n1, int n2){
        this.isValid = isValid;
        if(n2>n1){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        this.n1 = n1;
        this.n2 = n2;
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

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}