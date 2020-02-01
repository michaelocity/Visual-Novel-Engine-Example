package com.highlowgame.game.gui.dialouge;

public class OutsideSchoolDialouge extends DialougeStorage {

    public OutsideSchoolDialouge() {
        super();
        addDialouge();
    }

    //Grader = mc
    //Girl = Girl
    //Mono = monolouge
    private void addDialouge()
    {
        text.add("Mono@Your terrible day finally goes by minute by minute, you hating\n" +
                        "every second of it. The day was supposed to be an\n" +
                        "odd day so you would be able to see your favorite teacher,\n" +
                        "Mr Rico, but instead they changed it to even because of\n" +
                        "winter break, for some stinky reason.\n");
        text.add("Choice@How should I go Home?");
        text.add("Mono@I continue to walk home.");
        text.add("???@Hey!");
        text.add("Mono@I shrug it off since I've never heard that voice before.");
        text.add("???@Hey You!!! Yeah You!!");
        text.add("Grader@What do you want?");
        text.add("Girl@ Yo- Y.. You look pr- pretty..." +
                "\nuh cool……" +
                "\nyou wanna chill bro?");
        text.add("Grader@Uuuuuuuuh ok");
        text.add("Mono@It's not like I have anything better to do today.");
        text.add("Girl@Lets chill at my place.");
        text.add("Mono@Man I moust have a pretty boring life to be following " +
                "\nthe first girl that talks to me" +
                "\n...." +
                "in six months.");
        System.out.println(text);
    }


}
