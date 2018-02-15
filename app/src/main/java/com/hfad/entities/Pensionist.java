package com.hfad.entities;

/**
 * Created by Jens Christian Rasch on 15-02-2018.
 */

public class Pensionist extends Person {

    int retirementYear;

    public Pensionist(String name, int age, int retirementYear) {
        super(name, age);
        this.retirementYear = retirementYear;
    }

    @Override
    public String toString() {
        return super.toString() + ". Retired in " + retirementYear;
    }
}
