package main;

import java.util.concurrent.atomic.AtomicInteger;

public class CommandShowRecepie extends Command {

    public CommandShowRecepie(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        int recipeId = in.requestInteger("Which recipe you would like to see?");
        String recipeInJSON = JSONClient.getRecipe(recipeId);
        Recipe recipeToShow = JSONRecipeConverter.jsonToRecepie(recipeInJSON);
        showRecipe(recipeToShow);
    }

    public void showRecipe(Recipe storageRecipe) {
        String recipeStep = "-%s %s the %s using %s";
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
}
