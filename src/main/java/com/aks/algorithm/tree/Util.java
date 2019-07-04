package com.aks.algorithm.tree;

public class Util {
	
	static Node getMeBinaryTree() {
		Node root = new Node(1);
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		return root;
		
	}

}
