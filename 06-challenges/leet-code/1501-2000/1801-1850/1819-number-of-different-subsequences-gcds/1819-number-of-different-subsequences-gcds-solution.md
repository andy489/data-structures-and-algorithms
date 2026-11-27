# 1819. Number of Different Subsequences GCDs — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-different-subsequences-gcds/

---

## Solution: Enumerate Candidates — O(max * log(max)) time, O(max) space

**Idea:** For each candidate GCD value `g` from 1 to `max(nums)`, check whether any subsequence of `nums` has GCD exactly `g`. A subsequence with GCD `g` exists if and only if the GCD of all multiples of `g` that appear in `nums` equals `g`. Iterate over multiples of `g` up to `max(nums)` and accumulate their GCD; if it reaches `g`, count it.

**Algorithm:**
1. Build a boolean presence array over values 1..max(nums).
2. For each `g` from 1 to max(nums), compute `gcd` of all present multiples of `g`. If the result equals `g`, increment the answer.
3. The total work is `max/1 + max/2 + ... = O(max * log(max))` by the harmonic series.

**Complexity:**

| | |
|---|---|
| Time | O(max * log(max)) — harmonic series over multiples |
| Space | O(max) — presence array |
