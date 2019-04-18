package com.f6rnando.football;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FootballScoreTest {
    //-- A championship must have 10 matches
    //-- A match must have a score for each team
    //-- An undefeated team has a score of 30 points
    //-- A team that never won has a score of 0 points
    //-- A matched championship has a score of 10 points

    // Rules
    // 1. A team who win gets 3 points
    // 2. With a matched game both teams get 1 point
    // 3. If no goals are scored, both teams get 0 points

    @Test
    public void aFinishedChampionshipHas10Matches() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "0:1", "2:2", "1:2", "1:2", "2:4", "4:0", "4:4", "0:0"};
        Championship championship = new Championship();
        int numberOfMatches;

        // Act
        int expectedMatches = 10;
        championship.setScoreTable(scoreTable);
        numberOfMatches = championship.getNumberOfMatches();

        // Assert
        assertEquals(expectedMatches, numberOfMatches);
    }

    @Test
    public void aNotStartedChampionshipHas0Matches() {
        // Setup
        String[] scoreTable = {};
        Championship championship = new Championship();
        int numberOfMatches;

        // Act
        int expectedMatches = 0;
        championship.setScoreTable(scoreTable);
        numberOfMatches = championship.getNumberOfMatches();

        // Assert
        assertEquals(expectedMatches, numberOfMatches);
    }

    @Test
    public void aMatchHasScoreForTwoTeams() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "0:1", "2:2", "1:2", "1:2", "2:4", "4:0", "4:4", "0:0"};
        Championship championship = new Championship();

        // Act
        int expectedQuantity = 2;
        championship.setScoreTable(scoreTable);
        String match = championship.getMatch(3);
        int scoreQuantity = match.split(":").length;

        // Assert
        assertEquals(expectedQuantity, scoreQuantity);
    }

    @Test
    public void anUndefeatedTeamHasAScoreOf30Points() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "3:1", "4:2", "3:2", "4:2", "5:4", "4:0", "5:4", "5:0"};
        Championship championship = new Championship();

        // Act
        int expectedWinnerScore = 30;
        championship.setScoreTable(scoreTable);
        championship.calculateMatchScore();

        // Assert
        assertEquals(expectedWinnerScore, championship.getWinnerScore());
    }

    @Test
    public void aTeamWhoNeverWonHasAScoreOfZero() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "3:1", "4:2", "3:2", "4:2", "5:4", "4:0", "5:4", "5:0"};
        Championship championship = new Championship();

        // Act
        int expectedLooserScore = 0;
        championship.setScoreTable(scoreTable);
        championship.calculateMatchScore();

        // Assert
        assertEquals(expectedLooserScore, championship.getLooserScore());
    }

    @Test
    public void aMatchedChampionshipHasAScoreOf10ForEachTeam() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "3:1", "4:2", "3:2", "0:2", "0:4", "0:4", "0:4", "0:3"};
        Championship championship = new Championship();

        // Act
        int teamAScore = 10;
        int teamBScore = 10;
        championship.setScoreTable(scoreTable);
        championship.calculateMatchScore();

        // Assert
        assertEquals(teamAScore, championship.getWinnerScore());
        assertEquals(teamBScore, championship.getLooserScore());
    }

    @Test
    public void aTeamWhoWon6TimesHasAScoreOf18() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "3:1", "4:2", "3:2", "4:2", "2:4", "0:0", "1:4", "0:0"};
        Championship championship = new Championship();

        // Act
        int expectedWinnerScore = 18;
        championship.setScoreTable(scoreTable);
        championship.calculateMatchScore();

        // Assert
        assertEquals(expectedWinnerScore, championship.getWinnerScore());
    }

    @Test
    public void aTeamWhoLost6TimesHasAScoreOf12() {
        // Setup
        String[] scoreTable = {"2:0", "1:0", "3:1", "4:2", "3:2", "4:2", "2:4", "0:1", "1:4", "0:1"};
        Championship championship = new Championship();

        // Act
        int expectedLooserScore = 12;
        championship.setScoreTable(scoreTable);
        championship.calculateMatchScore();

        // Assert
        assertEquals(expectedLooserScore, championship.getLooserScore());
    }

    @Test
    public void aChampionshipWithNoMatchesWonHasAScoreOfZeroForEachTeam() {
        // Setup
        String[] scoreTable = {"0:0", "0:0", "0:0", "0:0", "0:0", "0:0", "0:0", "0:0", "0:0", "0:0"};
        Championship championship = new Championship();

        // Act
        int teamAScore = 0;
        int teamBScore = 0;
        championship.setScoreTable(scoreTable);
        championship.calculateMatchScore();

        // Assert
        assertEquals(teamAScore, championship.getWinnerScore());
        assertEquals(teamBScore, championship.getLooserScore());
    }
}
