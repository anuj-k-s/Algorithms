package com.aks.algorithm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.aks.algorithm.tree.Node;

@SpringBootTest
class AlgorithmApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void addDataToTree(){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		System.out.println(root);
	}
	
}
