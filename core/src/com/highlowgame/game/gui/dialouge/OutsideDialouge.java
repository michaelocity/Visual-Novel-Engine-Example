package com.highlowgame.game.gui.dialouge;

public class OutsideDialouge extends DialougeStorage {

    public OutsideDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    private void addDialouge() {
        text.add("Grader@How far away is your house? It has been like 30 minutes.");
        text.add("Girl@Dont worry its just around the corner");
        text.add("Mono@I have been following this random girl for hal an hour straight" +
                "\n ab best part of all..." +
                "I don't even know her name!");
        text.add("Grader@hey");
        text.add("Girl@Ya?");
        text.add("Grader@What's your name?");
        text.add("Girl@ Oh its...");
        System.out.println(text);
    }
}

