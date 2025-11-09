package main;

public class CommandNameRecipe extends Command {

    public CommandNameRecipe(Input in, Output out, Recipe recipe) {
        super(in, out, recipe);
    }

    @Override
    public void execute() {
        String recipeName = in.requestString("Enter new recipe name: ");
        super.recipe.setName(recipeName);
    }
}
