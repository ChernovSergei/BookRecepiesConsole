package main;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String requestString(String request) {
        System.out.println(request);
        return scanner.nextLine();
    }

    @Override
    public int requestInteger(String request) {
        return Integer.parseInt(requestString(request));
    }
}
