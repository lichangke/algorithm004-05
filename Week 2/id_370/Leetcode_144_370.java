package id_370;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Leetcode_144_370 {
    // start from first preorder element
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
	// if there is no elements to construct subtrees
	if (in_left == in_right)
	    return null;

	// pick up pre_idx element as a root
	int root_val = preorder[pre_idx];
	TreeNode root = new TreeNode(root_val);

	// root splits inorder list
	// into left and right subtrees
	int index = idx_map.get(root_val);

	// recursion
	pre_idx++;
	// build left subtree
	root.left = helper(in_left, index);
	// build right subtree
	root.right = helper(index + 1, in_right);
	return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
	this.preorder = preorder;
	this.inorder = inorder;

	// build a hashmap value -> its index
	int idx = 0;
	for (Integer val : inorder) {
	    idx_map.put(val, idx++);
	}
	return helper(0, inorder.length);
    }

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }
}