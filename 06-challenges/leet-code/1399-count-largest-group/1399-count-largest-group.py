# https://leetcode.com/problems/count-largest-group/

from collections import Counter

class Solution:
    def countLargestGroup(self, n: int) -> int:
        cnt = Counter(sum(int(d) for d in str(i)) for i in range(1, n+1))
        max_size = max(cnt.values())
        return sum(1 for v in cnt.values() if v == max_size)
