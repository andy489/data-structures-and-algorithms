# 952. Largest Component Size by Common Factor — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/largest-component-size-by-common-factor/

---

## Solution: Union-Find on Prime Factors — O(n√M) time, O(M) space

**Idea:** For each number, union it with all its prime factors. Numbers sharing a prime factor will be in the same component.

**Algorithm:**
1. For each num, find all prime factors.
2. Union each prime factor with the number's index.
3. Count component sizes, return max.

**Complexity:**

| | |
|---|---|
| Time | O(n√M) — M is max value, factor each number |
| Space | O(M) — Union-Find array |
