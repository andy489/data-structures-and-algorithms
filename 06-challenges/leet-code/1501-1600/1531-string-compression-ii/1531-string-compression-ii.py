# https://leetcode.com/problems/string-compression-ii/

class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        from functools import lru_cache

        n = len(s)

        def run_length(cnt: int) -> int:
            if cnt == 0:
                return 0
            if cnt == 1:
                return 1
            if cnt < 10:
                return 2
            if cnt < 100:
                return 3
            return 4

        @lru_cache(maxsize=None)
        def dp(i: int, last: str, last_cnt: int, rem: int) -> int:
            if rem < 0:
                return float('inf')
            if i == n:
                return 0
            # delete current character
            delete = dp(i + 1, last, last_cnt, rem - 1)
            # keep current character
            if s[i] == last:
                keep = dp(i + 1, last, last_cnt + 1, rem) + (1 if last_cnt in (1, 9, 99) else 0)
            else:
                keep = dp(i + 1, s[i], 1, rem) + 1
            return min(delete, keep)

        return dp(0, '', 0, k)
