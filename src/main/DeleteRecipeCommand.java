package main;

public class DeleteRecipeCommand extends Command {

    public DeleteRecipeCommand(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        deleteRecipe(in.requestInteger("Which recipe you would like to delete"));
    }

    public void deleteRecipe(int recipeId) {
        JsonClient.deleteRecipe(recipeId);
    }
}
