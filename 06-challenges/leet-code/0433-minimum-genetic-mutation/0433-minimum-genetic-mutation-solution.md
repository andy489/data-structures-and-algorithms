# 433. Minimum Genetic Mutation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-genetic-mutation/

---

## Solution: BFS — O(b * L) time, O(b) space

**Idea:** Model as a shortest-path problem in an unweighted graph. Each gene string is a node; two nodes are connected if they differ by exactly one character. BFS from startGene guarantees minimum mutations.

**Algorithm:**
1. Put all bank genes in a HashSet for O(1) lookup.
2. BFS from startGene; at each level try all single-character mutations using {A,C,G,T}.
3. If the mutated gene is in the bank (not yet visited), enqueue it.
4. Return level count when endGene is reached, or -1 if queue empties.

**Complexity:**

| | |
|---|---|
| Time | O(b * L) — b = bank size, L = gene length (8) |
| Space | O(b) — visited set |
