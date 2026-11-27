# 1585. Check If String Is Transformable With Substring Sort Operations — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/

---

## Solution: Greedy with Queues — O(n) time, O(n) space

**Idea:** Sorting a substring only moves smaller digits to the left past larger ones. So to place digit `d` from `s` at the next position in `t`, no smaller digit must appear before it in `s`. Track index queues for each digit 0–9.

**Algorithm:**
1. Record positions of each digit in `s` using 10 queues.
2. For each character `d` in `t`, check if a matching position exists in `pos[d]`.
3. If any digit `< d` has its front position earlier than the front of `pos[d]`, return false (can't bubble `d` left past it).
4. Otherwise, consume the front of `pos[d]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each character processed once; inner loop over 10 digits is O(1) |
| Space | O(n) — queues hold all positions |
