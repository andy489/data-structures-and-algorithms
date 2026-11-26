# 878. Nth Magical Number — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/nth-magical-number/

---

## Solution: Binary Search + Inclusion-Exclusion — O(log(n * min(a,b))) time, O(1) space

**Idea:** Count of magical numbers ≤ x is x/a + x/b - x/lcm(a,b). Binary search for the smallest x where this count is ≥ n.

**Algorithm:**
1. lcm = a * b / gcd(a, b).
2. Binary search lo=1, hi=n*min(a,b).
3. count(x) = x/a + x/b - x/lcm.
4. Find smallest x with count(x) >= n.

**Complexity:**

| | |
|---|---|
| Time | O(log(n * min(a,b))) |
| Space | O(1) |
