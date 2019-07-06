package com.aks.algorithm.tree;

public class HeightOfTree {
	/*
	 * The height of a binary tree is the number of edges between the tree's root
	 * and its furthest leaf
	 */ public static void main(String[] args) {
		Node tree = Util.getMeBinaryTree();
		System.out.println(heightofBinaryTree(tree));
	}
/*
 *            6
 *           / \
 * 			5	7
 * 		   / \   \
 * 		  2	  8	  9
 * */
	private static int heightofBinaryTree(Node tree) {
		if (tree == null) {
			return -1;
		} else {
			return 1 + Math.max(heightofBinaryTree(tree.left), heightofBinaryTree(tree.right));
		}

	}
}
