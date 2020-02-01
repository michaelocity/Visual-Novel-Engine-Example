package com.highlowgame.game.gui.dialouge;

public class InsideCasinoDialouge extends DialougeStorage {

    public InsideCasinoDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    //Cloice= game handled decision
    private void addDialouge() {
        text.add("Grader@Woah this place is huge!");
        text.add("Girl@ Yeah my dad is pretty rich.");
        text.add("Girl@Hey it's pretty hot in here " +
                "\ndon't ya think?");
        text.add("Grader@Not really, why?");
        text.add("Girl@Yeah well I think it's hot in here. Imma head to my room for a sec.");
        text.add("Girl@You stay here, ok?");
        text.add("Grader@Oh ok.");
        text.add("Girl@Ok I'm back.");
        text.add("Grader@Sooooooo what are we going to do for fun?");
        text.add("Mono@I've just been following this girl for an hour." +
                "\n I hope its actually for a purpose.");
        text.add("Girl@Oh yeah about that..." +
                "\n ummm...     " +
                "\n ummmmmm...    " +
                "\n do you like card games?");
        text.add("Grader@What? Why?");
        text.add("Girl@ You know we are in a casino right?" +
                "\n Like half the place is just blackjack and poker.");
        text.add("Grader@Yeah that makes since," +
                "\n but I'm not that good at card games.");
        text.add("Girl@Don't worry I know the perfect card game for you:" +
                "\n Higher or Lower.");
        text.add("Grader@What's higher or lower?");
        text.add("Girl@Well its this game where you guess whether the next card is" +
                "\n higher or lower. Pretty self-explanatory.");
        text.add("Girl@Guess three times incorrectly," +
                "\nand you get a strike." +
                "\nAnd like softball," +
                "\nthree strikes and your out.");
        text.add("Grader@How do I win?");
        text.add("Girl@ You don't.");
        text.add("Girl@But seriously that's not important right now" +
                "\nIf you win I'll tell you a big secret.");
        text.add("Girl@Do you want to do a low or high stakes bet?");
        text.add("Grader@A bet?");
        text.add("Girl@Yeah, like I said earlier, this is a casino.");
        text.add("Choice@Should I do a high stakes or low stakes gamble?");
        text.add("Girl@Allright all bets are in." +
                "\n Let's start.");
        System.out.println(text);
    }
}
