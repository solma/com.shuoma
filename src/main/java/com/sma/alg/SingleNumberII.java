package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.BitManipulation;
import static com.sma.annotation.Tag.DataStructure.Array;
import static com.sma.annotation.Tag.Reference.LeetCode;

import com.sma.annotation.Tag;

/**
 Given an array of integers, every element appears three times except for one. Find that single one.
 */
@Tag(algs = BitManipulation, dss = Array, references = LeetCode)
public class SingleNumberII {
  public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    int nextOnes, nextTwos;
    for (int a : A) {
      nextOnes = (~a & ones) | (a & ~ones & ~twos);
      nextTwos = (~a & twos) | (a & ones);
      ones = nextOnes;
      twos = nextTwos;
    }
    return ones;
  }
}
