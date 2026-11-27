# https://leetcode.com/problems/count-the-number-of-powerful-integers/
class Solution:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        def count(n: int) -> int:
            if n <= 0:
                return 0
            t = str(n)
            t_len = len(t)
            s_len = len(s)
            if s_len > t_len:
                return 0
            pref_len = t_len - s_len
            result = 0

            # Count powerful integers with exactly `length` total digits, for length < t_len
            for length in range(s_len, t_len):
                p_len = length - s_len
                if p_len == 0:
                    if all(int(c) <= limit for c in s):
                        result += 1
                else:
                    result += limit * (limit + 1) ** (p_len - 1)

            # Count powerful integers with exactly t_len digits that are <= n
            tight = True
            for i in range(pref_len):
                t_digit = int(t[i])
                lo = 1 if i == 0 else 0
                hi = min(t_digit - 1, limit) if tight else limit
                if hi >= lo:
                    result += (hi - lo + 1) * (limit + 1) ** (pref_len - i - 1)
                if not tight or t_digit > limit:
                    tight = False
                    break

            if tight:
                candidate = t[:pref_len] + s
                if int(candidate) <= n:
                    result += 1

            return result

        return count(finish) - count(start - 1)
