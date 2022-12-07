package com.kobus.aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Advent of Code 2022 Solutions
 * Day 3: Rucksack Reorganization
 *
 * @author Kobus Pretorius
 */
public class Day3 extends AoCRunnable {

    public static void main(String[] args) throws IOException {
        new Day3("3").run(true);
        new Day3("3").run(false);
    }

    public Day3(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        int answer = 0;

        for (var line : input) {
            int mid = line.length() / 2;
            var commonItems = getDistinctChars(line.substring(0, mid));
            commonItems.retainAll(getDistinctChars(line.substring(mid)));
            answer += getValue(commonItems.iterator().next().toCharArray()[0]);
        }

        return "" + answer;
    }

    @Override
    public String part2() {
        int answer = 0;

        for (int i = 0; i < input.size(); i += 3) {
            var commonItems = getDistinctChars(input.get(i));
            commonItems.retainAll(getDistinctChars(input.get(i + 1)));
            commonItems.retainAll(getDistinctChars(input.get(i + 2)));

            answer += getValue(commonItems.iterator().next().toCharArray()[0]);
        }

        return "" + answer;
    }

    private HashSet<String> getDistinctChars(String input) {
        return new HashSet<>(Arrays.asList(input.split("")));
    }

    private static int getValue(int value) {
        if (value < 96) {
            value = value - 64 + 26;
        } else {
            value = value - 96;
        }
        return value;
    }

}
