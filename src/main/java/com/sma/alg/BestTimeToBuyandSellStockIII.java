package com.sma.alg;

import com.sma.annotation.Tag;

import static com.sma.annotation.Tag.DataStructure.Array;
import static com.sma.annotation.Tag.Reference.LeetCode;
import static com.sma.annotation.Tag.Trick.CheckAtEveryIndex;
import static com.sma.annotation.Tag.Trick.ForwardAndBackwardScan;

@Tag(dss = Array, references = LeetCode, tricks = {CheckAtEveryIndex, ForwardAndBackwardScan})
public class BestTimeToBuyandSellStockIII {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0)
      return 0;

    //scan forward: record the max profit if allowing only one transaction
    int[] maxProfitForward = new int[n];
    int min = prices[0];
    for (int i = 1; i < n; i++) {
      min = Math.min(min, prices[i]);
      maxProfitForward[i] = Math.max(maxProfitForward[i - 1], prices[i] - min);
    }
    //System.out.println(Arrays.toString(maxProfitForward));

    //scan backward: record the max profit if allowing only one transaction
    int[] maxProfitBackward = new int[n];
    int max = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      max = Math.max(max, prices[i]);
      maxProfitBackward[i] = Math.max(maxProfitBackward[i + 1], max - prices[i]);
    }
    //System.out.println(Arrays.toString(maxProfitBackward));

    //combine the two
    int ret = 0;
    for (int i = 0; i < n; i++) {
      if (i != n - 1)
        ret = Math.max(ret, maxProfitForward[i] + maxProfitBackward[i + 1]);
      else {
        ret = Math.max(ret, maxProfitForward[i]);
      }
    }

    return ret;
  }
}
