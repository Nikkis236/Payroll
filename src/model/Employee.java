package model;

public class Employee {
    private String id;
    private String lastName;
    private int category;
    private String post;
    private boolean tradeUnion;

    public Employee(String id, String lastName, int category, String post, boolean tradeUnion) {
        this.id = id;
        this.lastName = lastName;
        this.category = category;
        this.post = post;
        this.tradeUnion = tradeUnion;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public boolean isTradeUnion() {
        return tradeUnion;
    }

    public void setTradeUnion(boolean tradeUnion) {
        this.tradeUnion = tradeUnion;
    }
}
