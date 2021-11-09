package org.example.data.structure.interfacesd;

public interface Address {

    default void show() {
        System.out.println("Inside Address");
    }
}
