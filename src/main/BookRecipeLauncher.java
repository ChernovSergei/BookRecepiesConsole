package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BookRecipeLauncher {
    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input in = new ConsoleInput();
        String answer = in.requestString("How is the winter?");
        out.println("Yes it is " + answer);
        Tool knife = new Tool("knife");
        Product tomato = new Product("tomato", "vegetable");
        Action cut = new Action("cut");
        RecipeStep cutTomato = new RecipeStep(tomato, knife, cut);
        Recipe borsh = new Recipe("Borsh");
        List<RecipeStep> steps = new LinkedList<>();
        steps.add(cutTomato);
        borsh.setSteps(steps);
        RecipeBook myRecipes = new RecipeBook();
        HashMap<Integer, Recipe> recipes = new HashMap<>();
        recipes.put(1, borsh);
        myRecipes.setRecipes(recipes);
        String result = JSONRecipeBookConverter.recipeBookToJson(myRecipes);
        out.println(result);
        //String response = JsonClient.getAllRecipes();
        //out.println(response);
    }
}
