// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

// Solution: Slow-Fast Pointer (Find Mid In-Place) — O(n log n) time, O(log n) space
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode prevMid = findPrevMid(head);
        ListNode mid = prevMid.next;
        prevMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findPrevMid(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
}

// Solution 2: Convert to Array + Divide and Conquer — O(n) time, O(n) space (extra array)
class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            nums.add(cur.val);
        }
        return build(nums, 0, nums.size() - 1);
    }

    private TreeNode build(List<Integer> nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = build(nums, lo, mid - 1);
        root.right = build(nums, mid + 1, hi);
        return root;
    }
}

// Solution 3: In-Order Simulation with Global Pointer — O(n) time, O(log n) space
class Solution3 {
    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        for (ListNode c = head; c != null; c = c.next) {
            n++;
        }
        cur = head;
        return build(0, n - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode left = build(lo, mid - 1);
        TreeNode node = new TreeNode(cur.val);
        cur = cur.next;
        node.left = left;
        node.right = build(mid + 1, hi);
        return node;
    }
}
