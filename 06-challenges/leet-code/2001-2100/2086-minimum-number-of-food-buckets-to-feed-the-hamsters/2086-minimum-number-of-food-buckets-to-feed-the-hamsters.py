# https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/

class Solution:
    def minimumBuckets(self, hamsters: str) -> int:
        h = list(hamsters)
        n, count = len(h), 0
        for i in range(n):
            if h[i] == 'H':
                if i + 1 < n and h[i+1] == '#':
                    h[i+1] = 'B'
                    count += 1
                elif i - 1 >= 0 and h[i-1] == '#':
                    count += 1
                else:
                    return -1
        return count
