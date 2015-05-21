package com.supinfo.todo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by l3ops on 21/05/2015.
 */
public class TodoTab {
    private JTextArea comment;
    private JButton mark;
    private JLabel infos;
    private JLabel date;
    private JPanel root;

    private List<Runnable> listeners;

    public TodoTab(Todo todo) {
        listeners = new ArrayList<>();

        date.setText("Pour le: " + todo.date.toString());
        infos.setText(todo.info);

        mark.addActionListener(evt -> {
            todo.comment = comment.getText();
            Database.setTodo(todo);
            listeners.forEach(Runnable::run);
        });
    }

    public JPanel getRoot() {
        return root;
    }

    public void addRemoveListener(Runnable listener) {
        listeners.add(listener);
    }
}