package lotto3.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

  private static final Random RANDOM = new Random();

  public static List<Integer> generate() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < 6) {
      int number = RANDOM.nextInt(45) + 1;
      addNum(numbers, number);
    }
    return numbers;
  }
  private static void addNum(List<Integer> numbers, int number) {
    if (!hasNumber(numbers, number)) {
      numbers.add(number);
    }
  }

  private static boolean hasNumber(List<Integer> numbers, int number) {
    return numbers.contains(number);
  }

}
