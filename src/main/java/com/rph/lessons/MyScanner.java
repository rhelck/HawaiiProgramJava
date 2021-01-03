package com.rph.lessons;

import java.util.Objects;
import java.util.Scanner;

public class MyScanner {
    private final Scanner scanner;

    public MyScanner(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    public String nextLine() {
        return this.scanner.nextLine();
    }

    public String next() {
        return this.scanner.next();
    }
}
