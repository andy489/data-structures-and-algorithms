# 1201. Ugly Number III — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/ugly-number-iii/

---

## Solution: Inclusion-Exclusion + Binary Search — O(log(n * min(a,b))) time, O(1) space

**Idea:** Binary search on the answer. For a given value `m`, count ugly numbers ≤ m using inclusion-exclusion: count = m/a + m/b - m/lcm(a,b).

**Algorithm:**
1. Compute lcm(a,b) = a*b/gcd(a,b).
2. Binary search on answer: find smallest m where count(m) >= n.
3. count(m) = m/a + m/b - m/lcm(a,b).

**Complexity:**

| | |
|---|---|
| Time | O(log(n * min(a,b))) |
| Space | O(1) |
