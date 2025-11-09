package main;

public class CommandDeleteRecipeStep extends Command {

    public CommandDeleteRecipeStep(Input in, Output out, Recipe recipe) {
        super(in, out, recipe);
    }

    @Override
    public void execute() {
        super.recipe.getSteps().remove(in.requestInteger("Enter step number to remove: "));
    }
}
