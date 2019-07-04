package com.aks.algorithm.tree;

import java.util.Scanner;

public class BinaryTreeDataPopulation {
	// We are reading the data from scanner and making a tree
	// first line will contain the no of nodes in tree
	// second line will contain the nodes.
	public static void main(String[] args) {

		addDataToBinaryTree();
	}

	private static void addDataToBinaryTree() {
		Scanner scan = new Scanner(System.in);
		Node root = null;
		int t = scan.nextInt();
		// t will decide the no of elements in tree
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insertdata(root, data);

		}
		System.out.println(root);
	}

	private static Node insertdata(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur = null;
			if (data < root.data) {
				cur = insertdata(root.left, data);
				root.left = cur;
			} else {
				cur = insertdata(root.right, data);
				root.right = cur;
			}
			return root;

		}

	}
}
