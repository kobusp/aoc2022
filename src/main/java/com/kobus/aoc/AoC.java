package com.kobus.aoc;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Advent of Code 2021 Solutions
 * Run all solutions with the proper input excluding test runs.
 *
 * @author Kobus Pretorius
 */
public class AoC {

    public static final int NUM_EXECUTIONS = 100;

    public static void main(String[] args) throws IOException {
        System.out.println();
        System.out.println("╔═══════════════════ AoC 2022 ~ Batch Execution ═══════════════════╗");
        System.out.println("║ Day  Part           Answer" + String.format("%20s", "Ave. of " + NUM_EXECUTIONS + " Runs") + String.format("%18s", "(Worst)") + " ║");
        var allDays = new ArrayList<AoCRunnable>();
        allDays.add(new Day1("1"));

        for (var day : allDays) {
            day.run(false, NUM_EXECUTIONS);
        }

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    public AoC() {
    }
}
