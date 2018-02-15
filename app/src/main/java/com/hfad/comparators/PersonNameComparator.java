package com.hfad.comparators;

import com.hfad.entities.Person;

import java.util.Comparator;

/**
 * Created by Jens Christian Rasch on 15-02-2018.
 */

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getName().compareToIgnoreCase(person2.getName());
    }

}
