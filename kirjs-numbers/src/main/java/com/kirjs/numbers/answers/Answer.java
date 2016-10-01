package com.kirjs.numbers.answers;

public class Answer {
    private long time;
    private int n1;
    private int n2;
    public boolean isValid;
    private long improvement = 0;

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

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
}