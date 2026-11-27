# 1630. Arithmetic Subarrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/arithmetic-subarrays/

---

## Solution: Sort + Check per Query — O(m * k log k) time, O(k) space

**Idea:** For each query `[l, r]`, extract the subarray, sort it, then verify that all consecutive differences are equal.

**Algorithm:**
1. For each query `(l, r)`:
   a. Extract `sub = nums[l..r]`.
   b. Sort `sub`.
   c. Compute `diff = sub[1] - sub[0]`.
   d. Check all consecutive pairs; if any differ from `diff`, mark `false`.
2. Collect results and return.

**Complexity:**

| | |
|---|---|
| Time | O(m * k log k) — m queries, each sorts a subarray of length k = r - l + 1 |
| Space | O(k) — subarray copy for sorting |
