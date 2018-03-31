package com.yas.java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsHandler
{
  public static void main(String[] args)
  {
    List<Product> productsList = new ArrayList<Product>();

    productsList.add(new Product(1, "p1", 100));
    productsList.add(new Product(2, "p2", 200));
    productsList.add(new Product(3, "p3", 300));
    productsList.add(new Product(4, "p4", 400));
    productsList.add(new Product(5, "p5", 500));

    //fetching each product price and return as list.
    List<Integer> priceList = productsList.stream().map(product -> product.price).collect(Collectors.toList());
    System.out.println(priceList);

    //count elements using collectors
    Long count = productsList.stream().collect(Collectors.counting());
    System.out.println(count);

    //calculate sum of the price
    int sum = productsList.stream().collect(Collectors.summingInt(p -> p.price));
    System.out.println(sum);

    //Fetching each product with price list law than 500 and return as list
    List<Product> filteredList = productsList.stream().
      filter(product -> product.price < 500).collect(Collectors.toList());
    System.out.println(filteredList.size());

    //Filtering and Iterating Collection
    productsList.stream().filter(product -> product.price < 500).forEach(product -> System.out.println(product.name));

  }

  static class Product
  {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price)
    {
      this.id = id;
      this.name = name;
      this.price = price;
    }
  }
}
