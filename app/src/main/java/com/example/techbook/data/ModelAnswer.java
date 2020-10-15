package com.example.techbook.data;

public class ModelAnswer {

String name, answer,question;

    public ModelAnswer(String question,String name, String answer) {
        this.question = question;
        this.name = name;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
