# https://leetcode.com/problems/longest-uncommon-subsequence-ii/

class Solution:
    def findLUSlength(self, strs: list[str]) -> int:
        def is_subseq(s: str, t: str) -> bool:
            it = iter(t)
            return all(c in it for c in s)

        result = -1
        for i, s in enumerate(strs):
            if not any(is_subseq(s, strs[j]) for j in range(len(strs)) if i != j):
                result = max(result, len(s))
        return result
