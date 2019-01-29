package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.optJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsJsonArray = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>(alsoKnownAsJsonArray.length());
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsJsonArray.getString(i));
            }

            String placeOfOrigin = (String) jsonObject.get("placeOfOrigin");
            String description = (String) jsonObject.get("description");
            String image = (String) jsonObject.get("image");
            JSONArray ingredientsJsonArray = jsonObject.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>(ingredientsJsonArray.length());
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredientsList.add(ingredientsJsonArray.getString(i));
            }

            sandwich.setAlsoKnownAs(alsoKnownAsList);
            sandwich.setMainName(mainName);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredientsList);

            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
