package com.example.techbook;

public class ModelAnswer {

String name, answer;

    public ModelAnswer() {
    }

    public ModelAnswer(String name, String answer) {
        this.name = name;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
