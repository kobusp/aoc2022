package com.kobus.aoc;

import java.io.IOException;
import java.util.Map;

/**
 * Advent of Code 2022 Solutions
 * Day 2: Rock Paper Scissors
 *
 * @author Kobus Pretorius
 */
public class Day2 extends AoCRunnable {

    private static final int LOSS = 0;
    private static final int DRAW = 3;
    private static final int WIN = 6;
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    private static final Map<String, Integer> SHAPE_SCORE = Map.of(
            "X", ROCK,
            "Y", PAPER,
            "Z", SCISSORS);

    private static final Map<String, Integer> WIN_SCORE = Map.of(
            "AY", WIN,
            "AX", DRAW,
            "AZ", LOSS,

            "BX", LOSS,
            "BY", DRAW,
            "BZ", WIN,

            "CX", WIN,
            "CY", LOSS,
            "CZ", DRAW);

    // X = lose, Y = draw, Z = win
    private static final Map<String, String> STRATEGY = Map.of(
            "AX", "Z",
            "AY", "X",
            "AZ", "Y",

            "BX", "X",
            "BY", "Y",
            "BZ", "Z",

            "CX", "Y",
            "CY", "Z",
            "CZ", "X");


    public static void main(String[] args) throws IOException {
        new Day2("2").run(true);
        new Day2("2").run(false);
    }

    public Day2(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        int answer = 0;
        for (var line : input) {
            String in = line.replaceAll(" ", "");
            answer += WIN_SCORE.get(in) + SHAPE_SCORE.get(in.substring(1));
        }
        return "" + answer;
    }

    @Override
    public String part2() {
        int answer = 0;
        for (var line : input) {
            String in = line.replaceAll(" ", "");
            String shapeToChoose = STRATEGY.get(in);
            answer += WIN_SCORE.get(in.substring(0, 1) + shapeToChoose) + SHAPE_SCORE.get(shapeToChoose);
        }
        return "" + answer;
    }

}
