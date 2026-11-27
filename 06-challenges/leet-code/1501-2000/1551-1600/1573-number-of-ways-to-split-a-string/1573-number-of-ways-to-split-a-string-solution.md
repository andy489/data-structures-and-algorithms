# 1573. Number of Ways to Split a String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-ways-to-split-a-string/

---

## Solution: Count Ones and Math — O(n) time, O(1) space

**Idea:** Each third of the split must contain exactly `ones/3` ones. If `ones % 3 != 0`, return 0. If no ones, any split is valid: `C(n-1, 2)` ways. Otherwise, count the number of valid positions for the two cut points. The first cut can go in the gap between the `ones/3`-th and `(ones/3 + 1)`-th one, and similarly for the second.

**Algorithm:**
1. Count total ones. If not divisible by 3, return 0.
2. If zero ones, return `(n-1)*(n-2)/2 % MOD`.
3. Count gap1 = number of zero positions after the (ones/3)-th 1, gap2 = same after the (2*ones/3)-th 1.
4. Return `gap1 * gap2 % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes over the string |
| Space | O(1) — counters only |
