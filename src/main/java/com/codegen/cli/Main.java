package com.codegen.cli;

import picocli.CommandLine;

public final class Main {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new GenerateCommand()).execute(args);
        System.exit(exitCode);
    }

    private Main() {
    }
}
