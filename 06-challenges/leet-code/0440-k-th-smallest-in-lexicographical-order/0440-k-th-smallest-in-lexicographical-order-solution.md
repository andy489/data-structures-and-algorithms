# 440. K-th Smallest in Lexicographical Order — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/

---

## Solution: Prefix Tree Counting — O(log²n) time, O(1) space

**Idea:** Think of the numbers as a 10-ary trie. Starting at prefix `curr = 1`, count how many numbers fall under that prefix subtree. If the subtree has ≥ k nodes, go deeper (curr *= 10, k stays). Otherwise, skip the subtree (curr++, k -= subtree size).

**Algorithm:**
1. Start with `curr = 1`, `k -= 1` (we've "used" position 1).
2. Count nodes under prefix `curr` vs `curr+1` up to `n` using a helper.
3. If `steps <= k`: skip this subtree (`curr++`, `k -= steps`).
4. Else: descend into it (`curr *= 10`, `k--`).
5. Repeat until `k == 0`, return `curr`.

**Complexity:**

| | |
|---|---|
| Time | O(log²n) — O(logn) iterations × O(logn) steps per count |
| Space | O(1) |
