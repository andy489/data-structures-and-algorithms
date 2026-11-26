# 1013. Partition Array Into Three Parts With Equal Sum — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Total sum must be divisible by 3. Scan for first two partition points (prefix sums == total/3 and 2*total/3), ensuring the third part is non-empty.

**Algorithm:**
1. If sum % 3 != 0, return false.
2. target = sum / 3. Scan accumulating prefix, count how many times we hit target and 2*target.
3. Need to find target at some index i < n-1, then 2*target at some index j < n.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
