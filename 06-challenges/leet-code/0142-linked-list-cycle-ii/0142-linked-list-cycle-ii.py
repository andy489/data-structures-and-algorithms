# https://leetcode.com/problems/linked-list-cycle-ii/

# Solution 1: HashSet — O(n) time, O(n) space
class Solution:
    def detectCycle(self, head: 'Optional[ListNode]') -> 'Optional[ListNode]':
        seen = set()
        cur = head
        while cur:
            if cur in seen:
                return cur
            seen.add(cur)
            cur = cur.next
        return None


# Solution 2: Floyd's Cycle Detection — O(n) time, O(1) space
class Solution2:
    def detectCycle(self, head: 'Optional[ListNode]') -> 'Optional[ListNode]':
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                slow = head
                while slow is not fast:
                    slow = slow.next
                    fast = fast.next
                return slow
        return None
