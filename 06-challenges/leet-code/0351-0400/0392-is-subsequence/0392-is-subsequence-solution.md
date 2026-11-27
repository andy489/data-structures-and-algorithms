# 392. Is Subsequence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/is-subsequence/

---

## Solution: Two Pointers — O(t) time, O(1) space

**Idea:** Use two pointers; advance the `s` pointer whenever characters match.

**Complexity:**

| | |
|---|---|
| Time | O(t) |
| Space | O(1) |

---

## Follow-up: Binary Search — O(t + k log t) for k queries

Pre-build a map from each character to its sorted list of indices in `t`. For each query, use binary search to greedily advance through `t`.
