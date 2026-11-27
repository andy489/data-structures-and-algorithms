# https://leetcode.com/problems/sum-of-k-mirror-numbers/

class Solution:
    def kMirror(self, k: int, n: int) -> int:
        def to_base(num, base):
            if num == 0:
                return '0'
            digits = []
            while num:
                digits.append(num % base)
                num //= base
            return ''.join(map(str, reversed(digits)))
        def is_palin(s):
            return s == s[::-1]
        def gen_palins(length):
            half = (length + 1) // 2
            for half_num in range(10**(half-1), 10**half):
                s = str(half_num)
                if length % 2 == 0:
                    p = s + s[::-1]
                else:
                    p = s + s[-2::-1]
                yield int(p)
        total, found = 0, 0
        for length in range(1, 100):
            for p in gen_palins(length):
                if is_palin(to_base(p, k)):
                    total += p
                    found += 1
                    if found == n:
                        return total
        return total
