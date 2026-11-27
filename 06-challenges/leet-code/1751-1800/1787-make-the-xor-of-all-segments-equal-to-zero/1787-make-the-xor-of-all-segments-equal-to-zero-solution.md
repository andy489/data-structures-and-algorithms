# 1787. Make the XOR of All Segments Equal to Zero — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/make-the-xor-of-all-segments-equal-to-zero/

---

## Solution: DP with XOR Grouping — O(k * 2^10) time, O(2^10) space

**Idea:** For XOR of every segment of size `k` to be zero, all segments of size `k` must XOR to 0. This means `nums[i] = nums[i+k]` for all valid `i` — the array must be periodic with period `k`. Also, `nums[0] XOR nums[1] XOR ... XOR nums[k-1] = 0`.

We group indices by their position mod `k`: group `j` = {j, j+k, j+2k, ...}. We need to pick one value per group such that XOR of all k chosen values = 0. We minimize the total number of changes.

DP: `dp[xor]` = minimum changes to achieve prefix XOR = `xor` considering groups so far.

For group `j` with `sz` elements and frequency map `cnt`:
- For each current XOR state `x` with cost `dp[x]`:
  - Option 1: change all `sz` elements to some new value `v` — cost `dp[x] + sz`, XOR becomes `x XOR v`.
  - Option 2: keep `cnt[v]` elements at value `v`, change `sz - cnt[v]` — cost `dp[x] + sz - cnt[v]`, XOR becomes `x XOR v`.

The "change all" case has the same minimum for any current `x`, so we track the global minimum and do a single pass optimization.

**Complexity:**

| | |
|---|---|
| Time | O(k * 2^10) — k groups, each scanned over 2^10 values |
| Space | O(2^10) — DP table |
