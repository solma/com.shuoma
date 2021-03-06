"""
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:
Input:
s = "abcd"
t = "abcde"
Output:
e

Explanation:
'e' is the letter that was added.
"""
from alg.label import *
Label(Label.Hash, Label.LinearTime, Label.LeetCode)

class FindTheDifference(object):
  def findTheDifference(self, s, t):
    from collections import Counter
    sc = Counter(s)
    tc = Counter(t)
    for c in tc:
      if c not in sc or sc[c] != tc[c]:
        return c
    return None
