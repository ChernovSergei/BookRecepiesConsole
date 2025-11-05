package main;

import java.util.Map;

public class ShowRecepiesCommand extends Command {

    public ShowRecepiesCommand(Input in, Output out) {
        super(in, out);
    }

    public void execute() {
        getRecipeNames().forEach((id, name) -> System.out.println(id + " " + name));
    }
    public Map<String, String> getRecipeNames() {
        String listOfRecipes = JsonClient.getAllRecipes();
        return JSONRecipeBookConverter.jsonToRecipeList(listOfRecipes);
    }
}
