# https://leetcode.com/problems/recover-binary-search-tree/

# Solution: In-order Traversal (Iterative) — O(n) time, O(h) space
class Solution:
    def recoverTree(self, root) -> None:
        first = second = prev = None
        stack = []
        curr = root
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            if prev and prev.val > curr.val:
                if not first:
                    first = prev
                second = curr
            prev = curr
            curr = curr.right
        first.val, second.val = second.val, first.val


# Solution 2: Morris In-order Traversal — O(n) time, O(1) space
class Solution2:
    def recoverTree(self, root) -> None:
        first = second = prev = None
        curr = root
        while curr:
            if curr.left is None:
                if prev and prev.val > curr.val:
                    if not first:
                        first = prev
                    second = curr
                prev = curr
                curr = curr.right
            else:
                pred = curr.left
                while pred.right and pred.right is not curr:
                    pred = pred.right
                if pred.right is None:
                    pred.right = curr
                    curr = curr.left
                else:
                    pred.right = None
                    if prev and prev.val > curr.val:
                        if not first:
                            first = prev
                        second = curr
                    prev = curr
                    curr = curr.right
        first.val, second.val = second.val, first.val
