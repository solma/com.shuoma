package com.sma.alg;

import static com.sma.annotation.Tag.DataStructure.Array;
import static com.sma.annotation.Tag.Reference.LeetCode;
import static com.sma.annotation.Tag.Trick.CheckAtEveryIndex;

import com.sma.annotation.Tag;

/**
 * Allow one transaction
 */
@Tag(dss = Array, references = LeetCode, tricks = CheckAtEveryIndex)
public class BestTimeToBuyandSellStock {
  public int maxProfit(int[] prices) {
    if (prices.length == 0)
      return 0;
    int min = prices[0], ret = 0;
    for (int i = 1; i < prices.length; i++) {
      min = Math.min(prices[i], min);
      ret = Math.max(prices[i] - min, ret);
    }
    return ret;
  }
}
