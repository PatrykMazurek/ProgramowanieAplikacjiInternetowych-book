package org.example;

public interface Pet extends Animal {

    void play();

    default void sleep(){
        System.out.println("zwierzak poszedł spać");
    }
}
