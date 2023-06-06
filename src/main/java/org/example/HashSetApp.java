package org.example;

import java.util.HashSet;

class Person {
    String name;
    Person(String name) { this.name = name; }
    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
public class HashSetApp {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("Иван");
        Person p2 = new Person("Мария");
        Person p3 = new Person("Пётр");
        Person p4 = new Person("Мария");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.print(set.size());
    }
}
