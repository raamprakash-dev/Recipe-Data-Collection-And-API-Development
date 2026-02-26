package com.example.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipes.entity.Recipe;
import com.example.recipes.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "*")

public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/top")
    public Map<String, List<Recipe>> getTopRecipes(@RequestParam(defaultValue = "5") int limit) {
        List<Recipe> recipes = recipeService.getTopRecipes(limit);
        return Map.of("data", recipes);
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

}
