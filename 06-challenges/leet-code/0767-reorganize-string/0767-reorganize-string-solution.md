# 767. Reorganize String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reorganize-string/

---

## Solution: Max-Heap Greedy — O(n log k) time, O(k) space

**Idea:** Always pick the most frequent character that isn't the same as the previous character placed. Use a max-heap. If the most frequent character is the same as the last placed, use the second-most frequent.

**Algorithm:**
1. Count character frequencies.
2. If max frequency > (n+1)/2, return "".
3. Build max-heap of `(-count, char)`.
4. Each step: pop the most frequent, append to result, re-push with decremented count.
   If it matches the previous character, pop two characters and handle accordingly.

**Complexity:**

| | |
|---|---|
| Time | O(n log k) — k = 26 |
| Space | O(k) — heap |
