# https://leetcode.com/problems/kth-distinct-string-in-an-array/

class Solution:
    def kthDistinct(self, arr: list[str], k: int) -> str:
        from collections import Counter
        freq = Counter(arr)
        count = 0
        for s in arr:
            if freq[s] == 1:
                count += 1
                if count == k:
                    return s
        return ""  
