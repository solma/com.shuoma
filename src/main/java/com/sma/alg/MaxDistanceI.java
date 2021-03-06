package com.sma.alg;

import com.sma.annotation.Tag;

import static com.sma.annotation.Tag.Algorithm.DynamicProgramming;
import static com.sma.annotation.Tag.DataStructure.Subarray;
import static com.sma.annotation.Tag.Reference.Interview;
import static com.sma.annotation.Tag.Complexity.Linear;

/**
 * Given an int array A[], define distance as A[i] + A[j] + (j-i), for any j > i.
 * Find max distance in A[]. Requirement O(n) time
 */

@Tag(algs = DynamicProgramming, timecomplexity = Linear,
    dss = Subarray, references = Interview)
public class MaxDistanceI {

  int[] maxDistance(int[] nums){
    if (nums == null || nums.length < 1) return null;
    int n = nums.length;
    int max = nums[0] * 2, prev = max;
    for (int i = 1; i < n; i++) {
      int dis = Math.max(nums[i] * 2, prev - nums[i - 1] + nums[i] + 1);
      max = Math.max(max, dis);
      prev = dis;
    }
    return new int[]{max, 0, 0};
  }

  // Incorrect: Two pointers does not work
  int[] maxDistanceTwoPointersFail(int[] nums){
    int n = nums.length;
    int l = 0, r = n - 1;
    int[] ret = new int[3];
    while (l <= r) {
      int dis = nums[l] + nums[r] + r - l;
      if (ret[0] < dis) {
        ret[0] = dis;
        ret[1] = l;
        ret[2] = r;
      }
      if (ret[0] < 2 * nums[l]) {
        ret[0] = 2 * nums[l];
        ret[1] = ret[2] = l;
      }
      if (ret[0] < 2 * nums[r]) {
        ret[0] = 2 * nums[r];
        ret[1] = ret[2] = r;
      }
      if (nums[l] < nums[r]) l++;
      else r--;
    }
    return ret;
  }
}
