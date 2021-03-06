package com.sma.alg;
//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//For example, Given s = “eceba”,
//T is “ece” which its length is 3.

import com.sma.annotation.Tag;

import static com.sma.annotation.Tag.DataStructure.Hash;
import static com.sma.annotation.Tag.DataStructure.Substring;
import static com.sma.annotation.Tag.Difficulty.D2;
import static com.sma.annotation.Tag.Reference.LeetCode;
import static com.sma.annotation.Tag.Trick.CheckAtEveryIndex;

@Tag(dl = D2, dss = {Hash, Substring}, references = LeetCode, tricks = CheckAtEveryIndex)
public class LongestSubstringWithAtMostTwoDistinctCharacters {

  public String longestSubstring(String s) {
    // Trick: use of variable maxEndHere
    int maxSoFar = 1, maxEndHere = 1, prevCharLen = 1;
    char prevChar = s.charAt(0), prevPrevChar = ' ';
    int[] res = {0, 1};
    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == prevChar) {
        maxEndHere++;
        prevCharLen++;
      } else {
        if (c == prevPrevChar) { maxEndHere++; }
        else { maxEndHere = prevCharLen + 1; } // end with c
        prevPrevChar = prevChar;
        prevChar = c;
        prevCharLen = 1;
      }

      if (maxSoFar < maxEndHere) {
        maxSoFar = maxEndHere;
        res[1] = i + 1;
        res[0] = i + 1 - maxSoFar;
      }
    }
    return s.substring(res[0], res[1]);
  }
}
