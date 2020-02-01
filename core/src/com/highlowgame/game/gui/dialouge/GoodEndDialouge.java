package com.highlowgame.game.gui.dialouge;

public class GoodEndDialouge extends DialougeStorage {

    public GoodEndDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    private void addDialouge()
    {
        text.add("Grader@Aaaaaaaaaaaaah home sweet home" +
                "\n the place where i just sit around and do nothing");
        text.add("Mono@I'm glad I made it back in one piece.");
        text.add("Mono@Whell Back To Doing SOme Coding For Mr. Rico");
        text.add("Good End@ Ending 1/4 Thanks For Playing");
        System.out.println(text);
    }


}
