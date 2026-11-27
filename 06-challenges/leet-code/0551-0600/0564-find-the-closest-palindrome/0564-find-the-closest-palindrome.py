class Solution:
    def nearestPalindromic(self, n: str) -> str:
        num = int(n)
        length = len(n)
        candidates = set()
        candidates.add(10 ** (length - 1) - 1)
        candidates.add(10 ** length + 1)
        prefix = int(n[:(length + 1) // 2])
        for p in [prefix - 1, prefix, prefix + 1]:
            half = str(p)
            if length % 2 == 0:
                candidate = half + half[::-1]
            else:
                candidate = half + half[:-1][::-1]
            candidates.add(int(candidate))
        candidates.discard(num)
        return str(min(candidates, key=lambda x: (abs(x - num), x)))
