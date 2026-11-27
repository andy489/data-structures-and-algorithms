# 2001. Number of Pairs of Interchangeable Rectangles — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/

---

## Solution: HashMap of GCD-Reduced Ratios — O(n log m) time, O(n) space

**Idea:** Reduce each rectangle's `w:h` ratio using GCD. Count frequencies; for each group of size `c` add `c*(c-1)/2`.

**Algorithm:**
1. For each rectangle compute `g = gcd(w, h)`, key = `(w/g):(h/g)`.
2. Count frequency per key.
3. For count `c`, add `c*(c-1)/2` to result.

**Complexity:**

| | |
|---|---|
| Time | O(n log m) |
| Space | O(n) |
