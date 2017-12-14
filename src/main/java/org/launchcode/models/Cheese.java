package org.launchcode.models;

import javax.validation.constraints.*;

public class Cheese {

    @NotNull // Validation
    @Size(min=3, max=75)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    private CheeseType type;
    private int cheeseId;
    private static int nextId = 1;

    // as with below, can use Cheese(String aName...)
    public Cheese(String name, String description) {
        this(); // This syntax says "call the default constructor for the given class"
        // needs to be first line of constructor
        // Can also use name = aName;
        this.name = name;
        this.description = description;
    }

    public Cheese() { // Called a default or no-arg constructor
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
