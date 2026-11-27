# https://leetcode.com/problems/contains-duplicate-iii/

class Solution:
    def containsNearbyAlmostDuplicate(self, nums: list[int], indexDiff: int, valueDiff: int) -> bool:
        size = valueDiff + 1
        buckets: dict[int, int] = {}

        def get_bucket(v: int) -> int:
            return (v + 1) // size - 1 if v < 0 else v // size

        for i, v in enumerate(nums):
            bid = get_bucket(v)
            if bid in buckets:
                return True
            if bid - 1 in buckets and abs(v - buckets[bid - 1]) <= valueDiff:
                return True
            if bid + 1 in buckets and abs(v - buckets[bid + 1]) <= valueDiff:
                return True
            buckets[bid] = v
            if i >= indexDiff:
                del buckets[get_bucket(nums[i - indexDiff])]
        return False
