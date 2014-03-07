package com.shuoma.ds.graph;


public class BinaryTreeNode extends Node {
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(Node n) {
		if(n.adjacentList.size()>0){
			left=new BinaryTreeNode(n.adjacentList.get(0).opposite(n));
			right=new BinaryTreeNode(n.adjacentList.get(1).opposite(n));
		}
	}
}
