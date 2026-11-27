# 761. Special Binary String — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/special-binary-string/

---

## Solution: Recursive Sort — O(n² log n) time, O(n) space

**Idea:** A special binary string of the form `1X0` where `X` is also special. Find all maximal special substrings, recursively maximize each, then sort them in descending order (greedy: largest first = lexicographically largest).

**Algorithm:**
1. Scan string with a counter: count++ for '1', count-- for '0'.
2. When count hits 0, we've found a special substring.
3. Recurse on the inner part (strip `1` prefix and `0` suffix).
4. Sort all special substrings descending.
5. Concatenate them.

**Complexity:**

| | |
|---|---|
| Time | O(n² log n) — recursion depth × sort |
| Space | O(n) — recursion stack |
