package com.highlowgame.game.math;

import java.util.ArrayList;

public class GirlSpriteHandler {
    public ArrayList<String> basicImageUrls;
    public ArrayList<String> magicalImageUrls;
    //order: kyoko, sayaka, madoka, mami, homura
    public GirlSpriteHandler()
    {
        initBasicArr();
        initMagicalArr();
    }
    private void initBasicArr()
    {
        basicImageUrls=new ArrayList<>();
        basicImageUrls.add("characters/girls/Kyoko Sakura.png");
        basicImageUrls.add("characters/girls/Sayaka Miki.png");
        basicImageUrls.add("characters/girls/Madoka Kaname.png");
        basicImageUrls.add("characters/girls/Mami Tomoe.png");
        basicImageUrls.add("characters/girls/Homura Akemi.png");
    }
    private void initMagicalArr()
    {
        magicalImageUrls=new ArrayList<>();
        magicalImageUrls.add("characters/girls/special forms/Kyoko Sakura.png");
        magicalImageUrls.add("characters/girls/special forms/Sayaka Miki.png");
        magicalImageUrls.add("characters/girls/special forms/Madoka Kaname.png");
        magicalImageUrls.add("characters/girls/special forms/Mami Tomoe.png");
        magicalImageUrls.add("characters/girls/special forms/Homura Akemi.png");
    }
}
