package com.aks.algorithm.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IsBinarySearchTree {

	/*
	 * The value of every node in a node's left subtree is less than the data value
	 * of that node.
	 *
	 * The value of every node in a node's right subtree is greater than the data
	 * value of that node.
	 * 
	 * 
	 * The left subtree of a node should contain only nodes with keys less than the
	 * node’s key.
	 * 
	 * The right subtree of a node should contain only nodes with keys
	 * greater than the node’s key 
	 * 
	 * Both the left and right subtrees must also be
	 * binary search trees.
	 */
	public static void main(String[] args) {
	Node root = Util.getMeBinaryTree();
	System.out.println(findBinarySearchTreeOrNot(root));
	}
	
	
	/*
	 *            6
	 *           / \
	 * 			4	7
	 * 		   / \   \
	 * 		  2	  5	  9
	 * */
	private static boolean findBinarySearchTreeOrNot(Node root) {
		List<Integer> list = new ArrayList<>();
		list = getInOrderDatafromTree(root,list);
		System.out.println(list);
	//	return list.stream().sorted().collect(Collectors.toList()).equals(list);
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(i)>list.get(i+1)) {
				return false;
			}
		}
		return true;
		
	}

	private static List<Integer> getInOrderDatafromTree(Node root, List<Integer> list) {
		if(root == null) {
			return list;
		}else {
			getInOrderDatafromTree(root.left, list);
			list.add(root.data);
			getInOrderDatafromTree(root.right, list);
		}
		return list;
		
	}
}
