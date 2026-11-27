# https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/

class Solution:
    def kthSmallestProduct(self, nums1: list[int], nums2: list[int], k: int) -> int:
        import bisect
        def count(v):
            cnt = 0
            for x in nums1:
                if x > 0:
                    cnt += bisect.bisect_right(nums2, v // x) if v >= 0 or v % x == 0 else bisect.bisect_right(nums2, -((-v + x - 1) // x))
                    # simpler: cnt of b where x*b <= v
                    cnt2 = bisect.bisect_right(nums2, v // x if v % x == 0 or v > 0 else v // x - (1 if v % x != 0 else 0))
                elif x < 0:
                    threshold = -(-v // -x) if True else 0
                    cnt2 = len(nums2) - bisect.bisect_left(nums2, (v + x + 1) // x if v < 0 else v // x + (1 if v % x == 0 else 0))
                else:
                    cnt2 = len(nums2) if v >= 0 else 0
            return cnt
        # Cleaner version:
        def count2(v):
            res = 0
            m = len(nums2)
            for x in nums1:
                if x == 0:
                    if v >= 0: res += m
                elif x > 0:
                    res += bisect.bisect_right(nums2, v // x) if v >= 0 else bisect.bisect_left(nums2, (v - x + 1) // x + 1)
                else:
                    q, r = divmod(v, x)
                    if r != 0: q += 1
                    res += m - bisect.bisect_left(nums2, q)
            return res
        lo, hi = -10**10, 10**10
        while lo < hi:
            mid = (lo + hi) // 2
            if count2(mid) >= k: hi = mid
            else: lo = mid + 1
        return lo
