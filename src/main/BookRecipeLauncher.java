package main;

//TODO create mode in a menu (e.g menu #7) which will generate specified number of random recipes
// each recipe will be saved on the server side

public class BookRecipeLauncher {
    public static void main(String[] args) {
        Output out = new OutputConsole();
        Input in = new InputConsole();
        Menu menuMain = new MenuMain(in, out);
        menuMain.showMenu();
    }
}
