# 1208. Get Equal Substrings Within Budget — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/get-equal-substrings-within-budget/

---

## Solution: Sliding Window — O(n) time, O(n) space

**Idea:** Use a sliding window. Expand the right pointer; when cost exceeds maxCost, shrink from the left.

**Algorithm:**
1. Precompute cost[i] = |s[i]-t[i]|.
2. Maintain window sum; if sum > maxCost, advance left pointer.
3. Track maximum window size.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
