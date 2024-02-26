package java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jsovle1 {
    /*
    6
    100 90 90 80 75 60
    5
    50 65 77 90 102
    https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true#!
     */
    public static void main(String[] args) throws IOException {
        int rankedCount = 6;

        List<Integer> ranked = List.of(100, 90, 80, 85, 60);

        int playerCount = 5;

        List<Integer> player = List.of(50, 65, 77, 90, 102);

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        System.out.println(result);
    }
}

class Result {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // 100 50 40 20 10
        List<Integer> distinctRanked = ranked.stream().distinct().collect(Collectors.toList());
        List<Integer> result = new ArrayList<Integer>();

        int index = distinctRanked.size() - 1;

        for (int score : player) {
            while (index >= 0 && score >= distinctRanked.get(index)) {
                index--;
            }
            result.add(index + 2);
        }

        return result;
    }
}
