# https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

class Solution:
    def canArrange(self, arr: list[int], k: int) -> bool:
        freq = [0] * k
        for v in arr:
            freq[v % k] += 1
        if freq[0] % 2 != 0:
            return False
        for r in range(1, k // 2 + 1):
            if r == k - r:
                if freq[r] % 2 != 0:
                    return False
            elif freq[r] != freq[k - r]:
                return False
        return True
