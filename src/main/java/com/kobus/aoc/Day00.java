package com.kobus.aoc;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

/**
 * Advent of Code 2021 Solutions
 * Day 1: Sonar Sweep
 *
 * @author Kobus Pretorius
 */
public class Day00 extends AoCRunnable {

    public static void main(String[] args) throws IOException {
        new Day00("00").run(true);
        new Day00("00").run(false);
    }

    public Day00(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        String answer = "";
        boolean found = false;
        int i = 0;
        var key = input.get(0);
        while (!found) {
            answer = DigestUtils.md5Hex(key + i).toUpperCase();
            if (answer.substring(0, 5).equals("00000")) {
                found = true;
            }
            i++;
        }
        System.out.println(answer);
        return "" + (i - 1);
    }

    @Override
    public String part2() {
        String answer = "";
        boolean found = false;
        int i = 0;
        var key = input.get(0);
        while (!found) {
            answer = DigestUtils.md5Hex(key + i).toUpperCase();
            if (answer.substring(0, 6).equals("000000")) {
                found = true;
            }
            i++;
        }
        System.out.println(answer);
        return "" + (i - 1);
    }
}
