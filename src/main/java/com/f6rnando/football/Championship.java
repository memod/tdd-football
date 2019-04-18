package com.f6rnando.football;

public class Championship {

    private String[] scoreTable;
    private int winnerScore;
    private int looserScore;

    public void setScoreTable(String[] scoreTable) {
        this.scoreTable = scoreTable;
    }

    public int getNumberOfMatches() {
        return scoreTable.length;
    }

    public String getMatch(int matchNumber) {
        return scoreTable[matchNumber];
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public int getLooserScore() {
        return looserScore;
    }

    public void calculateMatchScore() {
        int teamA = 0;
        int teamB = 0;
        String[] matchScore;

        for (String score : scoreTable) {
            matchScore = score.split(":");

            if (Integer.parseInt(matchScore[0]) > Integer.parseInt(matchScore[1])) {
                // Team A won the match
                teamA += 3;
            } else if (Integer.parseInt(matchScore[1]) > Integer.parseInt(matchScore[0])) {
                // Team B won the match
                teamB += 3;
            } else {
                // It was a matched game
                if (Integer.parseInt(matchScore[0]) > 0) {
                    // Goals were scored
                    teamA += 1;
                    teamB += 1;
                }
            }
        }

        if (teamA > teamB) {
            this.winnerScore = teamA;
            this.looserScore = teamB;
        } else if (teamA < teamB) {
            this.winnerScore = teamB;
            this.looserScore = teamA;
        } else {
            if (teamA > 0) {
                this.winnerScore = this.looserScore = 10;
            } else {
                this.winnerScore = this.looserScore = 0;
            }
        }
    }
}
