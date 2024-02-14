package model;

import exception.NegativeNumberException;

public class Ingredient {

    private String name;

    private double weight;

    private void validateWeight(double weight) {

        if (weight < 0)
            throw new NegativeNumberException();

    }

    public Ingredient(String name, double weight) {

        validateWeight(weight);

        this.name = name;
        this.weight = weight;

    }

    public void addWeight(double weight) {

        validateWeight(weight);
        this.weight += weight;

    }

    public void removeWeight(double weight) {

        validateWeight(weight);
        this.weight -= weight;

    }

    public String getName() {

        return name;

    }

    public double getWeight() {

        return weight;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setWeight(double weight) {

        validateWeight(weight);
        this.weight = weight;

    }

}
