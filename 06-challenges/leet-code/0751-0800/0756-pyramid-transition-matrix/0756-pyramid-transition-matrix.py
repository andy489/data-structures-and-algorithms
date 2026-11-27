# https://leetcode.com/problems/pyramid-transition-matrix/

from collections import defaultdict
from functools import lru_cache

class Solution:
    def pyramidTransition(self, bottom: str, allowed: list[str]) -> bool:
        rules = defaultdict(list)
        for s in allowed:
            rules[s[:2]].append(s[2])

        @lru_cache(maxsize=None)
        def dfs(cur):
            if len(cur) == 1:
                return True
            options_per_pos = [rules[cur[i:i+2]] for i in range(len(cur) - 1)]
            def build(pos, nxt):
                if pos == len(cur) - 1:
                    return dfs(nxt)
                for c in options_per_pos[pos]:
                    if build(pos + 1, nxt + c):
                        return True
                return False
            return build(0, '')

        return dfs(bottom)
