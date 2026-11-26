# https://leetcode.com/problems/verbal-arithmetic-puzzle/

from itertools import permutations

class Solution:
    def isSolvable(self, words: list[str], result: str) -> bool:
        chars = list({c for w in words + [result] for c in w})
        no_lead = {w[0] for w in words + [result] if len(w) > 1}
        col_coef = {c: 0 for c in chars}
        max_len = max(len(w) for w in words + [result])
        for col in range(max_len):
            for w in words:
                idx = len(w) - 1 - col
                if idx >= 0:
                    col_coef[w[idx]] += 10**col
            idx = len(result) - 1 - col
            if idx >= 0:
                col_coef[result[idx]] -= 10**col
        chars = list(col_coef.keys())
        coefs = [col_coef[c] for c in chars]

        def bt(i, total, used):
            if i == len(chars):
                return total == 0
            for d in range(10):
                if d in used:
                    continue
                if d == 0 and chars[i] in no_lead:
                    continue
                used.add(d)
                if bt(i+1, total + coefs[i]*d, used):
                    return True
                used.discard(d)
            return False

        return bt(0, 0, set())
