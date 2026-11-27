# https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/

from typing import List
from sortedcontainers import SortedList


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        from collections import defaultdict
        n = len(nums)
        answer = []
        freq = defaultdict(int)
        # SortedList of (freq, value) tuples, ascending
        top = SortedList()
        bottom = SortedList()
        top_sum = 0

        def add_to_top(f, v):
            nonlocal top_sum
            top.add((f, v))
            top_sum += f * v

        def remove_from_top(f, v):
            nonlocal top_sum
            top.remove((f, v))
            top_sum -= f * v

        def rebalance():
            nonlocal top_sum
            while len(top) > x:
                f, v = top[0]
                remove_from_top(f, v)
                bottom.add((f, v))
            while len(top) < x and bottom:
                f, v = bottom[-1]
                bottom.remove((f, v))
                add_to_top(f, v)

        for i in range(n):
            v = nums[i]
            old_f = freq[v]
            new_f = old_f + 1
            freq[v] = new_f
            if old_f > 0:
                if (old_f, v) in top:
                    remove_from_top(old_f, v)
                else:
                    bottom.remove((old_f, v))
            bottom.add((new_f, v))
            rebalance()

            if i >= k - 1:
                answer.append(top_sum)
                rem = nums[i - k + 1]
                rem_f = freq[rem]
                if (rem_f, rem) in top:
                    remove_from_top(rem_f, rem)
                else:
                    bottom.remove((rem_f, rem))
                if rem_f > 1:
                    bottom.add((rem_f - 1, rem))
                freq[rem] = rem_f - 1
                if freq[rem] == 0:
                    del freq[rem]
                rebalance()

        return answer
