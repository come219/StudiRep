package com.example.studirep;

public class RecipeModal {
    private String recipeName;
    private String recipeIngredient;
    private String cookTime;
    private String method;
    private int id;


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

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RecipeModal( String recipeName, String recipeIngredient, String cookTime, String method){
        this.recipeName = recipeName;
        this.recipeIngredient = recipeIngredient;
        this.cookTime = cookTime;
        this.method = method;
    }

}
