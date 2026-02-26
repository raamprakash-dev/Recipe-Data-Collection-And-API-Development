package com.example.recipes.entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String cuisine;

    @Column(nullable = true)
    private Float rating;

    @JsonProperty("prep_time")
    @Column(name = "prep_time")
    private Integer prepTime;

    @JsonProperty("cook_time")
    @Column(name = "cook_time")
    private Integer cookTime;

    @JsonProperty("total_time")
    @Column(name = "total_time")
    private Integer totalTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> nutrients;

    private String serves;

    public Recipe() {
    }

    @PrePersist
    private void calculateTotalTime() {
        int prep = (prepTime != null) ? prepTime : 0;
        int cook = (cookTime != null) ? cookTime : 0;
        this.totalTime = prep + cook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getNutrients() {
        return nutrients;
    }

    public void setNutrients(Map<String, Object> nutrients) {
        this.nutrients = nutrients;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }
}