package model;

public class Payroll {
    private String month;
    private String id;
    private double accruedAmount;
    private double withheldAmount;
    private double amountToPayoff;

    public Payroll(String month, String id, double accruedAmount, double withheldAmount, double amountToPayoff) {
        this.month = month;
        this.id = id;
        this.accruedAmount = accruedAmount;
        this.withheldAmount = withheldAmount;
        this.amountToPayoff = amountToPayoff;
    }

    public Payroll() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAccruedAmount() {
        return accruedAmount;
    }

    public void setAccruedAmount(double accruedAmount) {
        this.accruedAmount = accruedAmount;
    }

    public double getWithheldAmount() {
        return withheldAmount;
    }

    public void setWithheldAmount(double withheldAmount) {
        this.withheldAmount = withheldAmount;
    }

    public double getAmountToPayoff() {
        return amountToPayoff;
    }

    public void setAmountToPayoff(double amountToPayoff) {
        this.amountToPayoff = amountToPayoff;
    }
}
