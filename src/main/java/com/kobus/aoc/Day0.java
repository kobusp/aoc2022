package com.kobus.aoc;

import java.io.IOException;
import java.util.HashMap;

/**
 * Advent of Code 2021 Solutions
 * Day 1: Sonar Sweep
 *
 * @author Kobus Pretorius
 */
public class Day0 extends AoCRunnable {

    public static void main(String[] args) throws IOException {
        new Day0("0").run(true);
        new Day0("0").run(false);
    }

    public Day0(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        int answer = 0;
        var dir = input.get(0);
        int x = 0;
        int y = 0;
        var map = new HashMap<String, Integer>();
        map.put("0,0", 1);
        for (var c : dir.toCharArray()) {
            switch (c) {
                case '>': {
                    x++;
                    break;
                }
                case '<': {
                    x--;
                    break;
                }
                case 'v': {
                    y++;
                    break;
                }
                case '^': {
                    y--;
                    break;
                }
            }
            var key = x + "," + y;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        answer = map.keySet().size();
        return "" + answer;
    }

    @Override
    public String part2() {
        int answer = 0;
        var dir = input.get(0);
        int x = 0;
        int y = 0;
        var map = new HashMap<String, Integer>();
        map.put("0,0", 1);
        var ch = dir.toCharArray();
        for (int i = 0; i < ch.length; i += 2) {
            var c = ch[i];
            switch (c) {
                case '>': {
                    x++;
                    break;
                }
                case '<': {
                    x--;
                    break;
                }
                case 'v': {
                    y++;
                    break;
                }
                case '^': {
                    y--;
                    break;
                }
            }
            var key = x + "," + y;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        x = 0;
        y = 0;
        for (int i = 1; i < ch.length; i += 2) {
            var c = ch[i];
            switch (c) {
                case '>': {
                    x++;
                    break;
                }
                case '<': {
                    x--;
                    break;
                }
                case 'v': {
                    y++;
                    break;
                }
                case '^': {
                    y--;
                    break;
                }
            }
            var key = x + "," + y;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        answer = map.keySet().size();
        return "" + answer;
    }
}
