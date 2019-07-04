package com.aks.algorithm.tree;

public class TraversalInTree {
	//run it as java application
	public static void main(String[] args) {

		
		Node tree = getMeATree();
		System.out.print(" PreOderTraversal =>");
		preorderTraversal(tree);//root -> left node -> right node
		System.out.print(" PostOrderTraversal =>");
		postOrderTraversal(tree);//left node ->  right node -> node
		System.out.print(" InOrderTraversal =>");
		inOrderTraversal(tree);//left node -> root -> right node
		
	}

	private static void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}else {
			inOrderTraversal(root.left);
			System.out.print(" "+root.data);
			inOrderTraversal(root.right);
			
			
		}
		
		
	}

	private static void postOrderTraversal(Node root) {
		if(root == null) {
			return;
		}else {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(" "+root.data);
			
		}
		
	}

	private static Node getMeATree() {
		Node root = new Node(1);
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		return root;

	}

	private static void preorderTraversal(Node root) {
		if(root == null) {
			return;
		}else {
			System.out.print(" "+root.data);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
}
