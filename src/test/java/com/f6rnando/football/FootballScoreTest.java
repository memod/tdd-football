package com.f6rnando.football;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballScoreTest {
    //-- A championship must have 10 matches
    // A match must have a score for each team
    // An undefeated team has a score of 30 points
    // A team that never won has a score of 0 points
    // A matched championship has a score of 10 points
    // A winner team score 3 points
    // A looser team score 0 points
    // A matched game score 1 point

    @Test
    public void aChampionshipHas10Matches() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "0:1", "2:2", "1:2", "1:2", "2:4", "4:0", "4:4", "0:0"};
        Championship championship = new Championship();
        int numberOfMatches;

        // Act
        int expectedMatches = 10;
        championship.setScoreTable(scoreTable);
        numberOfMatches = championship.getNumberOfMatches();

        //Assert
        assertEquals(expectedMatches, numberOfMatches);
    }
}
