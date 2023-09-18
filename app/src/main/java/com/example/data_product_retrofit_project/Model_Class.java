package com.example.data_product_retrofit_project;

public class Model_Class {

    String title;
    String completed;


    public Model_Class(String title, String completed) {

        this.title = title;
        this.completed=completed;

    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Model_Class{" +
                "title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
