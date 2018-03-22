package com.yas.java8features;

public class LambdaExpressionApp
{
  public static void main(String[] args)
  {
    //used to provide the implementation of an interface which has functional interface.
    //An interface which has only one abstract method is called functional interface
    //lambda expression is treated as a function, so compiler does not create .class file.

    //Syntax
    //(argument-list) -> {body}

    //without parameters
    //before lambda
    Greetings g = new Greetings()
    {
      @Override public void sayHello()
      {
        System.out.println("Hello");
      }
    };
    g.sayHello();

    //after lambda
    Greetings g2 = () -> System.out.println("Hello with lambda!");
    g2.sayHello();

    //with parameter
    Calculator c1 = (a,b)->a+b;
    System.out.println(c1.add(2,2));

    Calculator c2 = (a,b)->{return (a+b);};
    System.out.println(c2.add(2,2));

  }

  @FunctionalInterface
  interface Greetings
  {
    void sayHello();
  }

  @FunctionalInterface
  interface Calculator
  {
    int add(int x, int y);
  }
}
