package com.yas.java8features;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Yas
 */
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

    //foreach loop
    List<String> list =new ArrayList<String>();
    list.add("yasitha");
    list.add("thilantha");
    list.add("banamuwage");
    list.forEach((n)->System.out.println(n));

    //Comparator
    List<Product> productList =new ArrayList<Product>();
    productList.add(new Product(3,"pro3",30));
    productList.add(new Product(1,"pro1",10));
    productList.add(new Product(2,"pro2",20));
    productList.add(new Product(4,"pro4",40));
    productList.add(new Product(5,"pro5",40));

    Collections.sort(productList, (p1,p2)->{
      return p1.name.compareTo(p2.name);
    });

    for(Product p:productList){
      System.out.println(p.id+" "+p.name+" "+p.price);
    }

    //Filter collection data
    Stream<Product> filteredList =  productList.stream().filter(product -> product.price>30);
    filteredList.forEach(product -> System.out.println(product.price));

    //Event listener
    JTextField jTextField = new JTextField();
    jTextField.setBounds(50, 50,150,20);
    JButton button =new JButton("click");
    button.setBounds(80,100,70,30);

    button.addActionListener(e -> jTextField.setText("text comes under lambda!"));
    JFrame f=new JFrame();
    f.add(jTextField);f.add(button);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setSize(300, 200);
    f.setVisible(true);
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

  static class Product{

    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
      this.id = id;
      this.name = name;
      this.price = price;
    }
  }
}
