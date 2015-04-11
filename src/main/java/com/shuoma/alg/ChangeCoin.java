package com.shuoma.alg;

import static com.shuoma.annotation.Tag.Algorithm.Backtracking;
import static com.shuoma.annotation.Tag.Algorithm.DynamicProgramming;

import com.shuoma.annotation.Tag;
import com.shuoma.util.CollectionsUtil;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of denominations and a number X, write code to find out
 * the number of unique ways that amount X can be decomposed.
 */
@Tag(algs = {Backtracking, DynamicProgramming})
public class ChangeCoin {

  Set<Map<Integer, Integer>> changeCntDp(final int n, final int[] denominations) {
    int m = denominations.length;
    long[] cnt = new long[n + 1];
    cnt[0] = 1;

    Map<Integer, List<MutablePair<Integer, Integer>>> backTracking = new HashMap<>();

    for (int j = 1; j <= m; j++) {
      for (int i = n; i >= 0; i--) {
        int k = 1;
        while(i >= k * denominations[j - 1]) {
          cnt[i] += cnt[i - denominations[j - 1] * k];
          k++;
        }
        if (k > 1) {
          CollectionsUtil.upsert(backTracking, i,
            new MutablePair<>(i - denominations[j - 1] * (k - 1), denominations[j - 1]),
            new LinkedList<MutablePair<Integer, Integer>>());
        }
      }
    }
    // CollectionsUtil.printMap(backTracking);
    return getAllWaysOfChange(backTracking, n);
  }

  private Set<Map<Integer, Integer>> getAllWaysOfChange(
      Map<Integer, List<MutablePair<Integer, Integer>>> backTracking, int cur) {
    Set<Map<Integer, Integer>> ret = new HashSet<>();
    if (cur == 0) {
      ret.add(new HashMap<Integer, Integer>());
      return ret;
    }
    for (MutablePair<Integer, Integer> next : backTracking.get(cur)) {
      int face = next.getRight();
      for (int k = 1; k <= (cur - next.getLeft()) / face; k++) {
        for (Map<Integer, Integer> way : getAllWaysOfChange(backTracking, cur - face * k)) {
          CollectionsUtil.increaseMapCounter(way, face, k);
          ret.add(way);
        }
      }
    }
    return ret;
  }

  Set<Map<Integer, Integer>> bottomUpRecursionWithMemory(final int n, final int[] denominations) {
    Map<Integer, Set<Map<Integer, Integer>>> memory = new HashMap<>();
    bottomUpRecursionWithMemory(n, denominations, memory);
    return memory.get(n);
  }

  private Set<Map<Integer, Integer>> bottomUpRecursionWithMemory(final int n, final int[] denominations, Map<Integer, Set<Map<Integer, Integer>>> memory) {
    if (n < 0) {
      return null;
    }

    Set<Map<Integer, Integer>> ret = new HashSet<>();
    if (memory.containsKey(n)) {
      return memory.get(n);
    }
    if (n == 0) {
      ret.add(new HashMap<Integer, Integer>());
      return ret;
    }

    for (int val : denominations) {
      Set<Map<Integer, Integer>> recursionReturn = bottomUpRecursionWithMemory(n - val,
          denominations, memory);
      if (recursionReturn == null) {
        continue;
      }
      for (Map<Integer, Integer> way : recursionReturn) {
        Map<Integer, Integer> wayCpy = new HashMap<>(way);
        CollectionsUtil.increaseMapCounter(wayCpy, val, 1);
        ret.add(wayCpy);
      }
    }
    memory.put(n, ret);
    return ret;
  }
}