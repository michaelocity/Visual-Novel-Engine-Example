package com.highlowgame.game.gui.dialouge;

public class OutsideCasinoDialouge extends DialougeStorage {

    public OutsideCasinoDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    //Cloice= game handled decision
    private void addDialouge() {
        text.add("Girl@Hey We're h-");
        text.add("Grader@Wait where are we?");
        text.add("Girl@Oh... did I forget to mention that I live in a casino?");
        text.add("Grader@hey");
        text.add("Girl@Ya?");
        text.add("Grader@Yeah..." +
                "\n" +
                "\n Wait a second " +
                "\n Wait just 1 second" +
                "\n How does forget to mention that you live in a casino baka?");
        text.add("Girl@ “Easy easy now... Its jus- I get so used to being all alone in my big\n" +
                "daddy’s casino... " +
                "\nHe bought it o so long ago and I get so lonely…" +
                "\nI can really use someone as nice and cool as you”");
        text.add("Mono@I feel like imma get mugged");
        text.add("Choice@ I dont really feel safe here," +
                "\nbut i really dont want to waste the 30 minutes walking here." +
                "\nShould I go?");
        text.add("Girl@Great follow me inside.");
        System.out.println(text);
    }
}
