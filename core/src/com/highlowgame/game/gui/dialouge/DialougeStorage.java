package com.highlowgame.game.gui.dialouge;

import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class DialougeStorage {
    ArrayList<String> text;

    //dlialouge is stored as character# dot Dialouge
    //ex 1.Hello there
    //DO NOT USE @ AS IT SPLITS THE ARRAY
    public DialougeStorage()
    {
        text = new ArrayList<String>();
    }

    public String getDialouge(int index)
    {
        return text.get(index).split(Pattern.quote("@"))[1];
    }
    public String getCharacter(int index)
    {
        return text.get(index).split(Pattern.quote("@"))[0];
    }
    public int size()
    {
        return text.size();
    }

    public boolean hasEnded(int index)
    {
        return index>=text.size()-1;
    }

    public ArrayList<String> getArrayList()
    {
        return text;
    }

    public int findIndexOfName(String name)
    {
        for (int i=0; i<text.size();i++)
        {
            if (getCharacter(i).equals(name))
            {
                return i+1;
            }
        }
        return 0;
    }


}
