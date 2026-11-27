# 3398. Smallest Substring With Identical Characters I — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-substring-with-identical-characters-i/

---

## Solution: Binary Search + Greedy Check — O(n log n) time, O(1) space

**Idea:** Binary search on the answer `maxLen` (the maximum allowed run length). For a given `maxLen`, use a greedy check to determine whether `numOps` flips are sufficient to ensure no run of identical characters exceeds `maxLen`.

**Check function for a given `maxLen`:**
- Special case: `maxLen == 1`. The optimal pattern is alternating `0101...` or `1010...`. Count flips needed for each pattern and return the minimum. If min ≤ numOps, return true.
- General case `maxLen >= 2`: scan runs of identical characters. For each run of length `runLen`, we need `floor((runLen - 1) / maxLen)` flips to split it so no segment exceeds `maxLen`.

**Algorithm:**
1. Binary search `lo = 1`, `hi = n`.
2. For each mid `= (lo + hi) / 2`, call `canAchieve(s, numOps, mid)`.
3. If achievable, `hi = mid`; otherwise `lo = mid + 1`.
4. Return `lo`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — binary search × O(n) check |
| Space | O(1) |
