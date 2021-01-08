package com.example.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	Node root;
	
	//添加节点
	private Node addNode(Node current, int value) {
		
		if(current == null) {
			return new Node(value);
		}
		if(value < current.key) {
			current.left = addNode(current.left, value);
		}else if(value > current.key) {
			current.right = addNode(current.right, value);
		}else {
			return current;
		}
		return current;
	}
	
	public void addNode(int value) {
		root = addNode(root, value);
	}
	
	public BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();
        bt.addNode(6);
        bt.addNode(4);
        bt.addNode(8);
        bt.addNode(10);
        return bt;
    }
	
	//判断节点存在
	private boolean containTree(Node current, int value) {
		if(current == null) {
			return false;
		}
		if(value == current.key){
			return true;
		}
		
		return value < current.key ? containTree(current.left, value) : containTree(current.right, value) ;
	}
	
	public boolean containTree(int value) {
		return containTree(root,value);
	}
	
	//删除节点
	private Node deleteNode(Node current, int value) {
		if(current == null) {
			return null;
		}
		if(value == current.key) {
			if( current.left == null && current.right == null) {
				return null;
			}
			if( current.left == null) {
				return current.right;
			}
			if(current.right == null) {
				return current.left;
			}
			int smallestValue = findSmallestValue(current.right);
			current.key = smallestValue;
			current.right = deleteNode(current.right, smallestValue);
			return current;
		}
		if(value < current.key) {
			current.left = deleteNode(current.left, value);
			return current;
		}
		current.right = deleteNode(current.right, value);
		return current;
	}
	
	public int findSmallestValue(Node root) {
		return root.left == null ? root.key : findSmallestValue(root.right);
	}
	
	
	public void traversePreOrder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }
	public void traversePostOrder(Node root) {
        if (root != null) {
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.println(root.key);
        }
    }
	public void traverseLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(node.key);
            if (node.left != null) {
                nodes.add(node.left);
            }					
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
