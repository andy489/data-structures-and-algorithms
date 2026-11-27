# 3351. Sum of Good Subsequences — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sum-of-good-subsequences/

---

## Solution: DP with Hash Map (Count + Sum Tracking) — O(n) time, O(n) space

**Idea:** For each value `v` in `nums`, we track two quantities:
- `cnt[v]` — the number of good subsequences ending with value `v`
- `sum[v]` — the total sum of all good subsequences ending with value `v`

When we process `nums[i] = v`, any good subsequence ending in `v-1` or `v+1` can be extended by appending `v`. A single-element subsequence `[v]` is also valid.

**Algorithm:**
1. Maintain two maps `cnt` and `sum` keyed by value.
2. For each `v = nums[i]`:
   - `newCnt = cnt[v-1] + cnt[v+1] + 1` (the +1 is the single-element subsequence)
   - `newSum = sum[v-1] + sum[v+1] + v * newCnt` (extend all reachable subseqs, then add v to each)
   - Update `cnt[v] += newCnt` and `sum[v] += newSum` (accumulate over all occurrences of v)
3. The answer is the sum of all values in `sum`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over nums, O(1) hash map ops per element |
| Space | O(n) — hash maps store at most `max(nums)` distinct keys |
