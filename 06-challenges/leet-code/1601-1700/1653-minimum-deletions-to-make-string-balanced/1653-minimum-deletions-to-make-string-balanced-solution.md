# 1653. Minimum Deletions to Make String Balanced — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

---

## Solution: Greedy (One Pass) — O(n) time, O(1) space

**Idea:** Scan left to right. Keep track of the count of `'b'`s seen so far. When we encounter `'a'`, we have two choices: delete this `'a'` (cost 1) or delete all `'b'`s seen so far. We take the minimum.

**Algorithm:**
1. Initialize `bCount = 0`, `deletions = 0`.
2. For each character `c`:
   - If `c == 'b'`: `bCount++`.
   - If `c == 'a'`: `deletions = min(deletions + 1, bCount)` (delete this 'a', or switch to deleting 'b's).
3. Return `deletions`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
