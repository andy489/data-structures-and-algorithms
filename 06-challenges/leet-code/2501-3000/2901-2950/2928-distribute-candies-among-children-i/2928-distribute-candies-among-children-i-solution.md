# 2928. Distribute Candies Among Children I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/distribute-candies-among-children-i/

---

## Solution: Brute Force Enumeration — O(limit²) time, O(1) space

**Idea:** Since `n` and `limit` are at most 50, enumerate all pairs `(i, j)` for the first two children where `0 <= i, j <= limit`, and check if the third child's share `n - i - j` is in `[0, limit]`.

**Algorithm:**
1. Initialize `count = 0`.
2. For `i` from `0` to `limit`:
   - For `j` from `0` to `limit`:
     - Let `k = n - i - j`.
     - If `0 <= k <= limit`, increment `count`.
3. Return `count`.

**Complexity:**

| | |
|---|---|
| Time | O(limit²) |
| Space | O(1) |
