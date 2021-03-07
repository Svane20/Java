package com.mycompany.foodwaste_project.domain;

public class Time {

    private int hours = 6;

    private int days = 1;

    Time() {

    }

    Time(int days, int hours) {
        this.days = days;
        this.hours = hours;

    }

    public void setDate(int days, int hours) {
        this.days = days;
        this.hours = hours;

    }

    public int getDateOfHours() {
        return hours;

    }

    public int getDateOfDays() {
        return days;

    }

    public void swichDayWithBed() {
        {
        if(this.hours==0)
        {
            this.days+=0;
            this.hours+=6;
        }
        else {
            this.days += 1;
            this.hours = 6;
        }
            
        }
    }

    public void swichDayOutsideOfBedroom() {
        {
        if(this.hours==0)
        {
            this.days+=0;
            this.hours+=16;
        }
        else{
            this.days += 1;
            this.hours = 16;
        }
            
        }
    }

    public void swichHour() {
        if (this.hours == 0) 
        {
        
        } 
        else if (this.hours == 23) 
        {
            this.hours -= 23;
            this.days+=1;
        }
        else 
        {
            this.hours += 1;

        }
    }


}


 

