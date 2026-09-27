package model;

public class User {
    private String userId;
    private LevelType levelType;
    private double points;

    public int getCurrentOrderCount() {
        return currentOrderCount;
    }

    public void setCurrentOrderCount(int currentOrderCount) {
        this.currentOrderCount = currentOrderCount;
    }

    private int currentOrderCount;

    public User(String userId) {
        this.userId= userId;
        levelType= LevelType.Bronze;
        points= 0.0;
        currentOrderCount= 0;
    }

    public String getUserId() {
        return userId;
    }

    public void setLevelType(LevelType levelType) {
        this.levelType = levelType;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }

    public LevelType getLevelType() {
        return levelType;
    }
}
