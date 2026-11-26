# 1759. Count Number of Homogenous Substrings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-number-of-homogenous-substrings/

---

## Solution: Run-Length Encoding — O(n) time, O(1) space

**Idea:** A run of `k` identical characters contributes `k*(k+1)/2` homogenous substrings. Scan through the string counting each run length and accumulate the contribution.

**Algorithm:**
1. Walk through `s`, counting consecutive equal character runs.
2. For each run of length `k`, add `k*(k+1)/2` to the answer (mod 10^9+7).
3. Return the total.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
