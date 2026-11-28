# 3470. Permutations IV — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/permutations-iv/

---

## Solution: Factorial Number System — O(n^2) time, O(n) space

**Idea:** Count the total number of valid alternating permutations. Then use the factorial number system (like finding the k-th permutation) but restricted to alternating choices. At each position, determine which digit to place based on how many valid completions each choice would yield.

**Algorithm:**
1. Precompute count(oddLeft, evenLeft, lastParity) = number of valid completions given remaining odd and even counts and the parity of the last placed element.
2. Build the answer digit by digit: at each position, try candidates in sorted order. If count of completions with that candidate >= k, place it; otherwise subtract count and try next.
3. Handle big numbers with BigInteger or Python's arbitrary precision.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
