package main;

public class CommandCallCreateMenu extends Command {

    public CommandCallCreateMenu(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        String recipeName = in.requestString("Enter new recipe name: ");
        Recipe newRecipe = new Recipe(recipeName);
        Menu menuRecipeCreate = new MenuRecipeCreate(in, out, newRecipe);
        menuRecipeCreate.showMenu();
    }
}