package com.sma.alg;


import com.sma.annotation.Tag;

import static com.sma.annotation.Tag.Algorithm.DynamicProgramming;
import static com.sma.annotation.Tag.Complexity.Linear;
import static com.sma.annotation.Tag.DataStructure.Subarray;

/** Find longest increasing subarray for specified array. */
@Tag(algs = DynamicProgramming, timecomplexity = Linear, dss = Subarray)
public class LongestIncreasingSubArray {

  int longestIncreasingSubarray(final int[] a) {
    int n = a.length;
    if (n == 0) return 0;
    int max = 1, cur = 1;
    for (int i = 1; i < n; i++) {
      if (a[i] > a[i - 1]) {
        cur++;
      } else {
        max = Math.max(max, cur);
        cur = 1;
      }
    }
    return max;
  }
}
