"""
You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north,
then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words,
after each move your direction changes counter-clockwise.

Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.

Example 1:
Given x = [2, 1, 1, 2],
Return true (self crossing)

Example 2:
Given x = [1, 2, 3, 4],
Return false (not self crossing)

Example 3:
Given x = [1, 1, 1, 1],
Return true (self crossing)
"""

from alg.label import *

Label(Label.Geometry, Label.LeetCode)


class Solution(object):
  def isSelfCrossing(self, x):
    for i in range(3, len(x)):
      # Case 1: current line crosses the line 3 steps ahead of it
      if (x[i] >= x[i - 2] and x[i - 1] <= x[i - 3] or
          # Case 2: current line crosses the line 4 steps ahead of it
          i >= 4 and x[i - 1] == x[i - 3] and x[i] + x[i - 4] >= x[i - 2] or
          # Case 3: current line crosses the line 6 steps ahead of it
          i >= 5 and x[i - 4] <= x[i - 2] <= x[i] + x[i - 4] and x[i - 1] <= x[i - 3] <= x[i - 1] + x[i - 5]):
        return True
    return False
