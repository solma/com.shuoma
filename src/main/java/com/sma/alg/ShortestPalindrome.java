package com.sma.alg;

import com.sma.annotation.Tag;

import static com.sma.annotation.Tag.DataStructure.Palindrome;
import static com.sma.annotation.Tag.DataStructure.StringT;
import static com.sma.annotation.Tag.Reference.LeetCode;

/**
 Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 Find and return the shortest palindrome you can find by performing this transformation.

 For example:
 Given "aacecaaa", return "aaacecaaa".
 Given "abcd", return "dcbabcd".
 */
@Tag(dss = {Palindrome, StringT}, references = LeetCode)
public class ShortestPalindrome {

  public String shortestPalindrome(String s) {
    int n = s.length();
    if(n <= 1) return s;
    int center = (n - 1) / 2;
    String res = "";
    for(int i = center; i >= 0; i--) {
      // center is two chars
      if(s.charAt(i) == s.charAt(i + 1)) {
        if((res = expandToBuildPalindrome(s, i, i + 1)) != null)
          return res;
      }
      // center is one char
      if((res = expandToBuildPalindrome(s, i, i)) != null) return res;
    }
    return res;
  }
  //aabaac
  private String expandToBuildPalindrome(String s, int l, int r) {
    int expansionDis = 1;
    for(; l - expansionDis >= 0; expansionDis++) {
      if(s.charAt(l - expansionDis) != s.charAt(r + expansionDis) ) break;
    }

    if(l - expansionDis >= 0) return null;
    StringBuilder sb = new StringBuilder(s.substring(r + expansionDis));
    sb.reverse();
    return sb + s;
  }
}
