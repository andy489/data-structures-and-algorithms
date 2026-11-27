# 948. Bag of Tokens — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bag-of-tokens/

---

## Solution: Sort + Two Pointers (Greedy) — O(n log n) time, O(1) space

**Idea:** Sort tokens. Greedily play cheapest token face-up (gain score) or sell most expensive face-down (gain power). Track max score seen.

**Algorithm:**
1. Sort tokens. Use lo/hi pointers.
2. While lo ≤ hi: if can afford lo, play face-up (power -= tokens[lo], score++, lo++). Else if score > 0, sell hi (power += tokens[hi], score--, hi--). Else break.
3. Track max score.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
