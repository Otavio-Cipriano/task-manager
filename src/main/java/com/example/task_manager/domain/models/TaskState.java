package com.example.task_manager.domain.models;

public enum TaskState {
    TODO("todo"),
    INPROGRESS("inprogress"),
    DONE("done");

    final private String state;
    TaskState(String state) {
        this.state = state.toLowerCase();
    }

    public String getState(){
        return state;
    }

    public static TaskState fromString(String state) {
        for (TaskState taskState : TaskState.values()) {
            if (taskState.getState().equalsIgnoreCase(state)) {
                return taskState;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + state);
    }
}
