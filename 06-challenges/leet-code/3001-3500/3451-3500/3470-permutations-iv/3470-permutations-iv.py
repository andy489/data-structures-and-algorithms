# https://leetcode.com/problems/permutations-iv/

from functools import lru_cache

class Solution:
    def permute(self, n: int, k: int) -> list[int]:
        odd_total = (n + 1) // 2
        even_total = n // 2

        # count(o, e, last): # of alternating perms with o odds and e evens left, last parity
        # last: 0 = last was odd (must place even), 1 = last was even (must place odd)
        @lru_cache(maxsize=None)
        def count(o, e, last):
            if o == 0 and e == 0:
                return 1
            result = 0
            if last != 0 and o > 0:  # can place odd
                result += o * count(o - 1, e, 0)
            if last != 1 and e > 0:  # can place even
                result += e * count(o, e - 1, 1)
            return result

        total = count(odd_total, even_total, -1)
        if k > total:
            return []

        result = []
        used_odds = set()
        used_evens = set()
        last = -1

        for _ in range(n):
            o_left = odd_total - len(used_odds)
            e_left = even_total - len(used_evens)
            # Build sorted candidates
            odds = sorted(x for x in range(1, n + 1, 2) if x not in used_odds)
            evens = sorted(x for x in range(2, n + 1, 2) if x not in used_evens)
            if last == 0:
                candidates = evens
            elif last == 1:
                candidates = odds
            else:
                candidates = sorted(odds + evens)

            for cand in candidates:
                is_odd = cand % 2 == 1
                new_o = o_left - (1 if is_odd else 0)
                new_e = e_left - (0 if is_odd else 1)
                new_last = 0 if is_odd else 1
                ways = count(new_o, new_e, new_last)
                if k <= ways:
                    result.append(cand)
                    if is_odd:
                        used_odds.add(cand)
                    else:
                        used_evens.add(cand)
                    last = new_last
                    break
                k -= ways

        return result
