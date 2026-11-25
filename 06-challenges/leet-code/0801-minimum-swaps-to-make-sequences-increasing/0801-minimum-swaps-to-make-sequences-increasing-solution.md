# 801. Minimum Swaps To Make Sequences Increasing — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

---

## Solution: Dynamic Programming — O(n) time, O(1) space

**Idea:** At each index, track two states: `keep` = min swaps to keep current elements in place, `swap` = min swaps when we swap at index i.

**Algorithm:**
1. Initialize `keep = 0`, `swap = 1`.
2. For each i from 1 to n-1, consider two cases:
   - Both pairs naturally increase: can keep or swap consistently.
   - Cross pairs increase: must swap one of them.
3. Update keep/swap based on which transitions are valid.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two variables |
