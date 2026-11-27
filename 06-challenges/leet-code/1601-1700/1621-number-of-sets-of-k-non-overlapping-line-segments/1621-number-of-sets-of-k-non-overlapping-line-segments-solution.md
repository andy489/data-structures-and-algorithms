# 1621. Number of Sets of K Non-Overlapping Line Segments — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/

---

## Solution: Combinatorics (Stars and Bars) — O(1) time, O(1) space

**Idea:** The problem reduces to choosing `2k` endpoints from `n` points (with repetition allowed for shared endpoints). The standard transformation: map each of `k` segments sharing endpoints into `k` segments on `n + k - 1` points without shared endpoints, then pick `2k` from `n + k - 1`. The answer is `C(n + k - 1, 2k)`.

**Algorithm:**
1. Compute `C(n + k - 1, 2k) mod (10^9 + 7)` using modular inverses (or Pascal's triangle for simplicity given `n <= 1000`).
2. Return the result.

**Complexity:**

| | |
|---|---|
| Time | O(n * k) — building the relevant part of Pascal's triangle |
| Space | O(n * k) — DP table |
