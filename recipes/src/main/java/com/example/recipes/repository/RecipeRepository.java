package com.example.recipes.repository;

import com.example.recipes.entity.Recipe;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> findAllByOrderByRatingDesc(Pageable pageable);

}