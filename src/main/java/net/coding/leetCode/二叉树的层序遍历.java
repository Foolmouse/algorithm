package net.coding.leetCode;

import sun.reflect.generics.tree.Tree;
import sun.security.util.ByteArrayLexOrder;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 通过次数436,437提交次数679,764
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的层序遍历 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        recursion(root, 0, result);
        return result;
    }

    public void recursion(TreeNode root, int dept, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (dept >= result.size()) {
            result.add( new LinkedList<>());
        }
        result.get(dept).add(root.val);
        dept++;

        recursion(root.left, dept, result);
        recursion(root.right, dept, result);
    }

    public static void main(String[] args) {
        二叉树的层序遍历 obj = new 二叉树的层序遍历();
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        obj.levelOrder(treeNode);
    }

}
