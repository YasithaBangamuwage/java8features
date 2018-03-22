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

  }

  @FunctionalInterface
  interface Greetings
  {

    void sayHello();
  }

}
