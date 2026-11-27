# 1756. Design Most Recently Used Queue — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-most-recently-used-queue/

---

## Solution: ArrayList — O(n) per fetch, O(n) space

**Idea:** Store elements in an `ArrayList`. On `fetch(k)`, remove the element at index `k-1` and append it to the end. Given n ≤ 2000 and ≤ 2000 calls, O(n) per operation is acceptable.

**Algorithm:**
1. Initialize a list `[1, 2, ..., n]`.
2. For `fetch(k)`: remove element at index `k-1`, append it, return it.

**Complexity:**

| | |
|---|---|
| Time | O(n) per fetch — ArrayList removal requires shifting |
| Space | O(n) — the list |
