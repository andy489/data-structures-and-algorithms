# 894. All Possible Full Binary Trees — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/all-possible-full-binary-trees/

---

## Solution: Recursion with Memoization — O(2^n) time, O(2^n) space

**Idea:** A full binary tree with n nodes (n must be odd): root + left subtree of size L + right subtree of size n-1-L, for all odd L from 1 to n-2. Memoize by n.

**Algorithm:**
1. If n == 1, return [leaf node].
2. If n even, return [].
3. For L in 1,3,...,n-2: combine all left trees (size L) × all right trees (size n-1-L).

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — Catalan number of trees |
| Space | O(2^n) — memoization |
