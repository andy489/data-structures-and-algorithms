# 1187. Make Array Strictly Increasing — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/make-array-strictly-increasing/

---

## Solution: DP with Binary Search — O(n·m·log m) time, O(n·m) space

**Idea:** Use DP where `dp[i][k]` = the minimum last value achievable at index `i` having made exactly `k` replacements so far. We track the minimum "effective last element" for each count of operations used.

Sort and deduplicate `arr2`. At each position `i` we have two choices:
1. Keep `arr1[i]`: valid if `arr1[i] > dp[i-1][k]`; set `dp[i][k] = arr1[i]`.
2. Replace `arr1[i]` with the smallest `arr2[j]` greater than `dp[i-1][k-1]` (found via binary search); costs one extra operation.

Use a map `{ops_used -> min_last_value}` and update it at each position.

**Algorithm:**
1. Sort and deduplicate `arr2`.
2. Initialise `cloned = {0: -1}` (0 ops used, last value is -infinity).
3. For each index `i`, build a new map by trying keep and replace for each entry.
4. If the new map is empty after processing all positions, return -1; otherwise return the minimum key.

**Complexity:**

| | |
|---|---|
| Time | O(n · m · log m) — n positions, up to m entries per DP state, binary search in arr2 |
| Space | O(n · m) — DP map |
