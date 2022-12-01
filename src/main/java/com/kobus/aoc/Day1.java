package com.kobus.aoc;

import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Advent of Code 2021 Solutions
 * Day 1: Sonar Sweep
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
        var calories = new HashMap<Integer, Integer>();
        int i = 0;
        for (var line : input) {
            if (line.isEmpty()) {
                i++;
                continue;
            }
            calories.put(i, calories.getOrDefault(i, 0) + Integer.parseInt(line, 10));
        }
        answer = calories.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        return "" + answer;
    }

    @Override
    public String part2() {
        int answer;
        var calories = new HashMap<Integer, Integer>();
        int i = 0;
        for (var line : input) {
            if (line.isEmpty()) {
                i++;
                continue;
            }
            calories.put(i, calories.getOrDefault(i, 0) + Integer.parseInt(line, 10));
        }
        var l = calories.values().stream().mapToInt(Integer::intValue).sorted().boxed().collect(Collectors.toList());
        var len = l.size();
        answer = l.get(len-3) + l.get(len-2) + l.get(len-1);
        return "" + answer;
    }
}
