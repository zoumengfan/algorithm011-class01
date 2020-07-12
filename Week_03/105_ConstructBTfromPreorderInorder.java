/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int p1, int[] inorder, int i1, int i2) {
        if (i1 > i2) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[p1]);
        
        int i = i1;
        for (; i <= i2; ++i) {
            if (inorder[i] == preorder[p1]) {
                break;
            }
        }
        
        root.left = build(preorder, p1 + 1, inorder, i1, i - 1);
        root.right = build(preorder, p1 + i - i1 + 1, inorder, i + 1, i2);
        return root;
    }
}