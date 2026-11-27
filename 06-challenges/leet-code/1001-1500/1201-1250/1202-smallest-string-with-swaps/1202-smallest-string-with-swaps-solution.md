# 1202. Smallest String With Swaps — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-string-with-swaps/

---

## Solution: Union-Find — O(n log n) time, O(n) space

**Idea:** Use Union-Find to group indices that can be swapped. Within each group, sort the characters and place them back in sorted order.

**Algorithm:**
1. Build Union-Find from pairs.
2. Group indices by root.
3. Sort characters in each group and assign back in sorted order.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
