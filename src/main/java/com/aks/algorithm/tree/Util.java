package com.aks.algorithm.tree;

public class Util {
	
	static Node getMeBinaryTree() {
		Node root = new Node(1);
		root = new Node(6);
		root.left = new Node(4);
		root.right = new Node(7);
		root.right.right = new Node(9);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		return root;
		
	}

}
