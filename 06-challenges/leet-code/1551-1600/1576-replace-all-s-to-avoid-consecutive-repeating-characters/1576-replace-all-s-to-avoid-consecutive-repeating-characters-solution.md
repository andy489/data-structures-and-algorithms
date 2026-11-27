# 1576. Replace All ?'s to Avoid Consecutive Repeating Characters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

---

## Solution: Greedy Replacement — O(n) time, O(n) space

**Idea:** For each '?' character, pick the first character from 'a', 'b', 'c' that differs from both its left and right neighbors. Since we only have 2 possible conflicting neighbors, we can always find a valid character among these 3.

**Algorithm:**
1. Convert to character array.
2. For each '?', try 'a', 'b', 'c' in order; use the first that differs from both adjacent characters.
3. Return the resulting string.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass, inner loop is constant (at most 3 iterations) |
| Space | O(n) — character array copy |
