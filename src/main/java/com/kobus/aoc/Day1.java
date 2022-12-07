package com.kobus.aoc;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Advent of Code 2022 Solutions
 * Day 1: Calorie Counting
 *
 * @author Kobus Pretorius
 */
public class Day1 extends AoCRunnable {

    public static void main(String[] args) throws IOException {
        new Day1("1").run(true);
        new Day1("1").run(false);
    }

    public Day1(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        int answer;
        var calories = getGroupedCalories();
        answer = calories.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        return "" + answer;
    }

    @Override
    public String part2() {
        var calories = getGroupedCalories();
        int answer = calories.values().stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .limit(3)
                .sum();
        return "" + answer;
    }

    private HashMap<Integer, Integer> getGroupedCalories() {
        var calories = new HashMap<Integer, Integer>();
        int i = 0;
        for (var line : input) {
            if (line.isEmpty()) {
                i++;
                continue;
            }
            calories.put(i, calories.getOrDefault(i, 0) + Integer.parseInt(line, 10));
        }
        return calories;
    }
}
