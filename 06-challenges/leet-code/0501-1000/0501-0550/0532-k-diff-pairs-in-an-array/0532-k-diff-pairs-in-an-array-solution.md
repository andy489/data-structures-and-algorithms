# 532. K-diff Pairs in an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-diff-pairs-in-an-array/

---

## Solution: HashMap — O(n) time, O(n) space

**Idea:** Count frequencies in a map. For each unique number `x`:
- If `k == 0`: check if count[x] >= 2.
- If `k > 0`: check if `x + k` exists in the map.

This avoids duplicates naturally since we iterate unique keys only.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
