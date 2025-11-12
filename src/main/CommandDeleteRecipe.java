package main;

public class CommandDeleteRecipe extends Command {

    public CommandDeleteRecipe(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        int recipeId = in.requestInteger("Which recipe you would like to delete?");
        BookRecepiesClient.deleteRecipe(recipeId);
    }
}
