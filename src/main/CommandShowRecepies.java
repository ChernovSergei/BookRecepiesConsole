package main;

import java.util.Map;

public class CommandShowRecepies extends Command {

    public CommandShowRecepies(Input in, Output out) {
        super(in, out);
    }

    public void execute() {
        String listOfRecipes = BookRecepiesClient.getAllRecipes();
        Map<String, String> recipeNames = JSONRecipeBookConverter.jsonToRecipeList(listOfRecipes);
        recipeNames.forEach((id, name) -> super.out.println(id + " " + name));
    }
}
