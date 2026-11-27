# 1652. Defuse the Bomb — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/defuse-the-bomb/

---

## Solution: Sliding Window / Prefix Sum — O(n) time, O(n) space

**Idea:** Build a doubled array for circular access, then slide a window of size `|k|`.

**Algorithm:**
1. If `k == 0`, return all zeros.
2. Build prefix sums on the doubled array `code + code`.
3. For each index `i`:
   - If `k > 0`, window is `[i+1, i+k]`.
   - If `k < 0`, window is `[i-|k|+n, i-1+n]` (modular indexing via doubling).
4. Compute window sum from prefix sums.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
