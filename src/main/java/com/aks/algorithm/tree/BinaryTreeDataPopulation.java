package com.aks.algorithm.tree;

import java.util.Scanner;

public class BinaryTreeDataPopulation {
	public static void main(String[] args) {
		addDataToBinaryTree();
	}

	private static void addDataToBinaryTree() {
		Scanner scan = new Scanner(System.in);
		Node root = null;
		int t = scan.nextInt();
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insertdata(root,data);
			
		}
	}

	private static Node insertdata(Node root, int data) {
		if(root == null) {
			return new Node(data);
		}else {
			Node cur = null;
			if(data<root.data) {
				insertdata(root.left, data);
				root.left = cur;
			}else {
				insertdata(root.right, data);
				root.right = cur;
			}
			return root;
			
		}
		
	}
}
