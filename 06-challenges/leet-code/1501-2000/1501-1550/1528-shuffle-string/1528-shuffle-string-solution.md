# 1528. Shuffle String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shuffle-string/

---

## Solution: Index Mapping — O(n) time, O(n) space

**Idea:** Allocate a result array and place each character at its destination index.

**Algorithm:**
1. Create a result array of size n.
2. For each index i, place `s[i]` at position `indices[i]` in result.
3. Convert result array to string.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — result array |
