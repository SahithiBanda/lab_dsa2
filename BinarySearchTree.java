package com.greatlearning.dsa2;
import java.util.ArrayList;

import org.w3c.dom.Node;
public class BinarySearchTree {
	Node root;
	 
    BinarySearchTree()
    {
        root = null;
    }
 
    void inorder()
    {
        inorderUtil(this.root);
    }
 
    void inorderUtil(Node node)
    {
        if (node == null)
            return;
 
        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }
 
    void insert(int key)
    {
        root = insertRec(root, key);
    }
 
    Node insertRec(Node root, int data)
    {
 
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }
 
    ArrayList<Integer> treeToList(Node node, ArrayList<Integer>
                                                 list)
    {
        if (node == null)
            return list;
 
        treeToList(node.left, list);
        list.add(node.data);
        treeToList(node.right, list);
 
        return list;
    }
 
    boolean isPairPresent(Node node, int target)
    {
    
        ArrayList<Integer> a1 = new ArrayList<>();
 
        ArrayList<Integer> a2 = treeToList(node, a1);
 
        int start = 0; 
 
         int end = a2.size() - 1; 
        while (start < end) {
 
            if (a2.get(start) + a2.get(end) == target)
            {
                System.out.println("Pair Found: " + a2.get(start) + " + " + a2.get(end) + " "
                                   + "= " + target);
                return true;
            }
 
            if (a2.get(start) + a2.get(end) > target)             {
                end--;
            }
 
            if (a2.get(start) + a2.get(end) < target) 
            {
                start++;
            }
        }
 
        System.out.println("No such values are found!");
        return false;
    }
 
        
        
        
	public static void main(String[] args) {
         Node root = null;       
        
         FindSumPair findsp = new FindSumPair();
         root = findsp.insert(root, 40);
         root = findsp.insert(root, 20);
         root = findsp.insert(root, 60);
         root = findsp.insert(root, 10);
         root = findsp.insert(root, 30);
         root = findsp.insert(root, 50);
         root = findsp.insert(root, 70);
         
         int sum = 60;
         findsp.findPaitWithGivenSum(root, sum);
 
    }

	}


