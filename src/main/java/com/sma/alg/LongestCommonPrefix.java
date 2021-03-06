package com.sma.alg;

import static com.sma.annotation.Tag.DataStructure.StringT;
import static com.sma.annotation.Tag.Reference.LeetCode;

import com.sma.annotation.Tag;

import java.util.Arrays;

@Tag(dss = StringT, references = LeetCode)
public class LongestCommonPrefix {
  public static void main(String[] args) {
    System.out
        .println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"abc", "abaeq", "c"}));
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0)
      return "";
    if (strs.length == 1)
      return strs[0];

    StringSortByLength[] sortedStrs = new StringSortByLength[strs.length];
    for (int i = 0; i < strs.length; i++) {
      sortedStrs[i] = new StringSortByLength(strs[i]);
    }
    Arrays.sort(sortedStrs);

    for (int r = sortedStrs[0].s.length(); r >= 1; r--) {
      String prefix = sortedStrs[0].s.substring(0, r);
      boolean flag = true;

      for (int i = 1; i < sortedStrs.length; i++) {
        if (!sortedStrs[i].s.startsWith(prefix)) {
          flag = false;
          break;
        }
      }

      if (flag)
        return prefix;

    }
    return "";
  }
}


class StringSortByLength implements Comparable<StringSortByLength> {
  String s;

  public StringSortByLength(String s) {
    this.s = s;
  }

  public int compareTo(StringSortByLength that) {
    return s.length() - that.s.length();
  }
}
