package com.highlowgame.game.cards;

public enum Cards {
    Ace("card_1_"),
    two("card_2_"),
    three("card_3_"),
    four("card_4_"),
    five("card_5_"),
    six("card_6_"),
    seven("card_7_"),
    eight("card_8_"),
    nine("card_9_"),
    ten("card_10_"),
    jack("card_11_"),
    queen("card_12_"),
    king("card_13_");

    private final String name;
    Cards(String name) { this.name = name; }
    public String getValue() { return name; }
}
