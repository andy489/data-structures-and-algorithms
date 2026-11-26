# 1405. Longest Happy String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-happy-string/

---

## Solution: Greedy Max-Heap — O(n log 3) = O(n) time, O(1) space

**Idea:** Always append the character with the highest remaining count unless it would create 3 consecutive — then use the second highest.

**Algorithm:**
1. Use a max-heap of (count, char).
2. Pop the top. If the last 2 chars match it, pop the second top instead, re-push the first.
3. Append chosen char; push back if count > 0.

**Complexity:**

| | |
|---|---|
| Time | O(n log 3) = O(n) |
| Space | O(1) |
