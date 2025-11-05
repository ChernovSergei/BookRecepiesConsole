package main;

import java.util.concurrent.atomic.AtomicInteger;

public class ShowRecepieCommand extends Command {
    String recipeStep = "-%s %s the %s using %s";

    public ShowRecepieCommand(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        showRecipe(getRecipe(in.requestInteger("Which recipe you would like to see?")));
    }

    public void showRecipe(Recipe storageRecipe) {
        out.println(storageRecipe.getName());
        AtomicInteger stepIndex = new AtomicInteger(0);
        storageRecipe.getSteps().forEach(step -> {
            int index = stepIndex.getAndIncrement();
            String action = step.getAction().getName();
            String product = step.getProduct().getName();
            String tool = step.getTool().getName();
            out.println(String.format(recipeStep, index, action, product, tool));
        });
    }

    public Recipe getRecipe(int recipeId) {
        String recipeInJSON = JsonClient.getRecipe(recipeId);
        return JSONRecipeConverter.jsonToRecepie(recipeInJSON);
    }
}
