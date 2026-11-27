# https://leetcode.com/problems/count-good-integers-on-a-grid-path/
from functools import lru_cache
from typing import List


class Solution:
    def countGoodIntegers(self, l: int, r: int, directions: str) -> int:
        path_pos = self._compute_path(directions)

        def count_up_to(n: int) -> int:
            if n <= 0:
                return 0
            s = str(n).zfill(16)

            @lru_cache(maxsize=None)
            def dp(pos: int, tight: bool, last_path_val: int, path_idx: int) -> int:
                if pos == 16:
                    return 1 if path_idx == 7 else 0
                limit = int(s[pos]) if tight else 9
                res = 0
                for d in range(limit + 1):
                    is_path_pos = path_idx < 7 and path_pos[path_idx] == pos
                    if is_path_pos:
                        if last_path_val == -1 or d >= last_path_val:
                            res += dp(pos + 1, tight and d == limit, d, path_idx + 1)
                    else:
                        res += dp(pos + 1, tight and d == limit, last_path_val, path_idx)
                return res

            result = dp(0, True, -1, 0)
            dp.cache_clear()
            return result

        return count_up_to(r) - count_up_to(l - 1)

    def _compute_path(self, directions: str) -> List[int]:
        pos = []
        row, col = 0, 0
        pos.append(row * 4 + col)
        for ch in directions:
            if ch == 'D':
                row += 1
            else:
                col += 1
            pos.append(row * 4 + col)
        return pos
