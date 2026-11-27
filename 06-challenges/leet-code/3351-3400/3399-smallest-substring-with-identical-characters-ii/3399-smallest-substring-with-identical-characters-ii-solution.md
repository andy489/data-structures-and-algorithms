# 3399. Smallest Substring With Identical Characters II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-substring-with-identical-characters-ii/

---

## Solution: Binary Search + Greedy Check — O(n log n) time, O(1) space

**Idea:** Identical approach to problem 3398. Binary search on the answer `maxLen`. For a given `maxLen`, greedily check if `numOps` flips suffice to break all identical runs to length ≤ `maxLen`.

The larger constraint (n up to 10^5) means O(n^2) would TLE, but the O(n log n) binary search solution works identically.

**Check function for a given `maxLen`:**
- Special case `maxLen == 1`: count flips needed for both alternating patterns (`0101...` and `1010...`), return true if the minimum ≤ numOps.
- General case `maxLen >= 2`: scan runs; each run of length `runLen` requires `floor((runLen - 1) / maxLen)` flips.

**Algorithm:**
1. Binary search `lo = 1`, `hi = n`.
2. For each `mid`, call `canAchieve(s, numOps, mid)`.
3. If achievable, `hi = mid`; otherwise `lo = mid + 1`.
4. Return `lo`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — binary search × O(n) check |
| Space | O(1) |
