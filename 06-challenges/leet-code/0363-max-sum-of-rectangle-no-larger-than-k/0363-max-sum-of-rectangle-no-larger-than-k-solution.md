# 363. Max Sum of Rectangle No Larger Than K — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

---

## Solution: Column Compression + Prefix Sum + TreeSet — O(m² n log n) time, O(m) space

**Idea:** Fix left and right column boundaries. For each pair, compute row prefix sums. The problem reduces to: find the max subarray sum ≤ k using a sorted set of prefix sums.

**Algorithm:**
1. For each left column `l`:
2.   Build row sums; for each right column `r` accumulate into `rowSum[]`.
3.   Use a `TreeSet` of prefix sums; for each new prefix `p`, find the smallest prefix `≥ p - k` (via `ceiling`). Update answer as `p - ceiling`.

**Complexity:**

| | |
|---|---|
| Time | O(m² · n log n) |
| Space | O(m) — row sums and TreeSet |
