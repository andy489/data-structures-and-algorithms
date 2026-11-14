# 80. Remove Duplicates from Sorted Array II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use a write pointer `k` initialized to `0`. For each element `nums[i]`, write it only if `k < 2` (first two elements always go in) or `nums[i] != nums[k - 2]` (the candidate differs from what was written two positions back, so we haven't yet placed two copies of it). This generalizes cleanly to any "at most m duplicates" problem by replacing `2` with `m`.

**Algorithm:**
1. Initialize `k = 0`.
2. For each element `x` in `nums`:
   - If `k < 2` or `x != nums[k - 2]`, set `nums[k++] = x`.
3. Return `k`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — in-place |
