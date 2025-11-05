package main;

public class UpdateRecipeCommand extends Command {
    StringBuilder recipeMenu = new StringBuilder();

    public UpdateRecipeCommand(Input in, Output out) {
        super(in, out);
        recipeMenu.append("==============================================\n");
        recipeMenu.append("1. Rename recipe. ");
        recipeMenu.append("2. Update Step.   \n");
        recipeMenu.append("3. Add Step.      ");
        recipeMenu.append("4. Delete Step.   \n");
        recipeMenu.append("5. Save.          ");
        recipeMenu.append("6. Exit to main.  \n");
        recipeMenu.append("==============================================\n");
    }

    @Override
    public void execute() {
        int recipeId = in.requestInteger("Which recipe you would like to update");
        Recipe recipeToUpgrade = getRecipe(recipeId);
        upgradeRecipe(recipeToUpgrade);
    }

    public Recipe getRecipe(int recipeId) {
        String recipeInJSON = JsonClient.getRecipe(recipeId);
        return JSONRecipeConverter.jsonToRecepie(recipeInJSON);
    }

    public void upgradeRecipe(Recipe storageRecipe) {
        int subAnswer = 0;
        while (subAnswer != 6) {
            out.println(recipeMenu);
            subAnswer = in.requestInteger("Enter option #: ");
            switch (subAnswer) {
                case 1:
                    String recipeName = in.requestString("Enter new recipe name: ");
                    storageRecipe.setName(recipeName);
                    break;
                case 2:
                    int stepNumber = in.requestInteger("Enter step number to edit: ");
                    storageRecipe.getSteps().set(stepNumber, createRecipeStep());
                    break;
                case 3:
                    storageRecipe.getSteps().add(createRecipeStep());
                    break;
                case 4:
                    storageRecipe.getSteps().remove(in.requestInteger("Enter step number to remove: "));
                    break;
                case 5:
                    String updatedRecipe = JSONRecipeConverter.recepieToJson(storageRecipe);
                    JsonClient.updateRecipe(updatedRecipe);
                    break;
                case 6:
                    out.println("Exit to the main menu.");
                    break;
                default:
                    out.print("Incorrect number had been entered. ");
                    out.println("Enter correct number.");
            }
        }
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
