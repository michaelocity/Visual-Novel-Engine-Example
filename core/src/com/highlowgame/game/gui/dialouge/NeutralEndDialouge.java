package com.highlowgame.game.gui.dialouge;

public class NeutralEndDialouge extends DialougeStorage {

    public NeutralEndDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    private void addDialouge()
    {
        text.add("Grader@ Looks like I won");
        text.add("Girl@ Yep Looks Like it");
        text.add("Girl@ Here");
        text.add("Grader@What’s this");
        text.add("Girl@Its the money");
        text.add("Mono@That was cool maybe I should come here again");
        text.add("Girl@And so the cycle continues. I can’t wait to find my next victim.");
        text.add("End@ ending 3/4 normal ending for normal gameplay");
        System.out.println(text);
    }
}
