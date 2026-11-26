# 1414. Find The Minimum Number Of Fibonacci Numbers Whose Sum Is K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

---

## Solution: Greedy Largest Fibonacci — O(log k) time, O(log k) space

**Idea:** Greedily subtract the largest Fibonacci number <= k at each step.

**Algorithm:**
1. Generate all Fibonacci numbers up to k.
2. Greedily pick the largest fib <= k, subtract it, increment count.
3. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(log k) |
| Space | O(log k) |
