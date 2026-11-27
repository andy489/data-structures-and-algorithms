# 3375. Minimum Operations to Make Array Values Equal to K — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/

---

## Solution: Count Distinct Values > k — O(n) time, O(n) space

**Idea:** Each operation selects a valid `h` and "flattens" all values strictly greater than `h` down to `h`. One operation can eliminate exactly one distinct value level. Therefore, the minimum number of operations equals the number of **distinct values strictly greater than k** in the array. If any value is **less than k**, it's impossible (return -1).

**Algorithm:**
1. For each `x` in `nums`: if `x < k` return -1.
2. Count the number of distinct values in `nums` that are strictly greater than `k`.
3. Return that count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — HashSet for distinct values |

## Solution 2: Sort + count — O(n log n) time, O(1) space

Same idea but with sorting instead of a set: sort, then count transitions between distinct values > k. The set approach is simpler and equally correct.
