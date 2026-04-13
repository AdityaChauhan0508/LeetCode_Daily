import java.util.*;
 // Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      //TreeNode() {}
      //TreeNode(int val) { this.val = val; }
    //   TreeNode(int val, TreeNode left, TreeNode right) {
    //       this.val = val;
    //       this.left = left;
    //       this.right = right;
    //   }
  }

class Solution {
    long MOD = 1000000007L;
    long ans = 0;

    private long dfs(TreeNode node) {
        if (node == null) return 0;

        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }

    public int minProduct(TreeNode root) {
        long total = dfs(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) continue;

            long cur = (total - node.val) * node.val;
            ans = Math.max(ans, cur);

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return (int)(ans % MOD);
    }

    public int maxProduct(TreeNode root) {
        long total = dfs(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) continue;

            long cur = (total - node.val) * node.val;
            ans = Math.max(ans, cur);

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return (int)(ans % MOD);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;
        root.right = new TreeNode();
        root.right.val = 3;

        Solution sol = new Solution();
        System.out.println(sol.minProduct(root)); // Output: 6
        System.out.println(sol.maxProduct(root)); // Output: 6
    }
}