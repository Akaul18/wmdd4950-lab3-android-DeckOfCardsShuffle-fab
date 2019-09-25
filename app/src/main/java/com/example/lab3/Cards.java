package com.example.lab3;

class Cards extends Object {
    private String rank;
    private String suit;

    public Cards(String r,String s) {
        rank=r;
        suit=s;
    }

    @Override
    public String toString() {
        return rank+"_of_"+suit;
    }
}

