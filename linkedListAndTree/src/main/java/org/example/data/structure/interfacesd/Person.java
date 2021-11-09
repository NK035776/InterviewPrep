package org.example.data.structure.interfacesd;

public class Person extends Age implements Address, Name {

    public static void main(String[] args) {
        Person obj = new Person();
        Age obj1 = new Age();
        obj.show();
        obj1.show();
//        obj.show();

        ((Address) obj).show();

    }

    @Override
    public void show() {
        System.out.println("Person");
    }
}
