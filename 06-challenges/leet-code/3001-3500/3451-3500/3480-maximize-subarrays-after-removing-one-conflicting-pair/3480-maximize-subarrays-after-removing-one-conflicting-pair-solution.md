# 3480. Maximize Subarrays After Removing One Conflicting Pair — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/

---

## Solution: Greedy Sweep — O(n + m) time, O(n) space

**Idea:** For each right endpoint `r`, the minimum allowed left is `minLeft[r]` = max over all constraints `[a,b]` with `max(a,b) = r` of `min(a,b)`. The count of valid subarrays with right endpoint `r` is `r - minLeft[r]`. We want to remove one constraint to maximize the total. Track the top-2 constraints that impose the tightest restriction at each step and compute the bonus from removing each.

**Algorithm:**
1. Normalize each pair so `a < b`; group by `b`.
2. Sweep `r` from 1 to `n`: update `minLeft` using all pairs ending at `r`.
3. For each `r`, track which constraint causes the restriction; that constraint is a candidate for removal.
4. Compute total without any removal, then find max extra gain from removing one pair.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(n) |
