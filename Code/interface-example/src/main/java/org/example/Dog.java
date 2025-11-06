package org.example;

public class Dog implements Pet {

    private String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void voice() {
        System.out.println("Hu! Hu!");
    }

    @Override
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("zwierzak bazwi się");
    }
}
