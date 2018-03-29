package com.yas.java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces
{
  public static void main(String[] args)
  {
    //BiConsumer
    BiConsumer<String, String> biConsumer = (a, b) -> {
      System.out.println(a);
      System.out.println(b);
    };

    biConsumer.accept("functional", " interfaces");

    //Consumer
    Consumer<String> consumer = FunctionalInterfaces::seyHello;
    consumer.accept("Consumer with method reference");

    //Function
    Function<List<Integer>, Integer> function = (list) -> {
      return list.stream().mapToInt(Integer::intValue).sum();
    };

    List<Integer> list = new ArrayList<>();
    list.add(12);
    list.add(23);
    list.add(44);
    list.add(54);

    System.out.println(function.apply(list));

    //Predicate
    Predicate<Integer> predicate = FunctionalInterfaces::isNumberlagerThanTen;
    System.out.println(predicate.test(9));

  }

  public static void seyHello(String string)
  {
    System.out.println(string);
  }

  public static boolean isNumberlagerThanTen(int number)
  {
    return number > 10;
  }
}
