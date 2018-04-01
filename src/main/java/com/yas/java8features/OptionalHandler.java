package com.yas.java8features;

import java.util.Optional;

public class OptionalHandler

{
  public static void main(String[] args)
  {
    //Basic example
    String[] str = new String[10];
    str[5] = "String data";  // Setting value for 5th index
    Optional<String> checkNull = Optional.ofNullable(str[5]);

    // checkNull.ifPresent((a)->{System.out.println(a);});
    checkNull.ifPresent(System.out::println);
    System.out.println(checkNull.filter(a -> a.equals("String data")));
    System.out.println(checkNull.filter(a -> a.equals("ddd")));
    System.out.println(checkNull.orElse("test"));
    checkNull.ifPresent(System.out::println);
  }
}
