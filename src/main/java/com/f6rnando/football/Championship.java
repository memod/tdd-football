package com.f6rnando.football;

public class Championship {

    private String[] scoreTable;

    public void setScoreTable(String[] scoreTable) {
        this.scoreTable = scoreTable;
    }

    public int getNumberOfMatches() {
        return scoreTable.length;
    }

    public String getMatch(int matchNumber) {
        return scoreTable[matchNumber];
    }
}
