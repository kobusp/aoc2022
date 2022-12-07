package com.kobus.aoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Advent of Code 2022 Solutions
 * Day 7: No Space Left On Device
 *
 * @author Kobus Pretorius
 */
public class Day7 extends AoCRunnable {

    public static int MAX_DISK_SIZE = 70000000;
    public static int REQUIRED_SIZE = 30000000;


    public static void main(String[] args) throws IOException {
        new Day7("7").run(true);
        new Day7("7").run(false);
    }

    public Day7(String dayNumber) {
        super(dayNumber);
    }

    @Override
    public String part1() {
        int answer;
        Directory root = parseDirectories();
        answer = root.getDirectoriesUnderSize(100000).stream().mapToInt(Directory::getSize).sum();

        return "" + answer;
    }

    @Override
    public String part2() {
        int answer;
        Directory root = parseDirectories();
        var allDirs = root.getDirectoriesUnderSize(Integer.MAX_VALUE);
        var totalSize = root.getSize();
        int requiredSize = REQUIRED_SIZE - (MAX_DISK_SIZE - totalSize);
        answer = allDirs.stream().mapToInt(Directory::getSize)
                .sorted()
                .filter(i -> i >= requiredSize)
                .findFirst()
                .getAsInt();
        return "" + answer;
    }

    private Directory parseDirectories() {
        var root = new Directory("/");
        var current = root;

        for (var line : input) {
            if (line.equals("$ cd /")) {
                continue;
            }

            if (line.contains("$")) {
                if (line.equals("$ cd ..")) {
                    current = current.parent;
                } else if (line.contains("$ cd")) {
                    var name = line.substring(5);
                    current = current.getDirectory(name);
                }
            } else {
                if (line.contains("dir")) {
                    current.addDirectory(new Directory(line.substring(4)));
                } else {
                    // files
                    var parts = line.split(" ");
                    int size = parseInt(parts[0]);
                    var name = parts[1];
                    current.addFile(new File(name, size));
                }
            }
        }
        return root;
    }

    class Directory {
        public List<Directory> directories = new ArrayList<>();
        public List<File> files = new ArrayList<>();
        public String name;
        public Directory parent;

        public Directory(String name) {
            this.name = name;
        }

        public void addDirectory(Directory d) {
            d.parent = this;
            this.directories.add(d);
        }

        public void addFile(File f) {
            this.files.add(f);
        }

        public int getSize() {
            int total = 0;
            for (var f : files) {
                total += f.size;
            }
            for (var d : directories) {
                total += d.getSize();
            }
            return total;
        }

        public Directory getDirectory(String name) {
            for (var d : directories) {
                if (d.name.equals(name)) {
                    return d;
                }
            }
            return null;
        }

        public List<Directory> getDirectoriesUnderSize(int size) {
            var l = new ArrayList<Directory>();
            for (var d : directories) {
                if (d.getSize() <= size) {
                    l.add(d);
                }
                l.addAll(d.getDirectoriesUnderSize(size));
            }
            return l;
        }
    }

    class File {
        public String name;
        public int size;

        public File(String name, int size) {
            this.name = name;
            this.size = size;
        }
    }

}
