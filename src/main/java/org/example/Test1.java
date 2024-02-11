package org.example;

import java.lang.*;
import java.util.HashSet;

class Person1 {
    int id;
    String name;
    Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() { return id + ": " + name; }

    @Override
    public int hashCode() {
        System.out.println(id%2);
        return id%2;
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (!(ob instanceof Person1)) return false;
        Person1 person = (Person1) ob;
        return this.name.equals(person.name);
    }
}

// The main method must be in a class named "Main".
class Test1 {
    public static void main(String[] args) {
        HashSet<Person1> set = new HashSet<>(1);
        Person1 p1 = new Person1(1, "Иван");
        Person1 p2 = new Person1(2, "Мария");
        Person1 p3 = new Person1(3, "Пётр");
        Person1 p4 = new Person1(4, "Мария");
        Person1 p5 = new Person1(5, "Вася");
        Person1 p6 = new Person1(6, "Катя");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        System.out.print("size: " + set.size());
    }
}
