package com.example.task_manager.domain.models;

public enum TaskState {
    TODO("todo"),
    INPROGRESS("inprogress"),
    DONE("done");

    private String state;
    TaskState(String state) {
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
