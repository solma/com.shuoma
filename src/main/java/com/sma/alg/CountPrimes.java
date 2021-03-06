package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.Arithmetic;
import static com.sma.annotation.Tag.Algorithm.Greedy;
import static com.sma.annotation.Tag.DataStructure.Array;
import static com.sma.annotation.Tag.Reference.LeetCode;

import com.sma.annotation.Tag;

import java.util.Arrays;

@Tag(algs = {Arithmetic, Greedy}, dss = Array, references = LeetCode)
public class CountPrimes {
  public static void main(String[] args) {
    //499979
    System.out.println(new CountPrimes().countPrimes(499979));
  }

  public int countPrimes(int n) {
    if (n <= 2) return 0;
    if (n == 3) return 1;

    int maxIdx = ((n - 1) - 3) >> 1;
    boolean[] isPrime = new boolean[maxIdx + 1];
    Arrays.fill(isPrime, true);
    int cnt = 1;
    for (int i = 0; i <= maxIdx; i++) {
      if (isPrime[i]) {
        cnt++;
        long p = (i << 1) + 3;

        for (long j = p * p; j < n; j += p << 1) {
          isPrime[(int) (j - 3) >> 1] = false;
        }
      }
    }
    return cnt;
  }
}
