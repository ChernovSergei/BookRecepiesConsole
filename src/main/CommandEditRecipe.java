package main;

public class CommandEditRecipe extends Command {

    public CommandEditRecipe(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        int recipeId = in.requestInteger("Which recipe you would like to update");
        String recipeInJSON = JSONClient.getRecipe(recipeId);
        Recipe recipeToUpgrade = JSONRecipeConverter.jsonToRecepie(recipeInJSON);
        MenuRecipeUpdate menuRecipeUpdate = new MenuRecipeUpdate (in, out, recipeToUpgrade);
        menuRecipeUpdate.showMenuRecipe();
    }
}
