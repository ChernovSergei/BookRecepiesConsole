package main;

public class CommandAddRecipeStep extends Command {

    public CommandAddRecipeStep(Input in, Output out, Recipe recipe) {
        super(in, out, recipe);
    }

    @Override
    public void execute() {
        super.recipe.getSteps().add(createRecipeStep());
    }

    public RecipeStep createRecipeStep() {
        String action = in.requestString("Enter action: ");
        String product = in.requestString("Enter product: ");
        String productType = in.requestString("Enter productType: ");
        String tool = in.requestString("Enter tool: ");
        Action actionObject = new Action(action);
        Product productObject = new Product(product, productType);
        Tool toolObject = new Tool(tool);
        RecipeStep newRecipeStep = new RecipeStep(productObject, toolObject, actionObject);
        return newRecipeStep;
    }
}
