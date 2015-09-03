package com.shuoma.alg;

import static com.shuoma.annotation.Tag.DataStructure.BinaryTree;
import static com.shuoma.annotation.Tag.Reference.LeetCode;

import com.shuoma.annotation.Tag;

@Tag(dss = BinaryTree, references = LeetCode)
public class PopulatingNextRightPointersinEachNode {

  public void connect(TreeLinkNode cur) {
    while (cur != null) {
      TreeLinkNode nextLev = null, prev = null;
      for (; cur != null; cur = cur.next) {
        if (nextLev == null) {
          nextLev = cur.left != null ? cur.left : cur.right;
        }
        if (cur.left != null) {
          if (prev != null) { prev.next = cur.left; }
          prev = cur.left;
        }
        if (cur.right != null) {
          if (prev != null) { prev.next = cur.right; }
          prev = cur.right;
        }
      }
      cur = nextLev;
    }
  }
}
