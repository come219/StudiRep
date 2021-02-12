package com.example.searching;

public class Recipe {
    private int id;
    private String recipeName;
    private String recipeIngredient;
    private String recipeMethod;
    private int recipeTime;

    public Recipe(int id, String recipeName,String recipeIngredient,String recipeMethod,int recipeTime) {
        this.id=id;
        this.recipeName=recipeName;
        this.recipeIngredient=recipeIngredient;
        this.recipeMethod=recipeMethod;
        this.recipeTime = recipeTime;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredient='" + recipeIngredient + '\'' +
                ", recipeMethod='" + recipeMethod + '\'' +
                ", recipeTime=" + recipeTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(String recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    public String getRecipeMethod() {
        return recipeMethod;
    }

    public void setRecipeMethod(String recipeMethod) {
        this.recipeMethod = recipeMethod;
    }

    public int getRecipeTime() {
        return recipeTime;
    }

    public void setRecipeTime(int recipeTime) {
        this.recipeTime = recipeTime;
    }
}
