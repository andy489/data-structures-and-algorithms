# 1081. Smallest Subsequence of Distinct Characters — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

---

## Solution: Monotonic Stack (same as 316) — O(n) time, O(1) space

**Idea:** Track last occurrence of each char. Use a stack/visited approach: for each char, pop stack while top > current char and top appears later in s.

**Algorithm:**
1. Compute last occurrence of each character.
2. Iterate s with a stack and visited set. For each char c: if already in stack, skip. While stack top > c and top occurs later, pop. Push c.
3. Build result from stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
