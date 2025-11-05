package main;

public class BookRecipeLauncher {
    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input in = new ConsoleInput();
        Menu menu = new Menu(in, out);
        menu.showMainMenu();
    }
}
