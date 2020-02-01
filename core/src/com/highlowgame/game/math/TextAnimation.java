package com.highlowgame.game.math;

public class TextAnimation {
    private String originalText;
    private String edited;
    private float time=0f;
    private float timePerLetter;
    private float dTime=0f;
    boolean hasspecialChar =false;

    public TextAnimation(String Text, float renderTime)
    {
        originalText=Text;
        edited="";
        timePerLetter=Text.length()/renderTime;
        System.out.println("time per letter "+timePerLetter);
    }

    public TextAnimation(String Text) {
        originalText=Text;
        edited="";
        timePerLetter=75f;
    }

    public String getOriginalText()
    {
        return originalText;
    }
    public String getEdited()
    {
        return edited;
    }


    //animates text by: Origional: hello world
    //1. h|
    //2. he|
    //...
    //11. hello world|
    //12. hello world
    //13. hello world|
    public void animateTyping(float deltaTime)
    {
        dTime+=deltaTime;
        if (dTime>2*(timePerLetter))
        {
            dTime=0;
        }
        int numberOfCharToRender = (int)(timePerLetter*dTime);
        if (numberOfCharToRender<0)
        {
            numberOfCharToRender =1;
        }
        else if (hasspecialChar)
        {
            edited=edited.substring(0,edited.length()-1);
            hasspecialChar=false;

        }
        if(edited.length()+numberOfCharToRender<originalText.length()&&numberOfCharToRender>0)
        {
            edited+=originalText.substring(edited.length(),numberOfCharToRender+edited.length());
            dTime=0;
        }
        else if(edited.length()<originalText.length()&&edited.length()+numberOfCharToRender>=originalText.length())
        {
            edited=originalText.substring(0);
            dTime=0;
        }
        else if(originalText.equals(edited)&&dTime>0.5f)
        {
            edited+="|";
            hasspecialChar =true;
            dTime=-0.8f;
        }

    }


    //animates text by: Origional: hello world
    //1. hello
    //2. world
    public void animateWordByWord(float deltaTime)
    {
        // not implemented yet
    }



}
