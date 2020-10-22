package model;

public class Tariff {
    private int category;
    private double coefficient;

    public Tariff(int category, double coefficient) {
        this.category = category;
        this.coefficient = coefficient;
    }

    public Tariff() {
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
}
