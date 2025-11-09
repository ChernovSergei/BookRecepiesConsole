package main;

public class CommandUpdateRecipe extends Command {

    public CommandUpdateRecipe(Input in, Output out, Recipe recipe) {
        super(in, out, recipe);
    }

    @Override
    public void execute() {
        String updatedRecipe = JSONRecipeConverter.recepieToJson(super.recipe);
        JSONClient.updateRecipe(updatedRecipe);
    }
}
