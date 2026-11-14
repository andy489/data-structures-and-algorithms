# https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prev = dummy
        while prev.next:
            if prev.next.next and prev.next.val == prev.next.next.val:
                val = prev.next.val
                curr = prev.next
                while curr and curr.val == val:
                    curr = curr.next
                prev.next = curr
            else:
                prev = prev.next
        return dummy.next
