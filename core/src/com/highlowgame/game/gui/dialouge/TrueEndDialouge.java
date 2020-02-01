package com.highlowgame.game.gui.dialouge;

public class TrueEndDialouge extends DialougeStorage {

    public TrueEndDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    private void addDialouge()
    {
        text.add("Grader@Looks like I won the jackpot!!!:)");
        text.add("Grader@So where is my reward?");
        text.add("Girl@Follow me");
        text.add("Mono@I follow her to her bedroom");
        text.add("Girl@I has a surprise to show you");
        text.add("Girl@Turn around for one second.");
        text.add("Grader@Oh ok.");
        text.add("Mono@ I hear the sound of her changing");
        text.add("Grader@Can I turn around now?");
        text.add("Girl@No");
        text.add("Mono@I turn a little to take a peek");
        text.add("Girl@I told you not to look");
        text.add("Grader@Wait a second, your not a girl!");
        text.add("Grader@MMMMMMMMRRRRR. RIIIIIIICCCOOOO!??!?!?!?!??!!?!??!");
        text.add("Girl@It was all a trap from the beginning.");
        text.add("Girl@I wanted to take all your cash money.");
        text.add("Girl@I would have gotten away with it too " +
                "\nif you weren’t such a meddling kid");
        text.add("Grader@Brooooooooooooooooooooooooooo whaaaaaaaa?");
        text.add("Girl@Now I have to make sure my secret does not get out.");
        text.add("Mono@She walks closer with dire red eyes.");
        text.add("Grader@Bro m8 just chillax m8 ");
        text.add("Grader@You know what happens in Vegas stays in Vegas");
        text.add("Girl@Exactly, you’re gonna stay here for a long time. ");
        text.add("End@end 4/4 rest in pepperonis, you pulled too far back behind the curtain");
        System.out.println(text);
    }
}
