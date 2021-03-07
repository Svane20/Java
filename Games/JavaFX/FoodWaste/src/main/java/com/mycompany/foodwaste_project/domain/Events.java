package com.mycompany.foodwaste_project.domain;

public class Events {
    
    private final String description;
    private boolean isFinished = false;
    private final double minusBalance;
    private final int day;
    
    
    public Events(int day, String description, double minusBalance)
    {
        this.description = description;
        this.minusBalance = minusBalance;
        this.day = day;
        
    }
    
    public void setEventTrue()
    {
        isFinished = true;
    }
    
    public boolean getIsFinished()
    {
        return isFinished;
    }
            
    public void printDescription()
    {
        System.out.println(description);
    }
    
    public String getDescription()
    {
        return description;
    }
    public double getPenalty()
    {
        return minusBalance;
    }
    
    public int getDay()
    {
        return day;
    }
}
