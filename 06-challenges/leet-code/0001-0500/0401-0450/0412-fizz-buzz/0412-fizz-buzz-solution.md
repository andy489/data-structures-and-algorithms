# 412. Fizz Buzz — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/fizz-buzz/

---

## Solution: Simulation — O(n) time, O(n) space

**Idea:** Iterate from 1 to n, appending the appropriate string based on divisibility checks. Check divisibility by 15 first to correctly handle the FizzBuzz case.

**Algorithm:**
1. Create a result list.
2. For each `i` from 1 to `n`: if divisible by 15 → "FizzBuzz", by 3 → "Fizz", by 5 → "Buzz", else string of `i`.
3. Return the list.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — output list |
