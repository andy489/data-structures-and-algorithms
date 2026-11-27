# https://leetcode.com/problems/copy-list-with-random-pointer/

# Solution 1: HashMap — O(n) time, O(n) space
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        cloned = {}
        cur = head
        while cur:
            cloned[cur] = Node(cur.val)
            cur = cur.next
        cur = head
        while cur:
            cloned[cur].next = cloned.get(cur.next)
            cloned[cur].random = cloned.get(cur.random)
            cur = cur.next
        return cloned.get(head)


# Solution 2: Interleaving — O(n) time, O(1) space
class Solution2:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        cur = head
        while cur:
            clone = Node(cur.val)
            clone.next = cur.next
            cur.next = clone
            cur = clone.next
        cur = head
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            cur = cur.next.next
        dummy = Node(0)
        tail = dummy
        cur = head
        while cur:
            tail.next = cur.next
            tail = tail.next
            cur.next = cur.next.next
            cur = cur.next
        return dummy.next
