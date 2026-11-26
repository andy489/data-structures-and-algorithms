# 1566. Detect Pattern of Length M Repeated K or More Times — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

---

## Solution: Linear Scan — O(n * m) time, O(1) space

**Idea:** A pattern of length `m` repeated `k` times requires that `arr[i] == arr[i + m]` for `m * (k-1)` consecutive valid positions. Count consecutive matches where `arr[i] == arr[i + m]`, resetting on any mismatch. When the count reaches `m * (k - 1)`, we found it.

**Algorithm:**
1. Iterate `i` from 0 to `n - m - 1`.
2. If `arr[i] == arr[i + m]`, increment count; else reset to 0.
3. If count reaches `m * (k - 1)`, return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — just a counter |
