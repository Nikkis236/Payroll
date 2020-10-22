package model;

public class Salary {

    private String month;
    private int minSalary;

    public Salary(String month, int minSalary) {
        this.month = month;
        this.minSalary = minSalary;
    }

    public Salary() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
}
