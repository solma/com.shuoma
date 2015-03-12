package com.shuoma.alg.number;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class NumbersContainCertainDigitTest extends TestCase {

  @Test
  public void testCount() throws Exception {
    NumbersContainCertainDigit ins = new NumbersContainCertainDigit();
    int n = 232;
    char k = '7';
    System.out.println(ins.find(n, k).size() + "\n" + findDummy(n, k).size());
  }

  List<Integer> findDummy(int n, char k) {
    List<Integer> numbers = new LinkedList<>();
    for (int i = 1; i < n; i++) {
      if (!String.valueOf(i).contains(String.valueOf(k))) {
        continue;
      }
      numbers.add(i);
    }
    return numbers;
  }
}