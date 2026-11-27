# Solution for 3914. Minimum Operations to Make Array Non Decreasing

## Approach

**Greedy / Stack-based observation:**

The minimum sum of `x` values equals the sum of all "drops" in the array when scanning right to left. Specifically:

For an array to be non-decreasing, whenever `nums[i] > nums[i+1]`, we need to raise `nums[i+1]` (and possibly further elements). The key insight is:

**Reformulation:** We're doing range increases. The minimum total cost equals the sum of `max(0, prev_max - nums[i])` where `prev_max` is the maximum seen so far from the right... 

Actually, the correct insight: each operation covers a contiguous subarray. The optimal strategy is to "lift" each suffix independently. The minimum sum of x's equals:

For each position `i` from right to left, the amount we need to raise `nums[i]` to equal `nums[i+1]` after all raises. This can be computed greedily using a stack tracking the minimum required level.

**Correct approach:** The minimum total x is `sum of max(0, nums[i] - nums[i+1])` for all `i`. This is because each "drop" at position `i` to `i+1` requires increasing `nums[i+1]` (and beyond) by that drop amount, costing exactly that value as an x in one operation.

Wait, that's the sum of decreases: `sum_{i: nums[i]>nums[i+1]} (nums[i] - nums[i+1])`.

**Proof:** Each time nums[i] > nums[i+1], we can fix it with one operation on subarray [i+1, j] for the appropriate j, costing x = nums[i] - nums[i+1] (after accounting for previous fixes). The total is exactly the sum of all drops.

## Complexity

- Time: O(n)
- Space: O(1)
