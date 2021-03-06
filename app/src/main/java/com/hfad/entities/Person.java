package com.hfad.entities;

/**
 * Created by Jens Christian Rasch on 08-02-2018.
 */

public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Boolean isOld() {
        return age > 40;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + ", " + age + ", " + (isOld() ? "is old" : "is young");
    }
}
