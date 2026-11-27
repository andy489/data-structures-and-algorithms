# https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

class Solution:
    def nodesBetweenCriticalPoints(self, head) -> list[int]:
        first_crit = prev_crit = -1
        min_dist = float('inf')
        idx = 1
        prev, curr = head, head.next
        while curr.next:
            if (curr.val > prev.val and curr.val > curr.next.val) or                (curr.val < prev.val and curr.val < curr.next.val):
                if prev_crit != -1:
                    min_dist = min(min_dist, idx - prev_crit)
                if first_crit == -1:
                    first_crit = idx
                prev_crit = idx
            prev, curr, idx = curr, curr.next, idx + 1
        if first_crit == prev_crit:
            return [-1, -1]
        return [min_dist, prev_crit - first_crit]
