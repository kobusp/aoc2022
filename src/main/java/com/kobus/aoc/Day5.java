package com.kobus.aoc;

import java.io.IOException;
import java.util.*;

/**
 * Advent of Code 2022 Solutions
 * Day 5: Supply Stacks
 *
 * @author Kobus Pretorius
 */
public class Day5 extends AoCRunnable {

    public static void main(String[] args) throws IOException {
        new Day5("5").run(true);
        new Day5("5").run(false);
    }

    public Day5(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Stack<String>> stacks = parseCrates();

        boolean instructions = false;
        for (var line : input) {
            if (instructions) {
                line = line.replaceAll("move ", "").replaceAll("from ", "").replaceAll("to ", "");
                List<Integer> instr = Arrays.stream(line.split(" ")).map(this::parseInt).toList();

                int n = instr.get(0);
                int from = instr.get(1);
                int to = instr.get(2);
                for (int i = 0; i < n; i++) {
                    if (!stacks.get(from).isEmpty()) {
                        stacks.get(to).push(stacks.get(from).pop());
                    }
                }
            }

            if (line.isEmpty()) {
                instructions = true;
            }
        }


        for (var stack : stacks.values()) {
            answer.append(stack.pop());
        }

        return "" + answer;
    }


    @Override
    public String part2() {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Stack<String>> stacks = parseCrates();

        List<String> instructionInput = input.subList(input.indexOf("") + 1, input.size());

        for (var line : instructionInput) {
            List<Integer> instr = Arrays.stream(line
                            .replaceAll("move ", "")
                            .replaceAll("from ", "")
                            .replaceAll("to ", "")
                            .split(" "))
                    .map(this::parseInt)
                    .toList();

            int n = instr.get(0);
            int from = instr.get(1);
            int to = instr.get(2);

            var temp = new Stack<String>();
            for (int i = 0; i < n; i++) {
                temp.push(stacks.get(from).pop());
            }

            for (int i = 0; i < n; i++) {
                var s = temp.pop();
                stacks.get(to).push(s);
            }
        }

        for (var stack : stacks.values()) {
            answer.append(stack.pop());
        }

        return "" + answer;
    }

    private HashMap<Integer, Stack<String>> parseCrates() {
        int size = 0;
        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i);
            if (input.get(i + 1).isEmpty()) {
                line = line.replaceAll(" ", "");
                size = line.length();
                break;
            }
        }

        HashMap<Integer, Stack<String>> stacks = new HashMap<>();

        // Initialise stacks
        for (int i = 1; i < size + 1; i++) {
            stacks.put(i, new Stack<>());
        }

        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i);
            line = line.replaceAll("         ", " [-] [-] ").replaceAll("     ", " [-] ").replaceAll("    ", "[-] ");

            line = line.replaceAll("\\[", "").replaceAll("]", "");

            int p = 1;
            for (String s : line.split(" ")) {
                if (!s.equals("-")) {
                    stacks.getOrDefault(p, new Stack<String>()).push(s);
                }
                p++;
            }

            if (input.get(i + 2).isEmpty()) {
                break;
            }
        }

        for (var key : stacks.keySet()) {
            var stack = stacks.get(key);
            var reversedStack = new Stack<String>();
            while (!stack.isEmpty()) {
                reversedStack.push(stack.pop());
            }
            stacks.put(key, reversedStack);
        }
        return stacks;
    }

}
