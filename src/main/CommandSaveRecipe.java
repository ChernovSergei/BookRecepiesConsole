package main;

public class CommandSaveRecipe extends Command {

    public CommandSaveRecipe(Input in, Output out, Recipe recipe) {
        super(in, out, recipe);
    }

    @Override
    public void execute() {
        String newRecipe = JSONRecipeConverter.recepieToJson(super.recipe);
        out.print(newRecipe);
        JSONClient.saveRecipe(newRecipe);
    }
}
