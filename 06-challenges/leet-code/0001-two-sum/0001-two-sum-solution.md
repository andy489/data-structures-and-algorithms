# 1. Two Sum — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/two-sum/

---

## Solution

### Brute Force — O(n²) time, O(1) space

Try every pair `(i, j)` with `i < j` and check if `nums[i] + nums[j] == target`. Simple but slow for large inputs.

### Optimal — Hash Map — O(n) time, O(n) space

**Idea:** For each element `nums[i]`, the complement we need is `target - nums[i]`. If we've seen that complement before, we're done. A hash map lets us look up any previously seen value in O(1).

**Algorithm:**
1. Create an empty hash map `seen` mapping value → index.
2. For each index `i`:
   - Compute `complement = target - nums[i]`.
   - If `complement` is in `seen`, return `{seen[complement], i}`.
   - Otherwise, store `seen[nums[i]] = i`.

**Why it works:** The exact complement we need for the current element would have been stored in a previous iteration (or will be stored in a future one — but we always find it at the later of the two indices).

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — hash map stores up to n entries |
