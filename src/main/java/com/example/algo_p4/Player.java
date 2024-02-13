package com.example.algo_p4;

public class Player {
    private String name;
    private char xORo;
    private int won;
    private int draw;

    public Player(String name, char xORo, int won, int draw) {
        this.name = name;
        this.xORo = xORo;
        this.won = won;
        this.draw = draw;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getxORo() {
        return xORo;
    }

    public void setxORo(char xORo) {
        this.xORo = xORo;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", xORo=" + xORo +
                ", won=" + won +
                ", draw=" + draw +
                '}';
    }
}
