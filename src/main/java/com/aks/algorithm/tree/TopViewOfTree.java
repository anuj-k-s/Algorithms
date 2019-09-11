package com.aks.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Method to print top view of the Tree
 * 
 * @author prkumarp
 *
 */
public class TopViewOfTree {

	public static void main(String[] args) {
		Node meBinaryTree = Util.getMeBinaryTree();
		printTopView(meBinaryTree);
	}

	/**
	 * Method to print data
	 * 
	 * @param meBinaryTree which contains nodes
	 */
	private static void printTopView(Node meBinaryTree) {
		Map<Integer, Integer> map = new HashMap<>();
		int pos = 0;
		traverseAllNodes(meBinaryTree, pos, map);
		map.forEach((key, value) -> System.out.println(value));
	}

	/**
	 * Method to traverse through the each node using.
	 * 
	 * @param node
	 * @param pos
	 * @param out
	 */
	public static void traverseAllNodes(Node node, int pos, Map<Integer, Integer> out) {
		// End of the node return pointer;
		if (node == null) {
			return;
		}
		// Traverse through left node
		traverseAllNodes(node.left, pos - 1, out);
		// Traverse through right node
		traverseAllNodes(node.right, pos + 1, out);
		/*
		 * While coming back from end of the node then , push each node data to map,
		 * with key as it position and value as node data
		 */
		out.put(pos, node.data);
	}

}
