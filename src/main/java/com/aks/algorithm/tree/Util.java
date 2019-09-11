package com.aks.algorithm.tree;

public class Util {
	
	static Node getMeBinaryTree() {
		Node root = new Node(1);
		root = new Node(6);
		root.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(7);
		root.right.right = new Node(9);
		root.right.right.right = new Node(24);
		root.right.right.right.right = new Node(45);
		root.right.right.right.right.right = new Node(67);
		
		root.left.left = new Node(2);
		root.left.left.right = new Node(11);
		root.left.left.right.left = new Node(87);
		root.left.left.right.left.right = new Node(100);
		root.left.left.right.left.left = new Node(90);
		root.left.left.right.right = new Node(10);
		root.left.left.right.right.right = new Node(13);
		root.left.left.right.right.right.right = new Node(14);
		root.left.left.right.right.right.right.right = new Node(15);
		
		
		
		return root;
		
	}

}
