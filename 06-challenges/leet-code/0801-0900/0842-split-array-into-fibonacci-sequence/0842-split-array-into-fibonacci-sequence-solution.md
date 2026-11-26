# 842. Split Array into Fibonacci Sequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-array-into-fibonacci-sequence/

---

## Solution: Backtracking — O(n · 2^n) worst case, O(n) space

**Idea:** Try all possible first two numbers, then greedily determine the rest of the sequence. Early termination when numbers exceed int range.

**Algorithm:**
1. Fix first number (try all prefixes up to 10 digits).
2. Fix second number (try all prefixes).
3. Greedily extend: next = prev1 + prev2; if it matches next prefix, continue; else backtrack.
4. Return sequence if it covers the whole string with ≥ 3 elements.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — O(n) choices for first, O(n) for second; rest is determined |
| Space | O(n) — recursion/sequence |
