



import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {

    public static void main(String[] args) {
        int[] tree = {-10, -3, -1, 0, 5, 9, 11};
        //int[] tree = {1, 3};
        sortedArrayToBST(tree);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class TreeNodeBounds {
        TreeNode treeNode;
        int lowBound;
        int highBound;

        public TreeNodeBounds(TreeNode treeNode, int lowBound, int highBound) {
            this.treeNode = treeNode;
            this.lowBound = lowBound;
            this.highBound = highBound;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        Queue<TreeNodeBounds> queue = new ArrayBlockingQueue<>(nums.length);
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        queue.add(new TreeNodeBounds(root, 0, nums.length - 1));

        while (!queue.isEmpty()) {
            TreeNodeBounds parent = queue.remove();
            int mid = (parent.highBound + 1 - parent.lowBound) / 2 + parent.lowBound;
            if (mid != parent.lowBound) {
                TreeNode leftChild = new TreeNode(nums[(mid - parent.lowBound) / 2 + parent.lowBound]);
                parent.treeNode.left = leftChild;
                queue.add(new TreeNodeBounds(leftChild, parent.lowBound, mid - 1));
            }
            if (mid != parent.highBound) {
                TreeNode rightChild = new TreeNode(nums[(parent.highBound + 1 - mid - 1) / 2 + mid + 1]);
                parent.treeNode.right = rightChild;
                queue.add(new TreeNodeBounds(rightChild, mid + 1, parent.highBound));
            }
        }
        return root;
    }
}

