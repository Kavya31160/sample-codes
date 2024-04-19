package com.stackroute.designpatterns.memento;

import java.util.ArrayList;
import java.util.List;

//TextEditor is the originator class representing the text editor's content.
//TextMemento is the memento class representing the saved state of the text editor.
//History is the caretaker class responsible for keeping track of multiple mementos.

// Originator class - the object whose state needs to be saved
class TextEditor {
    private String content;

    public TextEditor(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // Create a memento containing the current state
    public TextMemento save() {
        return new TextMemento(content);
    }

    // Restore the state from a memento
    public void restore(TextMemento memento) {
        this.content = memento.getContent();
    }

    // Modify the content
    public void addText(String text) {
        this.content += text;
    }
}

// Memento class - represents the saved state of the TextEditor
class TextMemento {
    private final String content;

    public TextMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Caretaker class - responsible for keeping track of multiple mementos

class History {
    private final List<TextMemento> mementos = new ArrayList<>();

    public void addMemento(TextMemento memento) {
        mementos.add(memento);
    }

    public TextMemento getMemento(int index) {
        return mementos.get(index);
    }
}

// Client code
public class MementoExample {
    public static void main(String[] args) {
    	
        TextEditor editor = new TextEditor("Hello, ");

        // Save the initial state
        History history = new History();
        
        history.addMemento(editor.save());

        // Make changes to the content
        editor.addText("world!");

        // Save the state after changes
        history.addMemento(editor.save());

        // Print the current content
        System.out.println("Current Content: " + editor.getContent());

        // Restore to the initial state
        editor.restore(history.getMemento(0));

        // Print the content after restoration
        System.out.println("Content after Restoration: " + editor.getContent());
    }
}

