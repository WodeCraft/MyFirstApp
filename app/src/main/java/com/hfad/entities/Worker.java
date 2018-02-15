package com.hfad.entities;

/**
 * Created by Jens Christian Rasch on 15-02-2018.
 */

public class Worker extends Person {

    public float pay;

    public Worker(String name, int age, float pay) {
        super(name, age);
        this.pay = pay;
    }

    @Override
    public String toString() {
        return super.toString() + ". The salary is: " + pay;
    }
}
