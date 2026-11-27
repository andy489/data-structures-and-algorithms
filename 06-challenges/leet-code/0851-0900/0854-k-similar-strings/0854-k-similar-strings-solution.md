# 854. K-Similar Strings — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/k-similar-strings/

---

## Solution: BFS — O(n! / (n-k)!) time, O(states) space

**Idea:** BFS on the state space of string transformations. Each level represents one swap. At each state, find the first position where s1 differs from s2 and try swapping it with any matching character to its right.

**Algorithm:**
1. BFS starting from s1.
2. At each string state, find the first index i where state[i] != s2[i].
3. For each j > i where state[j] == s2[i], generate new state by swapping i and j.
4. Track visited states. Return BFS level when s2 is reached.

**Complexity:**

| | |
|---|---|
| Time | O(n · |states|) — bounded in practice by pruning |
| Space | O(|states|) — visited set |
