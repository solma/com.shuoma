package com.sma.alg;
/*
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *  For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 *  the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

import com.sma.annotation.Tag;

import static com.sma.annotation.Tag.Algorithm.DynamicProgramming;
import static com.sma.annotation.Tag.Complexity.Linear;
import static com.sma.annotation.Tag.DataStructure.Subarray;
import static com.sma.annotation.Tag.Reference.LeetCode;

@Tag(algs = DynamicProgramming, timecomplexity = Linear, dss = Subarray, references = LeetCode)
public class MaxSumArray {
  //second pass
  public int maxSubArray(int[] A) {
    if (A.length == 0)
      return 0;
    int sum = A[0], maxSum = sum;
    for (int i = 1; i < A.length; i++) {
      if (sum < 0)
        sum = 0;
      sum += A[i];
      if (sum > maxSum)
        maxSum = sum;
    }
    return maxSum;
  }

  //first pass
  public int maxSubArrayFirstPass(int[] A) {
    int maxSum = Integer.MIN_VALUE;
    if (A.length == 0)
      return maxSum;
    int sumToNow = A[0];
    for (int i = 1; i < A.length; i++) {
      if (A[i] < 0)
        maxSum = Math.max(sumToNow, maxSum);
      if (sumToNow < 0)
        sumToNow = 0;
      sumToNow += A[i];
    }
    return Math.max(maxSum, sumToNow);
  }
}
