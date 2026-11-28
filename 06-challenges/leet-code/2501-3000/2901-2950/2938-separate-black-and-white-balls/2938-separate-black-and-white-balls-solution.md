# 2938. Separate Black and White Balls — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/separate-black-and-white-balls/

---

## Solution: Greedy Two-Pointer Count — O(n) time, O(1) space

**Idea:** Count how many white balls (0s) each black ball (1) needs to jump over. Scan left to right; maintain a count of white balls seen so far. Each time we encounter a black ball, it needs to pass all the whites seen before it to reach its final position on the right.

**Algorithm:**
1. Initialize `whites = 0`, `moves = 0`.
2. For each character in `s`:
   - If `'0'`, increment `whites`.
   - If `'1'`, add `whites` to `moves`.
3. Return `moves`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
