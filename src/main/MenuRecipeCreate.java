package main;

import java.util.HashMap;
import java.util.Map;

public class MenuRecipeCreate {
    Output out;
    Input in;
    StringBuilder recipeMenu = new StringBuilder();
    Map<Integer, Command> commands = new HashMap<>();
    Recipe recipe = null;

    public MenuRecipeCreate(Input in, Output out, Recipe recipe) {
        this.out = out;
        this.in = in;
        this.recipe = recipe;
        recipeMenu.append("================NEW RECIPE MENU===============\n");
        recipeMenu.append("1. Edit name      ");
        recipeMenu.append("2. Add Step.      \n");
        recipeMenu.append("3. Update Step.   ");
        recipeMenu.append("4. Delete Step.   \n");
        recipeMenu.append("5. Save Recipe.   ");
        recipeMenu.append("6. Exit to main.  \n");
        recipeMenu.append("==============================================\n");
        commands.put(1, new CommandNameRecipe(in, out, recipe));
        commands.put(2, new CommandAddRecipeStep(in, out, recipe));
        commands.put(3, new CommandUpdateRecipeStep(in, out, recipe));
        commands.put(4, new CommandDeleteRecipeStep(in, out, recipe));
        commands.put(5, new CommandSaveRecipe(in, out, recipe));
        commands.put(6, new CommandExitMenu(in, out));
    }

    public void showMenuRecipe() {
        int answer = 0;
        while (answer != 6) {
            out.print(recipeMenu.toString());
            answer = in.requestInteger("Enter option #: ");
            commands.get(answer).execute();
        }
    }
}
