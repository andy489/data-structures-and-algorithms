# 951. Flip Equivalent Binary Trees — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flip-equivalent-binary-trees/

---

## Solution: Recursive DFS — O(min(n1,n2)) time, O(min(h1,h2)) space

**Idea:** Two trees are flip equivalent if at each node either: (1) children match without flip, or (2) children match after flip.

**Algorithm:**
1. If both null → true. If one null or values differ → false.
2. Try matching children in-order and cross-order recursively.

**Complexity:**

| | |
|---|---|
| Time | O(min(n1,n2)) — we stop as soon as a mismatch is found |
| Space | O(min(h1,h2)) — recursion depth |
