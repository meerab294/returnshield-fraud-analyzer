package com.returnshield.dsa;

import java.util.Stack;

public class UndoManager {

    private Stack<String> actions;

    public UndoManager() {

        actions = new Stack<>();
    }

    public void saveAction(String action) {

        actions.push(action);
    }

    public String undoAction() {

        if(actions.isEmpty()) {

            return "No actions to undo";
        }

        return actions.pop();
    }
}