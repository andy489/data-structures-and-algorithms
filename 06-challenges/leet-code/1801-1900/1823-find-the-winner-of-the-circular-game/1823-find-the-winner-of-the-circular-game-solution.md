# 1823. Find the Winner of the Circular Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-winner-of-the-circular-game/

---

## Solution: Josephus Formula — O(n) time, O(1) space

**Idea:** This is the classic Josephus problem. With `n` people and every `k`th person eliminated, the survivor's 0-indexed position among `i` people can be computed iteratively: `pos(i) = (pos(i-1) + k) % i`, starting from `pos(1) = 0`. The final 1-indexed answer is `pos(n) + 1`.

**Algorithm:**
1. Initialize `pos = 0` (survivor position with 1 person).
2. For `i` from `2` to `n`: update `pos = (pos + k) % i`.
3. Return `pos + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — linear loop from 2 to n |
| Space | O(1) — single position variable |
