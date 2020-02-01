package com.highlowgame.game.cards;

public enum Suit {
    diamond("diamond"),
    clover("clover"),
    heart("heart"),
    spade("spade");

    private final String name;
    Suit(String name) { this.name = name; }
    public String getValue() { return name; }
    public String getFile() {return name+".png";}
}
