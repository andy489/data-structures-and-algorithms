# 1625. Lexicographically Smallest String After Applying Operations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/

---

## Solution: BFS / BFS with Visited Set — O(n * 10 * n/gcd(b,n)) time, O(states) space

**Idea:** Model all reachable strings as a BFS/DFS from the initial state. The number of distinct states is bounded: rotating has at most `n / gcd(b, n)` distinct positions, and adding has at most 10 distinct offsets for even positions (odd positions, since `a` is added to odd indices only). Use a visited set to avoid re-processing. Track the lexicographically smallest string seen.

**Algorithm:**
1. Use a queue initialized with the starting string.
2. For each state, generate two neighbors: apply `add` and apply `rotate`.
3. If a neighbor hasn't been visited, add it to the queue and visited set.
4. Track the minimum string among all visited states.
5. Return the minimum.

**Complexity:**

| | |
|---|---|
| Time | O(n * 10 * (n / gcd(b, n))) — bounded number of states times string length |
| Space | O(states * n) — visited set stores all reachable strings |
