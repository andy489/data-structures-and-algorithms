# 2038. Remove Colored Pieces if Both Neighbors Are the Same Color — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

---

## Solution: Count Runs — O(n) time, O(1) space

**Idea:** Count consecutive 'AAA' groups (Alice moves = sum(len-2)), similarly for 'BBB' groups.

**Algorithm:**
1. Count Alice moves: for each run of A's of length L, add L-2.
2. Count Bob moves similarly for B's.
3. Alice wins if Alice moves > Bob moves.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
