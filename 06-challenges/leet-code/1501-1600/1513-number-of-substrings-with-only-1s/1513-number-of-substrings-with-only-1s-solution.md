# 1513. Number of Substrings With Only 1s — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-substrings-with-only-1s/

---

## Solution: Running Count — O(n) time, O(1) space

**Idea:** For each consecutive run of `1`s of length `L`, the number of all-1 substrings is `L*(L+1)/2`. Alternatively, maintain a running count `cur` of consecutive `1`s. When we see a `1`, `cur++` and `result += cur` (since any substring ending here with length 1..cur is all-1s). When we see a `0`, reset `cur = 0`.

**Algorithm:**
1. `result = 0`, `cur = 0`.
2. For each character `c` in `s`:
   - If `c == '1'`: `cur++`, `result += cur`.
   - Else: `cur = 0`.
3. Return `result % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra |
