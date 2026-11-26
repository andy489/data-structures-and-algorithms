# https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

class Solution:
    def findLeastNumOfUniqueInts(self, arr: list[int], k: int) -> int:
        from collections import Counter
        counts = sorted(Counter(arr).values())
        unique = len(counts)
        for cnt in counts:
            if k >= cnt:
                k -= cnt
                unique -= 1
            else:
                break
        return unique
