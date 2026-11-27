# 1806. Minimum Number of Operations to Reinitialize a Permutation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/

---

## Solution: Simulation — O(n^2) time, O(n) space

**Idea:** Directly simulate the permutation operation. After each application, check whether the array has returned to its initial state `[0, 1, 2, ..., n-1]`. Count the number of steps until it does.

**Algorithm:**
1. Initialize `perm` and `orig` both as `[0, 1, ..., n-1]`.
2. Repeatedly apply the shuffle rule: `arr[i] = perm[i/2]` for even `i`, `arr[i] = perm[n/2 + (i-1)/2]` for odd `i`.
3. Assign `arr` to `perm`, increment the operation counter.
4. Stop when `perm == orig`, return the counter.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — at most O(n) operations each of O(n) work |
| Space | O(n) — two arrays of size n |
