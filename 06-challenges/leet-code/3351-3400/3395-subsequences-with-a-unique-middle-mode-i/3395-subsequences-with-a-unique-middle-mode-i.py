# https://leetcode.com/problems/subsequences-with-a-unique-middle-mode-i/

from collections import defaultdict
from math import comb

class Solution:
    def subsequencesWithAUniqueMiddleMode(self, nums: list[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums)
        ans = 0
        left_map: dict[int, int] = defaultdict(int)

        for mid in range(2, n - 2):
            left_map[nums[mid - 1]] += 1
            m = nums[mid]
            lm = left_map[m]
            lt = mid

            right_map: dict[int, int] = defaultdict(int)
            for j in range(mid + 1, n):
                right_map[nums[j]] += 1
            rm = right_map[m]
            rt = n - mid - 1

            total = comb(lt, 2) * comb(rt, 2)
            bad = 0

            for v, lv in left_map.items():
                if v == m:
                    continue
                rv = right_map.get(v, 0)
                for lvc in range(min(lv, 2) + 1):
                    for rvc in range(min(rv, 2) + 1):
                        if lvc + rvc == 0:
                            continue
                        l_remain = 2 - lvc
                        r_remain = 2 - rvc
                        for lmc in range(min(lm, l_remain) + 1):
                            for rmc in range(min(rm, r_remain) + 1):
                                if lvc + rvc <= lmc + rmc:
                                    continue
                                l_other = l_remain - lmc
                                r_other = r_remain - rmc
                                l_pool = lt - lm - lv
                                r_pool = rt - rm - rv
                                if l_pool < l_other or r_pool < r_other:
                                    continue
                                ways = (comb(lv, lvc) * comb(lm, lmc) * comb(l_pool, l_other)
                                        * comb(rv, rvc) * comb(rm, rmc) * comb(r_pool, r_other))
                                bad = (bad + ways) % MOD

            ans = (ans + total - bad) % MOD

        return ans % MOD
