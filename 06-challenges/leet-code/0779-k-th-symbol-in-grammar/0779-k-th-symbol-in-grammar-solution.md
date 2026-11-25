# 779. K-th Symbol in Grammar — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-th-symbol-in-grammar/

---

## Solution: Recursive Parent Lookup — O(n) time, O(n) space

**Idea:** The k-th symbol in row n comes from parent `ceil(k/2)` in row n-1. If k is odd, the child equals the parent; if k is even, the child is the flip of the parent.

**Algorithm:**
1. Base case: row 1 is always 0.
2. Find parent = `kthGrammar(n-1, (k+1)/2)`.
3. If k is odd: return parent; if k is even: return 1 - parent.

**Complexity:**

| | |
|---|---|
| Time | O(n) — recursion depth n |
| Space | O(n) — call stack |
