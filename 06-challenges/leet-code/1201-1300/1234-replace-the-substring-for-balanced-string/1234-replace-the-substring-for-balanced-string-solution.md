# 1234. Replace the Substring for Balanced String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/replace-the-substring-for-balanced-string/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Count outside-window characters. We need the window to allow redistribution: all characters outside window must have count ≤ n/4. Shrink window while valid.

**Algorithm:**
1. Count total frequencies.
2. Slide window: decrement count as right pointer advances.
3. Shrink left while all outer counts ≤ n/4.
4. Track min window.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
