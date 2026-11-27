# 784. Letter Case Permutation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/letter-case-permutation/

---

## Solution: Backtracking — O(2^L * n) time, O(2^L * n) space

**Idea:** At each letter position, branch into two choices (lower/upper). Digits have no choice.

**Algorithm:**
1. Backtrack through the string.
2. At digit positions, continue without branching.
3. At letter positions, recurse with both lower and upper.

**Complexity:**

| | |
|---|---|
| Time | O(2^L × n) — L letters, n = string length |
| Space | O(2^L × n) — output size |
