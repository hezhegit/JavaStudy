import java.util.*;

class TreeNode {
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
// 先序=》根左右
// 中序=》左根右
// 后序=》左右根

public class BinaryTree {
    // 92 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        inOrder(result, root);
        return result;
    }

    public void inOrder(List res, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(res, root.left);
        res.add(root.val);
        inOrder(res, root.right);
    }

    // 104 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 206 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 101 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric2(left, right);
    }

    public boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean f = isSymmetric2(left.left, right.right);
        boolean f2 = isSymmetric2(left.right, right.left);
        return f && f2;
    }

    // 543 二叉树的直径
    class Solution {
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root); // 在计算深度的过程中更新最大直径
            return maxDiameter;
        }

        // 计算树的最大深度，同时更新最大直径
        private int maxDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = maxDepth(node.left); // 左子树深度
            int right = maxDepth(node.right); // 右子树深度

            // 更新直径：左子树深度 + 右子树深度
            maxDiameter = Math.max(maxDiameter, left + right);

            // 返回当前节点的深度
            return Math.max(left, right) + 1;
        }
    }

    //102 层次遍历 ： 队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    // 108 平衡二叉树
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int cur = nums.length / 2;
        TreeNode root = new TreeNode(nums[cur]);
        root.left = sortedArrayToBST2(nums, 0, cur-1, root);
        root.right = sortedArrayToBST2(nums, cur+1, nums.length-1, root);
        return root;
    }

    public TreeNode sortedArrayToBST2(int[] nums, int start, int end, TreeNode root) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST2(nums, start, mid-1, node);
        node.right = sortedArrayToBST2(nums, mid+1, end, node);
        return node;
    }

    //98 验证二叉搜索树
    private Integer pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && pre >= root.val) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }

    private int size = 0;  // 记录当前遍历到的节点序号
    private int result = 0;  // 存储第 k 小的值

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        // 遍历左子树
        inOrderTraversal(root.left, k);

        // 访问当前节点
        size++;
        if (size == k) {
            result = root.val;
            return;
        }

        // 遍历右子树
        inOrderTraversal(root.right, k);
    }


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0){
                    result.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }

        }

        return result;
    }


    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = null;
            node.right = null;
            if (!queue.isEmpty()){
                node.right = queue.peek();
            }
        }
    }
    public void preOrder(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) {
            return;
        }
        queue.add(root);
        preOrder(root.left, queue);
        preOrder(root.right, queue);
    }

    // 105. 从前序与中序遍历序列构造二叉树
    private Map<Integer, Integer> inorderIndexMap; // 存储中序遍历的值和对应索引
    private int preorderIndex; // 当前遍历到的前序遍历索引
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        preorderIndex = 0;
        return create(preorder, 0, preorder.length - 1);
    }

    public TreeNode create(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        // 获取当前前序遍历的节点值，并创建根节点
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = create(preorder, left, inorderIndexMap.get(rootVal) -1);
        root.right = create(preorder, inorderIndexMap.get(rootVal) +1, right);
        return root;
    }

    // 437 路径总和
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和哈希表，记录前缀和出现的次数
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // 初始化前缀和为0时，出现1次
        return dfs(root, 0, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, int currSum, int targetSum, Map<Integer, Integer> prefixSum) {
        if (node == null) return 0;

        // 更新当前前缀和
        currSum += node.val;

        // 路径数量：检查有多少个前缀和等于 currSum - targetSum
        int count = prefixSum.getOrDefault(currSum - targetSum, 0);

        // 更新哈希表中当前前缀和的出现次数
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        // 递归遍历左右子树
        count += dfs(node.left, currSum, targetSum, prefixSum);
        count += dfs(node.right, currSum, targetSum, prefixSum);

        // 回溯：还原哈希表状态
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);

        return count;

    }


    // 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归查找左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归查找右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树都找到了目标节点，说明当前节点就是最低公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 如果只有左子树找到了目标节点，返回左子树的结果
        // 如果只有右子树找到了目标节点，返回右子树的结果
        return left != null ? left : right;
    }

    // 最大路径和
    public int maxPathSum(TreeNode root) {
        // 用于存储最大路径和
        int[] maxSum = {Integer.MIN_VALUE};
        // 递归计算最大路径和
        maxGain(root, maxSum);

        return maxSum[0];
    }

    private int maxGain(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        // 递归计算左子树的最大贡献值
        int leftGain = Math.max(maxGain(root.left, maxSum), 0);
        // 递归计算右子树的最大贡献值
        int rightGain = Math.max(maxGain(root.right, maxSum), 0);

        // 计算当前节点的路径和（左子树 + 当前节点 + 右子树）
        int currentPathSum = root.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxSum[0] = Math.max(maxSum[0], currentPathSum);

        // 返回当前节点的最大贡献值（只能选择左子树或右子树的一条路径）
        return root.val + Math.max(leftGain, rightGain);
    }


}
