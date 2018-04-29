package com.example.demo;

import java.util.Random;

public class Util {

  private static String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

  private static Random random = new Random();

  public static String generateString(int length) {
    StringBuilder sb = new StringBuilder();
    while (sb.length() < length) {
      char letter = CHARS.charAt((int) (random.nextFloat() * CHARS.length()));
      if (random.nextBoolean())
        letter = Character.toLowerCase(letter);
      sb.append(letter);
    }
    return sb.toString();
  }

  public static String getFullname(String firstname, String middlename, String lastname) {
    StringBuilder sb = new StringBuilder();

    if (firstname != null && firstname.length() > 0) {
      sb.append(firstname);
      sb.append(" ");
    }
    if (middlename != null && middlename.length() > 0) {
      sb.append(middlename);
      sb.append(" ");
    }
    if (lastname != null && lastname.length() > 0) {
      sb.append(lastname);
      sb.append(" ");
    }

    return sb.toString().trim();
  }
}
