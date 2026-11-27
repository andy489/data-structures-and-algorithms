# 1220. Count Vowels Permutation — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-vowels-permutation/

---

## Solution: Dynamic Programming — O(n) time, O(1) space

**Idea:** Let dp[a], dp[e], dp[i], dp[o], dp[u] be the count of valid strings of current length ending with each vowel. Transition using the given rules (reversed: which vowels can PRECEDE each vowel).

**Algorithm:**
1. Init all to 1 for n=1.
2. For each step: new_a = e+i+u, new_e = a+i, new_i = e+o, new_o = i, new_u = i+o.
3. Sum all after n steps.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
