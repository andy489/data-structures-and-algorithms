# 1671. Minimum Number of Removals to Make Mountain Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/

---

## Solution: LIS from Both Ends — O(n^2) time, O(n) space

**Idea:** For each index `i` as the peak, the longest mountain through `i` = LIS ending at `i` + LIS starting at `i` - 1 (the peak is counted once). The minimum removals = `n - max_mountain_length`.

**Algorithm:**
1. Compute `lis[i]` = length of longest increasing subsequence ending at index `i`.
2. Compute `lds[i]` = length of longest decreasing subsequence starting at index `i` (equivalently LIS from right).
3. For each valid peak `i` (where `lis[i] > 1` and `lds[i] > 1`), compute `lis[i] + lds[i] - 1`.
4. Return `n - max`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
