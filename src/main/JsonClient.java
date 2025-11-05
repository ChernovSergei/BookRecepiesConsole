package main;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JsonClient {
    public static String getAllRecipes() {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL("http://localhost:8080/api/recipeNames");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public static void deleteRecipe(int id) {
        try {
            URL url = new URL("http://localhost:8080/api/delete/recipe/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveRecipe(String recipe) {
        try {
            URL url = new URL("http://localhost:8080/api/save/recipe");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = recipe.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int error = connection.getResponseCode();
            System.out.println(error);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getRecipe(int id) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL("http://localhost:8080/api/get/recipe/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public static void updateRecipe(String recipe) {
        try {
            URL url = new URL("http://localhost:8080/api/update/recipe");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = recipe.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int error = connection.getResponseCode();
            System.out.println(error);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
