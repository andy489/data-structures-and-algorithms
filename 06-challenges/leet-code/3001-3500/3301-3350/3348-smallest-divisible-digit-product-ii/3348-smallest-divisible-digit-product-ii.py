# https://leetcode.com/problems/smallest-divisible-digit-product-ii/

# Solution: Prime Factorization + Greedy Digit Construction
class Solution:
    # Contribution of each digit (1-9) to prime factors [2, 3, 5, 7]
    CONTRIB = [
        [0, 0, 0, 0],  # 0 unused
        [0, 0, 0, 0],  # 1
        [1, 0, 0, 0],  # 2
        [0, 1, 0, 0],  # 3
        [2, 0, 0, 0],  # 4
        [0, 0, 1, 0],  # 5
        [1, 1, 0, 0],  # 6
        [0, 0, 0, 1],  # 7
        [3, 0, 0, 0],  # 8
        [0, 2, 0, 0],  # 9
    ]

    def smallestNumber(self, num: str, t: int) -> str:
        # Factorize t
        primes = [2, 3, 5, 7]
        need = [0] * 4
        rem = t
        for i, p in enumerate(primes):
            while rem % p == 0:
                need[i] += 1
                rem //= p
        if rem > 1:
            return "-1"

        n = len(num)
        digits = [int(c) for c in num]

        # Try same length with tight constraint
        res = self._dfs(digits, need[:], 0, True)
        if res is not None:
            return res

        # Try longer lengths
        for length in range(n + 1, n + 51):
            res = self._build_min_len(length, need)
            if res is not None:
                return res
        return "-1"

    def _dfs(self, digits, need, pos, tight):
        n = len(digits)
        if pos == n:
            return "" if all(x <= 0 for x in need) else None
        lo = digits[pos] if tight else 1
        if lo == 0:
            lo = 1
        for d in range(lo, 10):
            new_need = [max(0, need[i] - self.CONTRIB[d][i]) for i in range(4)]
            suffix = self._dfs(digits, new_need, pos + 1, tight and d == digits[pos])
            if suffix is not None:
                return str(d) + suffix
        return None

    def _build_min_len(self, length, orig_need):
        need = orig_need[:]
        extra = []
        while any(x > 0 for x in need):
            best_d, best_score, best_need = -1, -1, None
            for d in range(2, 10):
                score = sum(min(need[i], self.CONTRIB[d][i]) for i in range(4))
                after = [need[i] - min(need[i], self.CONTRIB[d][i]) for i in range(4)]
                if score > best_score:
                    best_score, best_d, best_need = score, d, after
            if best_score == 0:
                return None
            extra.append(best_d)
            need = best_need
        if len(extra) > length:
            return None
        extra.sort()
        ones = length - len(extra)
        return "1" * ones + "".join(str(d) for d in extra)
