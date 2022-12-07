package com.kobus.aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Advent of Code 2022 Solutions
 * Day 6: Tuning Trouble
 *
 * @author Kobus Pretorius
 */
public class Day6 extends AoCRunnable {

    public static void main(String[] args) throws IOException {
        new Day6("6").run(true);
        new Day6("6").run(false);
    }

    public Day6(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        int answer = getPacketMarker(4);
        return "" + answer;
    }

    @Override
    public String part2() {
        int answer = getPacketMarker(14);
        return "" + answer;
    }

    private int getPacketMarker(int length) {
        int answer;
        var message = input.get(0);
        int i = 0;
        while (!bufferIsUnique(i, length, message)) {
            i++;
        }
        answer = i + length;
        return answer;
    }

    private boolean bufferIsUnique(int n, int length, String message) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(message.substring(n, n + length).split("")));
        return set.size() == length;
    }
}
