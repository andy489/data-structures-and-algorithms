# 268. Missing Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/missing-number/

---

## Solution 1: Gauss Sum — O(n) time, O(1) space

**Idea:** The expected sum of `[0..n]` is `n*(n+1)/2`. Subtract the actual array sum to get the missing number.

**Algorithm:**
1. Compute `expected = n * (n + 1) / 2`.
2. Subtract each element from `expected`.
3. Return the result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — no extra space |

---

## Solution 2: XOR — O(n) time, O(1) space

**Idea:** XOR all indices `0..n` and all array values. Every value that appears in both cancels out, leaving only the missing number.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — no extra space |
