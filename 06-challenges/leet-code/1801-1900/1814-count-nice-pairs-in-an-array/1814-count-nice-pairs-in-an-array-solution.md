# 1814. Count Nice Pairs in an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-nice-pairs-in-an-array/

---

## Solution: Group by (num - rev(num)) — O(n log n) time, O(n) space

**Idea:** Rearrange the condition: `nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])` is equivalent to `nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])`. So we just need to count pairs within groups of equal `x - rev(x)` values. For a group of size `c`, the number of pairs is `c * (c - 1) / 2`.

**Algorithm:**
1. For each `x` in `nums`, compute the key `x - rev(x)` and increment its frequency.
2. For each frequency `c`, add `c * (c - 1) / 2` to the answer.
3. Return the answer modulo `10^9 + 7`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — reversing a number takes O(log n) digits |
| Space | O(n) — frequency map |
