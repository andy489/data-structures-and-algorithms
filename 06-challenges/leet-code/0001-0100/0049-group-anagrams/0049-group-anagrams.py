# https://leetcode.com/problems/group-anagrams/

from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        grouped = defaultdict(list)
        for s in strs:
            grouped[tuple(sorted(s))].append(s)
        return list(grouped.values())
