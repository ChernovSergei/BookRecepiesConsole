package main;

public class CommandCallUpdateMenu extends Command {

    public CommandCallUpdateMenu(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        int recipeId = in.requestInteger("Which recipe you would like to update");
        String recipeInJSON = BookRecepiesClient.getRecipe(recipeId);
        Recipe recipeToUpgrade = JSONRecipeConverter.jsonToRecepie(recipeInJSON);
        MenuRecipeUpdate menuRecipeUpdate = new MenuRecipeUpdate (in, out, recipeToUpgrade);
        menuRecipeUpdate.showMenu();
    }
}
