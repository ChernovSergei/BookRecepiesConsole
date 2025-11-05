package main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    Output out;
    Input in;
    StringBuilder mainMenu = new StringBuilder();
    StringBuilder recipeMenu = new StringBuilder();
    String recipeStep = "-%s %s the %s using %s";
    Map<Integer, Command> commands = new HashMap<>();

    public Menu (Input in, Output out) {
        this.out = out;
        this.in = in;
        mainMenu.append("==============================================\n");
        mainMenu.append("1. Show recipes.  ");
        mainMenu.append("2. Show a recipe. ");
        mainMenu.append("3. Create.        \n");
        mainMenu.append("4. Update.        ");
        mainMenu.append("5. Delete.        ");
        mainMenu.append("6. Exit           \n");
        mainMenu.append("==============================================\n");
        commands.put(1, new ShowRecepiesCommand(in, out));
        commands.put(2, new ShowRecepieCommand(in, out));
        commands.put(3, new EditRecipeCommand(in, out));
        commands.put(4, new UpdateRecipeCommand(in, out));
        commands.put(5, new DeleteRecipeCommand(in, out));
        commands.put(6, new ExitCommand(in, out));
    }

    public void showMainMenu() {
        int answer = 0;
        while (answer != 6) {
            out.print(mainMenu.toString());
            answer = in.requestInteger("Enter option #: ");
            commands.get(answer).execute();
            /*switch (answer) {
                case 1:
                    getRecipeNames().forEach((id, name) -> System.out.println(id + " " + name));
                    break;
                case 2:
                    showRecipe(getRecipe(in.requestInteger("Which recipe you would like to see?")));
                    break;
                case 3:
                    String recipeName = in.requestString("Enter new recipe name: ");
                    Recipe newRecipe = new Recipe(recipeName);
                    createRecipe(newRecipe);
                    break;
                case 4:
                    int recipeId = in.requestInteger("Which recipe you would like to update");
                    Recipe recipeToUpgrade = getRecipe(recipeId);
                    showRecipe(recipeToUpgrade);
                    upgradeRecipe(recipeToUpgrade);
                    break;
                case 5:
                    deleteRecipe(in.requestInteger("Which recipe you would like to delete"));
                    break;
                case 6:
                    out.println("Exit implemented.");
                    break;
                default:
                    out.print("Incorrect number had been entered. ");
                    out.println("Enter correct number.");*/
            //}
        }
    }

    public Map<String, String> getRecipeNames() {
        String listOfRecipes = JsonClient.getAllRecipes();
        return JSONRecipeBookConverter.jsonToRecipeList(listOfRecipes);
    }

    public Recipe getRecipe(int recipeId) {
        String recipeInJSON = JsonClient.getRecipe(recipeId);
        return JSONRecipeConverter.jsonToRecepie(recipeInJSON);
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

    public void createRecipe(Recipe newRecipe) {
        int subAnswer = 0;
        while (subAnswer != 6) {
            out.println(recipeMenu);
            subAnswer = in.requestInteger("Enter option #: ");
            switch (subAnswer) {
                case 1:
                    String recipeName = in.requestString("Rename recipe: ");
                    newRecipe.setName(recipeName);
                    break;
                case 2:
                    int stepNumber = in.requestInteger("Enter step number to edit: ");
                    newRecipe.getSteps().set(stepNumber, createRecipeStep());
                    break;
                case 3:
                    newRecipe.getSteps().add(createRecipeStep());
                    break;
                case 4:
                    newRecipe.getSteps().remove(in.requestInteger("Enter step number to remove: "));
                    break;
                case 5:
                    String newRecipeJSON = JSONRecipeConverter.recepieToJson(newRecipe);
                    JsonClient.saveRecipe(newRecipeJSON);
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

    public void deleteRecipe(int recipeId) {
        JsonClient.deleteRecipe(recipeId);
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
