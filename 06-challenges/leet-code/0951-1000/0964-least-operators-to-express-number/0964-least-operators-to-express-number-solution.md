# 964. Least Operators to Express Number — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/least-operators-to-express-number/

---

## Solution: Digit DP on Base-x Representation — O(log target) time, O(1) space

**Idea:** Represent target in base x. Each digit tells how many x^k terms to include. Track the cost of using `d` terms vs `x-d` terms (complement).

**Algorithm:**
1. Decompose target in base x.
2. For each digit position, compute cost of adding d copies or (x-d) copies (carry up).
3. Each x^k term at position k costs 2k operators (except k=0 costs 2).

**Complexity:**

| | |
|---|---|
| Time | O(log target) |
| Space | O(1) |
