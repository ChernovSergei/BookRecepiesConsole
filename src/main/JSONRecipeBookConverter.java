package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class JSONRecipeBookConverter {
    public static RecipeBook jsonToRecipeBook(String bookInJSON) {
        Gson gsonResult = new GsonBuilder().create();
        return gsonResult.fromJson(bookInJSON, RecipeBook.class);
    }

    public static String recipeBookToJson(RecipeBook recipeBook) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(recipeBook);
    }

    public static Map<String, String> jsonToRecipeList(String mapInJSON) {
        Gson gsonResult = new GsonBuilder().create();
        Map<String, String> result = gsonResult.fromJson(mapInJSON, HashMap.class);
        return result;
    }
}
