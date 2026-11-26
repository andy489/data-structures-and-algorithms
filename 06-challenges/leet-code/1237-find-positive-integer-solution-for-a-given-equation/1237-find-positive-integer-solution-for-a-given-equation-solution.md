# 1237. Find Positive Integer Solution for a Given Equation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

---

## Solution: Two Pointers — O(x+y) time, O(1) space

**Idea:** Start with x=1, y=1000 (max). Move x right if f(x,y)<z, y left if f(x,y)>z, collect if equal.

**Algorithm:**
1. x starts at 1, y starts at max (1000).
2. If f(x,y)==z: add, increment x, decrement y.
3. If f(x,y)<z: increment x.
4. If f(x,y)>z: decrement y.

**Complexity:**

| | |
|---|---|
| Time | O(x+y) |
| Space | O(1) |
