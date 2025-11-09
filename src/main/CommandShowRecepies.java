package main;

import java.util.Map;

public class CommandShowRecepies extends Command {

    public CommandShowRecepies(Input in, Output out) {
        super(in, out);
    }

    public void execute() {
        String listOfRecipes = JSONClient.getAllRecipes();
        Map<String, String> recipeNames = JSONRecipeBookConverter.jsonToRecipeList(listOfRecipes);
        recipeNames.forEach((id, name) -> System.out.println(id + " " + name));
    }
}
