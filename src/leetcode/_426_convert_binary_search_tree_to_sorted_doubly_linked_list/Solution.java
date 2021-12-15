package leetcode._426_convert_binary_search_tree_to_sorted_doubly_linked_list;


import java.util.Stack;

public class Solution {

    //do a in-order traversal
    //record the left(head) every time have a left child
    //record end if there is a right child

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;

        TreeNode head = root, prev = null;
        while (head.left!=null){
            head = head.left;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){

            while (cur !=null){
                stack.push(cur);
                cur = cur.left;
            }

            //cur is null then start from most left
            cur = stack.pop();
            if (prev!=null){
                prev.right = cur;
                cur.left = prev;
            }
            prev = cur;
            cur = cur.right;
        }

        if (prev!=null){
            prev.right = head;
        }

        return head;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
