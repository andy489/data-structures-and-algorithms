# 78. Subsets — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subsets/

---

## Solution: Backtracking — O(n·2^n) time, O(n) space

**Idea:** At each index decide to include or skip the current element, recursing for the rest. Add the current subset to the result at every call (not just at leaves).

**Algorithm:**
1. Start with an empty `current` list and recurse from index `0`.
2. At each call add a copy of `current` to results.
3. For each index `i` from `start` to `n-1`: add `nums[i]`, recurse with `i+1`, then remove `nums[i]`.

**Complexity:**

| | |
|---|---|
| Time | O(n·2^n) — 2^n subsets, each copied in O(n) |
| Space | O(n) — recursion depth + current subset (output excluded) |

---

## Solution 2: Bit Manipulation — O(n·2^n) time, O(1) space

**Idea:** Each of the `2^n` integers from `0` to `2^n - 1` represents a bitmask where bit `j` being set means `nums[j]` is included in that subset.

**Algorithm:**
1. For `mask` from `0` to `2^n - 1`, build the subset by checking each bit.
2. Add every such subset to the result.

**Complexity:**

| | |
|---|---|
| Time | O(n·2^n) — 2^n masks, each scanned in O(n) |
| Space | O(1) — no auxiliary structures beyond output |
