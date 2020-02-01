package com.highlowgame.game.gui.dialouge;

public class InsideSchoolDialouge extends DialougeStorage {

    public InsideSchoolDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    private void addDialouge()
    {
        text.add("Mono@I wake up on a casual Tuesday," +
                "\n just like any other" +
                "\n to the sound of my alarm," +
                "\n and your mother screaming out Grader!" +
                "\n You're going to be late!");////////////////////////////////////maxsize/
        text.add("Mono@I then proceed to rush out of bed " +
                "\n and wrap some clothes around your luscious body," +
                "\n and hop in my mom's 2004 toyota corolla." +
                "\n In all the rush I even forget to brush my teeth!");
        text.add("Mom@“Honey, your breath smells like absolute bad.”");
        text.add("Grader@“Yeah, well you absolute bad too mom.”");
        text.add("Mono@I finally arrive at the drop-off area with the rest of the trip" +
                "\nfilled with awkward tension and sleep deprivation..." +
                "\nIt just so happens I had spent my night coding a game " +
                "\nfor my favorite teacher, Mr. Rico");
        text.add("Mono@I slam the passenger door open, grab my bag," +
                "\nand begin to run through the door with Mr Riley," +
                "\nthe school security guard yelling");
        text.add("Mr. Riley@“AY PLAYA, SLOW DOWN!”");
        text.add("Mono@I ignore him.");
        text.add("Mono@On my way halfway up the stairs to try and get to my homeroom,\n" +
                "Mr Martinez stops me.");
        text.add("Grader@Of course...");
        text.add("Mr. Martinez@You’re late go get a pass");
        text.add("Mono@Somedays I wonder why I even bother coming to school…");
        text.add("Mono@I then proceed to take the\n" +
                "walk of shame down the\n" +
                "hallway to the office and grab\n" +
                "my sorry self a late pass.\n");
        text.add("Mono@This feels like an excellent way to start the day…");
        System.out.println(text);
    }


}
