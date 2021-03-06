package com.sma.alg;

import static com.sma.annotation.Tag.DataStructure.BinaryTree;
import static com.sma.annotation.Tag.Reference.LeetCode;

import com.sma.annotation.Tag;

@Tag(dss = BinaryTree, references = LeetCode)
public class CountCompleteTreeNodes {
  public static void main(String[] args) {
    new CountCompleteTreeNodes().main();
  }

  public void main() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(7);
    //root.left.right = new TreeNode(8);
    root.right = new TreeNode(9);
    //root.right.left = new TreeNode(1);
    System.out.println(countNodes(root));
  }

  public int countNodes(TreeNode cur) {
    int height = getHeight(cur);
    if (height <= 1) return height;

    int rightHeight = getHeight(cur.right) - 1;
    int leftHeight = getHeight(cur.left) - 1;
    int result;

    if (rightHeight == leftHeight) {
      result = (int) Math.pow(2, leftHeight + 1) - 1 + countNodes(cur.right);
    } else {
      result = (int) Math.pow(2, rightHeight + 1) - 1 + countNodes(cur.left);
    }

    return result + 1;
  }

  public int countNodes1(TreeNode root) {
    int height = getHeight(root);
    if (height <= 1) return height;

    int[] noOfLeaf = new int[]{0};
    countLeaf(root, noOfLeaf, 1, height);
    return (int) Math.pow(2, height - 1) - 1 + noOfLeaf[0];
  }

  boolean countLeaf(TreeNode cur, int[] cnt, int depth, int height) {
    if (depth == height) {
      if (cur == null) {
        return false;
      }
      cnt[0]++;
      //System.out.println(cur.val);
      return true;
    }
    return countLeaf(cur.left, cnt, depth + 1, height) && countLeaf(cur.right, cnt, depth + 1, height);
  }

  int getHeight(TreeNode completeTreeRoot) {
    if (completeTreeRoot == null) return 0;
    return getHeight(completeTreeRoot.left) + 1;
  }
}
