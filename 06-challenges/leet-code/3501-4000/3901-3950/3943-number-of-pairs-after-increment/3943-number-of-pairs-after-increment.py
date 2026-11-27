# https://leetcode.com/problems/number-of-pairs-after-increment/
class Solution:
    def numberOfPairs(self, nums1: list[int], nums2: list[int], queries: list[list[int]]) -> list[int]:
        m = len(nums2)
        diff = [0] * (m + 1)
        results = []
        for q in queries:
            if q[0] == 1:
                x, y, val = q[1], q[2], q[3]
                diff[x] += val
                if y + 1 <= m - 1:
                    diff[y + 1] -= val
            else:
                tot = q[1]
                # Build current nums2 from diff array
                from collections import Counter
                freq: dict[int, int] = {}
                cum = 0
                for i in range(m):
                    cum += diff[i]
                    v = nums2[i] + cum
                    freq[v] = freq.get(v, 0) + 1
                count = 0
                for v1 in nums1:
                    target = tot - v1
                    count += freq.get(target, 0)
                results.append(count)
        return results
