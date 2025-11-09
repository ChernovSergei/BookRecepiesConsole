package main;

public class CommandCreateRecipe extends Command {
    StringBuilder recipeMenu = new StringBuilder();

    public CommandCreateRecipe(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        String recipeName = in.requestString("Enter new recipe name: ");
        Recipe newRecipe = new Recipe(recipeName);
        MenuRecipeCreate menuRecipeCreate = new MenuRecipeCreate(in, out, newRecipe);
        menuRecipeCreate.showMenuRecipe();
    }
}
