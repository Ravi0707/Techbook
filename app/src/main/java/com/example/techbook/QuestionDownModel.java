package com.example.techbook;

public class QuestionDownModel {
    private String uploader, question, title, timestamp;

    public QuestionDownModel(String uploader, String question, String title, String timestamp) {
        this.uploader = uploader;
        this.question = question;
        this.title = title;
        this.timestamp = timestamp;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
