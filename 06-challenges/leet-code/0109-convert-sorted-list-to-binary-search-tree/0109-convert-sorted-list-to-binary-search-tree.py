# https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

class Solution:
    def sortedListToBST(self, head):
        if not head:
            return None
        if not head.next:
            return TreeNode(head.val)
        prev_mid = self._find_prev_mid(head)
        mid = prev_mid.next
        prev_mid.next = None
        root = TreeNode(mid.val)
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(mid.next)
        return root

    def _find_prev_mid(self, head):
        prev, slow, fast = None, head, head
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        return prev


class Solution2:
    def sortedListToBST(self, head):
        nums = []
        cur = head
        while cur:
            nums.append(cur.val)
            cur = cur.next

        def build(lo, hi):
            if lo > hi:
                return None
            mid = lo + (hi - lo) // 2
            root = TreeNode(nums[mid])
            root.left = build(lo, mid - 1)
            root.right = build(mid + 1, hi)
            return root

        return build(0, len(nums) - 1)


class Solution3:
    def sortedListToBST(self, head):
        n, c = 0, head
        while c:
            n += 1
            c = c.next
        self.cur = head

        def build(lo, hi):
            if lo > hi:
                return None
            mid = lo + (hi - lo) // 2
            left = build(lo, mid - 1)
            node = TreeNode(self.cur.val)
            self.cur = self.cur.next
            node.left = left
            node.right = build(mid + 1, hi)
            return node

        return build(0, n - 1)
