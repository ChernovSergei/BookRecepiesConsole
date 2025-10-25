package main;

public class BookRecipe {
    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input in = new ConsoleInput();
        String answer = in.requestString("How is the winter?");
        out.println("Yes it is " + answer);
    }
}
