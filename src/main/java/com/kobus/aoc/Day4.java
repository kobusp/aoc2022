package com.kobus.aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Advent of Code 2022 Solutions
 * Day 4: Camp Cleanup
 *
 * @author Kobus Pretorius
 */
public class Day4 extends AoCRunnable {

    public static int A1 = 0;
    public static int A2 = 1;
    public static int B1 = 2;
    public static int B2 = 3;

    public static void main(String[] args) throws IOException {
        new Day4("4").run(true);
        new Day4("4").run(false);
    }

    public Day4(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        int answer = 0;
        for (var line : input) {
            List<Integer> c = getIntegers(line);
            if (c.get(A1) <= c.get(B1) && c.get(A2) >= c.get(B2)
                    || c.get(B1) <= c.get(A1) && c.get(B2) >= c.get(A2)) {
                answer++;
            }
        }
        return "" + answer;
    }

    @Override
    public String part2() {
        int answer = 0;
        for (var line : input) {
            List<Integer> c = getIntegers(line);
            if (!(c.get(B2) < c.get(A1) || c.get(B1) > c.get(A2))) {
                answer++;
            }
        }
        return "" + answer;
    }

    private List<Integer> getIntegers(String line) {
        return Arrays.stream(line.replaceAll("-", ",").split(","))
                .map(this::parseInt).toList();
    }
}
