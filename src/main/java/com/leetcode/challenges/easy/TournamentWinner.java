package com.leetcode.challenges.easy;

import java.util.*;

public class TournamentWinner {
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentBestTeam = "";
        HashMap<String,Integer> points = new HashMap<>();
        points.put(currentBestTeam,0);
        for(int idx=0;idx<competitions.size();idx++){
            ArrayList<String> competition = competitions.get(idx);
            int winnerIdx = results.get(idx) ^ 1;
            String winner = competition.get(winnerIdx);
            points.put(winner,points.getOrDefault(winner,0)+1);

            if(points.get(winner) > points.get(currentBestTeam))
                currentBestTeam = winner;
        }
        return currentBestTeam;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        competitions.add(new ArrayList<>(2));
        competitions.add(new ArrayList<>(2));
        competitions.add(new ArrayList<>(2));

        competitions.get(0).add("HTML");
        competitions.get(0).add("C#");
        competitions.get(1).add("C#");
        competitions.get(1).add("Python");
        competitions.get(2).add("Python");
        competitions.get(2).add("HTML");

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0,0,1));
        String winner = TournamentWinner.tournamentWinner(competitions,results);
        System.out.println(winner);
    }
}
