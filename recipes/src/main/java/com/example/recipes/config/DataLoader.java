package com.example.recipes.config;

import com.example.recipes.entity.Recipe;
import com.example.recipes.repository.RecipeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final RecipeRepository recipeRepository;

    public DataLoader(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (recipeRepository.count() > 0) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream = getClass().getResourceAsStream("/US_recipes_null.json");

        if (inputStream == null) {
            throw new RuntimeException("JSON file not found in resources");
        }

        JsonNode rootNode = mapper.readTree(inputStream);

        List<Recipe> recipes = mapper.convertValue(
                rootNode.elements(),
                new TypeReference<List<Recipe>>() {
                });

        recipeRepository.saveAll(recipes);
    }
}