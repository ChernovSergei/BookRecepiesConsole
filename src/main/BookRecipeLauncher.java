package main;

public class BookRecipeLauncher {
    public static void main(String[] args) {
        Output out = new OutputConsole();
        Input in = new InputConsole();
        MenuMain menuMain = new MenuMain(in, out);
        menuMain.showMainMenu();
    }
}
