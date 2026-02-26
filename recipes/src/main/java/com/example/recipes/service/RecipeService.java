package com.example.recipes.service;

import com.example.recipes.entity.Recipe;
import com.example.recipes.repository.RecipeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getTopRecipes(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return recipeRepository.findAllByOrderByRatingDesc(pageable);
    }

}