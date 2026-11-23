# 600. Non-negative Integers without Consecutive Ones — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/

---

## Solution: Fibonacci / Digit DP — O(log n) time, O(log n) space

**Idea:** Use the property that the count of k-bit numbers without consecutive ones follows Fibonacci. For each bit in `n` from MSB to LSB:
- If bit `i` is 1 and bit `i-1` (the next bit in `n`) is also 1, all numbers with the current prefix and bit `i` clear are valid — use Fibonacci table to count them and stop.
- If we encounter `11` in `n`, count all valid numbers up to but not including this point and add 1 (for n itself only if no consecutive ones found).

**Precompute** `fib[i]` = count of valid i-bit numbers (Fibonacci: `fib[1]=2, fib[2]=3, fib[k]=fib[k-1]+fib[k-2]`).

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(log n) |
