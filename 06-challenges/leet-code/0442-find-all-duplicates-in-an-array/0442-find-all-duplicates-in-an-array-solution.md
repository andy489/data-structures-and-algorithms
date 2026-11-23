# 442. Find All Duplicates in an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-all-duplicates-in-an-array/

---

## Solution: Index Negation — O(n) time, O(1) space

**Idea:** Use the array itself as a visited marker. For each value `v`, negate `nums[|v|-1]`. If it's already negative when we try to negate it again, `v` is a duplicate.

**Algorithm:**
1. For each `num` in nums, compute index `idx = |num| - 1`.
2. If `nums[idx] < 0`: `idx+1` is a duplicate, add to result.
3. Otherwise: negate `nums[idx]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — no extra space (output list excluded) |
