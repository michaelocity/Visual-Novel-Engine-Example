package com.highlowgame.game.gui.dialouge;

public class BadEndDialouge extends DialougeStorage {

    public BadEndDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    private void addDialouge()
    {
        text.add("Grader@Oh no I lost");
        text.add("Girl@ You know what that means?");
        text.add("Grader@What does that mean?");
        text.add("Girl@ Just lie down.");
        text.add("Mono@ I wake up back home");
        text.add("Mono@ I check my back pocket for my wallet");
        text.add("Mono@Instead I just find a paper stating: 1-398-897-1111 lets do this again");
        text.add("Mono@ ahh fooled again");
        text.add("End@ ending 2/4 you just got scammed");
        System.out.println(text);
    }
}
