package net.coding.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class 二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList();

        list1.add(p);
        list2.add(q);

        recursion(root, list1);
        recursion(root, list2);
//        for (TreeNode treeNode : list1) {
//            System.out.print(treeNode.val + " ");
//        }
//        System.out.println();
//        for (TreeNode treeNode : list2) {
//            System.out.print(treeNode.val + " ");
//        }

        //找到两个list最近相同
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) == list2.get(j)) {
                    return list1.get(i);
                }
            }
        }
        return root;
    }

    //找到所有目标节点的祖先节点
    public void recursion(TreeNode node, LinkedList<TreeNode> arr) {
        if (node == null) return;
        recursion(node.left, arr);
        recursion(node.right, arr);

        TreeNode o = arr.getLast();
        if (node.left == o || node.right == o) {
            arr.add(node);
        }
    }

}
