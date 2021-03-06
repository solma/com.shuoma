package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.BitManipulation;
import static com.sma.annotation.Tag.DataStructure.Array;
import static com.sma.annotation.Tag.Reference.LeetCode;

import com.sma.annotation.Tag;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example, given nums = [0, 1, 3] return 2.
 */
@Tag(algs = BitManipulation, dss = Array, references = LeetCode)
public class MissingElement {

  int missingElement(int[] nums) {
    int xor = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      xor ^= nums[i];
    }
    for (int i = 0; i <= n; i++) {
      xor ^= i;
    }
    return xor;
  }
}
