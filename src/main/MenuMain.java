package main;

import java.util.HashMap;
import java.util.Map;

public class MenuMain implements Menu {
    Output out;
    Input in;
    StringBuilder mainMenu = new StringBuilder();
    Map<Integer, Command> commands = new HashMap<>();

    public MenuMain(Input in, Output out) {
        this.out = out;
        this.in = in;
        mainMenu.append("==================MAIN MENU===================\n");
        mainMenu.append("1. Show recipes.  ");
        mainMenu.append("2. Show a recipe. ");
        mainMenu.append("3. Create recipe. \n");
        mainMenu.append("4. Edit recipe.   ");
        mainMenu.append("5. Delete recipe. ");
        mainMenu.append("6. Exit           \n");
        mainMenu.append("==============================================\n");
        commands.put(1, new CommandShowRecepies(in, out));
        commands.put(2, new CommandShowRecepie(in, out));
        commands.put(3, new CommandCallCreateMenu(in, out));
        commands.put(4, new CommandCallUpdateMenu(in, out));
        commands.put(5, new CommandDeleteRecipe(in, out));
        commands.put(6, new CommandExitMenu(in, out));
    }

    public void showMenu() {
        int answer = 0;
        while (answer != 6) {
            out.print(mainMenu.toString());
            answer = in.requestInteger("Enter option #: ");
            commands.get(answer).execute();
        }
    }
}
