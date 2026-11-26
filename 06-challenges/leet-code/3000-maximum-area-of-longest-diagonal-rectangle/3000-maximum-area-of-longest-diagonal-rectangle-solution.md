# 3000. Maximum Area Of Longest Diagonal Rectangle — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Iterate over all rectangles, track the one with maximum diagonal (compare diagonal² = l²+w² to avoid sqrt). Among ties, take the larger area.

**Algorithm:**
1. For each rectangle compute diag2 = l*l + w*w.
2. Track maxDiag2 and maxArea.
3. If diag2 > maxDiag2: update both. If diag2 == maxDiag2: update maxArea if larger.
4. Return maxArea.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) — one pass |
| Space | O(1) — O(1) |
