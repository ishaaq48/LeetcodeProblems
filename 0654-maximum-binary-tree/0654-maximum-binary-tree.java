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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if(n==0) return null;
        return rec(nums,0,n-1);
    }

    public TreeNode rec(int[] nums, int low, int high){
        if(low > high) return null;
        int x = findMax(nums, low, high);
        TreeNode root = new TreeNode(nums[x]);
        root.left = rec(nums, low, x-1);
        root.right = rec(nums, x+1, high);
        return root;
    }
    public int findMax(int[] nums, int low1, int high1){
        int maxi =Integer.MIN_VALUE;
        int ind = -1;
        while(low1 <= high1){
            if(nums[low1]>maxi){
                maxi = nums[low1];
                ind = low1; 
            }
            low1++;
        }
        return ind;
    }
}