# 3079. Find The Sum Of Encrypted Integers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-sum-of-encrypted-integers/

---

## Solution: Digit Manipulation — O(n * D) time, O(1) space

**Idea:** For each number, find the max digit, then build a number of same length with all digits equal to max digit.

**Algorithm:**
1. For each x: find max digit d and count digits len.
2. Encrypted = d * (10^len - 1) / 9 (repunit * d).
3. Sum all encrypted values.

**Complexity:**

| | |
|---|---|
| Time | O(n * D) — O(n * D) where D = number of digits |
| Space | O(1) — O(1) |
