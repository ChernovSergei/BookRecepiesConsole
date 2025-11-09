package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class JSONRecipeBookConverter {

    public static Map<String, String> jsonToRecipeList(String mapInJSON) {
        Gson gsonResult = new GsonBuilder().create();
        Map<String, String> result = gsonResult.fromJson(mapInJSON, HashMap.class);
        return result;
    }
}
