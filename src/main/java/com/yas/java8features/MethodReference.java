package com.yas.java8features;

import java.util.function.BiFunction;

public class MethodReference
{
  public static void main(String[] args)
  {

    //used to refer method of functional interface.

    //Reference to a static method.
    //Reference to an instance method.
    //Reference to a constructor.

    //Static method
    //ClassName::staticMethodName
    Greetings greetings = MethodReference::greeting;
    greetings.sayHello();

    BiFunction<Integer, Integer, Integer> adder = MethodReference::add;
    int result = adder.apply(1,2);
    System.out.println(result);

  }

  public static void greeting(){
    System.out.println("Hello !");
  }

  public static  int add(int x, int y){
    return x+y;
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
