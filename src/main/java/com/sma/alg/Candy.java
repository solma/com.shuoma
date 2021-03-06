package com.sma.alg;

import static com.sma.annotation.Tag.DataStructure.Array;
import static com.sma.annotation.Tag.Reference.LeetCode;
import static com.sma.annotation.Tag.Trick.ForwardAndBackwardScan;

import com.sma.annotation.Tag;

@Tag(dss = Array, references = LeetCode, tricks = ForwardAndBackwardScan)
public class Candy {
  public int candy(int[] ratings) {
    int n = ratings.length;
    if (n == 0) { return 0; }

    int[] left = new int[n], right = new int[n];

    int cur = 1;
    for (int i = 0; i < n; ++i) {
      if (i == 0) { left[i] = cur; } else if (ratings[i] > ratings[i - 1]) { left[i] = ++cur; }
      // else if (ratings[i] == ratings[i-1]) { left[i] = cur; }
      else {
        left[i] = 1;
        cur = 1;
      }
    }

    cur = 1;
    for (int i = n - 1; i >= 0; --i) {
      if (i == n - 1) { right[i] = cur; } else if (ratings[i] > ratings[i + 1]) {
        right[i] = ++cur;
      }
      // else if (ratings[i] == ratings[i+1]) { right[i] = cur; }
      else {
        right[i] = 1;
        cur = 1;
      }
    }

    int sum = 0;
    for (int i = 0; i < n; ++i) {
      sum += Math.max(left[i], right[i]);
      //System.out.print(Math.max(left[i], right[i]) + "\t");
    }
    System.out.println();

    return sum;
  }
}
