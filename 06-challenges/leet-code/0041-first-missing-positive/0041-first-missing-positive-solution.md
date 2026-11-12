# 41. First Missing Positive — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/first-missing-positive/

---

## Solution: Index-as-hash cyclic placement — O(n) time, O(1) space

**Idea:** For an array of length `n`, the answer is always in `[1, n+1]`. Use the array itself as a hash table: place each value `k` (where `1 ≤ k ≤ n`) at index `k-1` by swapping. After placement, the first index `i` where `nums[i] != i+1` reveals the answer `i+1`. If every position is correct, return `n+1`.

**Algorithm:**
1. For each index `i`, while `nums[i]` is in `[1, n]` and `nums[nums[i]-1] != nums[i]` (not already in place): swap `nums[i]` with `nums[nums[i]-1]`. The duplicate guard prevents infinite loops.
2. Scan left to right: the first `i` where `nums[i] != i+1` → return `i+1`.
3. If all positions are correct, return `n+1`.

**Why this works in O(1) space:** Each swap moves at least one element to its correct position, so the total number of swaps across the entire pass is at most `n` — the whole loop is O(n) overall, not O(n) per index.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element is swapped at most once to its final position |
| Space | O(1) — in-place, no auxiliary structures |
